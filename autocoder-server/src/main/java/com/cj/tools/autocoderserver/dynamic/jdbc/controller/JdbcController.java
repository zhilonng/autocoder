package com.cj.tools.autocoderserver.dynamic.jdbc.controller;

import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.JdbcConnectVO;
import com.cj.tools.base.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "JDBC连接")
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @ApiOperation("连接数据库")
    @PostMapping("/connect")
    public void connect(@RequestBody JdbcConnectVO jdbcConnectVO) {
        Response.success(jdbcConnectVO);
    }
}
