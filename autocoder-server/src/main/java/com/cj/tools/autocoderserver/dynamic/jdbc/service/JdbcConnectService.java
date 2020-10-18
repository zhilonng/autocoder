package com.cj.tools.autocoderserver.dynamic.jdbc.service;

import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.JdbcConnectVO;

public interface JdbcConnectService {
    public Response connect(JdbcConnectVO jdbcConnectVO);
    public Response testConnect(JdbcConnectVO jdbcConnectVO);
    public Response testConnect();
}
