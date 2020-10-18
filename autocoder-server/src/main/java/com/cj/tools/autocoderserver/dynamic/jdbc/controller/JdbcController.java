package com.cj.tools.autocoderserver.dynamic.jdbc.controller;

import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.JdbcConnectVO;
import com.cj.tools.autocoderserver.dynamic.jdbc.service.JdbcConnectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "JDBC连接")
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    JdbcConnectService jdbcConnectService;

    @ApiOperation("连接数据库")
    @PostMapping("/testConnect")
    public Response test(@RequestBody JdbcConnectVO jdbcConnectVO) {
        return jdbcConnectService.testConnect(jdbcConnectVO);
    }

    @ApiOperation("开启应用")
    @PostMapping("/connect")
    public Response connect(@RequestBody JdbcConnectVO jdbcConnectVO) {
        return jdbcConnectService.connect(jdbcConnectVO);
    }

    @ApiOperation("是否连接中")
    @GetMapping("/isConnecting")
    public Response isConnecting() {
        return jdbcConnectService.testConnect();
    }
}
