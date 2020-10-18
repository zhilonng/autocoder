package com.cj.tools.autocoderserver.dynamic.jdbc.service.impl;

import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.JdbcConnectVO;
import com.cj.tools.autocoderserver.dynamic.jdbc.service.JdbcConnectService;
import com.cj.tools.mybatisplus.dynamic.JdbcSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class JdbcConnectServiceImpl implements JdbcConnectService {
    @Override
    public Response connect(JdbcConnectVO jdbcConnectVO) {
        Boolean isConnect = JdbcSessionFactory.sqlTest(jdbcConnectVO.getJdbcUrl(), jdbcConnectVO.getName(), jdbcConnectVO.getPassword());
        if (isConnect) {
            JdbcSessionFactory.getInstance(jdbcConnectVO.getJdbcUrl(), jdbcConnectVO.getName(), jdbcConnectVO.getPassword());
        } else {
            return Response.error();
        }
        return Response.success();
    }

    @Override
    public Response testConnect(JdbcConnectVO jdbcConnectVO) {
        Boolean isConnect = JdbcSessionFactory.sqlTest(jdbcConnectVO.getJdbcUrl(), jdbcConnectVO.getName(), jdbcConnectVO.getPassword());
        if (isConnect) {
            return Response.success();
        } else {
            return Response.error();
        }
    }

    @Override
    public Response testConnect() {
        try {
            JdbcSessionFactory.tryGetInstance();
        } catch (RuntimeException ex) {
            return Response.error();
        }
        return Response.success();
    }
}
