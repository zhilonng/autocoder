package com.cj.tools.autocoderserver.dynamic.jdbc.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.DBSearchVO;
import com.cj.tools.autocoderserver.dynamic.jdbc.service.DBInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "数据库信息查询")
@RestController
@RequestMapping("/db")
public class DBInfoController {

    @Autowired
    DBInfoService dbInfoService;

    @ApiOperation("tables")
    @GetMapping("/tables")
    public Response tables(DBSearchVO dbSearchVO) {
        return dbInfoService.tables(dbSearchVO);
    }
}
