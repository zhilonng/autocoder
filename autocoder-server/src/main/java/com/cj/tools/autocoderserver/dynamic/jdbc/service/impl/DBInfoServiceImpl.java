package com.cj.tools.autocoderserver.dynamic.jdbc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.DBSearchVO;
import com.cj.tools.autocoderserver.dynamic.jdbc.service.DBInfoService;
import com.cj.tools.mybatisplus.dynamic.JdbcSessionFactory;
import com.cj.tools.mybatisplus.mapper.TableMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DBInfoServiceImpl implements DBInfoService {
    @Override
    public Response<PageInfo<Map>> tables(DBSearchVO dbSearchVO) {
        SqlSession sqlSession = JdbcSessionFactory.tryGetInstance().getSqlSession();
        PageHelper.startPage(dbSearchVO.getPage(), dbSearchVO.getSize());
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        List<Map> result = tableMapper.listTable(dbSearchVO.getTableName(), dbSearchVO.getTableDesc());
        PageInfo<Map> pageInfo = new PageInfo<>(result);
        sqlSession.close();
        return Response.success(pageInfo);
    }
}
