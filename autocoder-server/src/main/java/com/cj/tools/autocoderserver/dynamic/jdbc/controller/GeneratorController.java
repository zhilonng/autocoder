package com.cj.tools.autocoderserver.dynamic.jdbc.controller;

import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.GeneratorVO;
import com.cj.tools.autocoderserver.dynamic.jdbc.service.GeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "代码生成")
@RestController
@RequestMapping("/coder")
public class GeneratorController {
    @Autowired
    GeneratorService generatorService;

    @ApiOperation("生成")
    @PostMapping("/generate")
    public Response generate(@RequestBody GeneratorVO generatorVO) {
        return generatorService.generate(generatorVO);
    }
}
