package com.cj.tools.autocoderserver.dynamic.jdbc.service.impl;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.cj.tools.autocoderserver.base.base.Response;
import com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo.GeneratorVO;
import com.cj.tools.autocoderserver.dynamic.jdbc.service.GeneratorService;
import com.cj.tools.mybatisplus.dynamic.CoderGenerator;
import com.cj.tools.mybatisplus.dynamic.JdbcSessionFactory;
import com.cj.tools.mybatisplus.entity.vo.CoderGeneratorPathVO;
import com.cj.tools.mybatisplus.entity.vo.CoderGeneratorTableVO;
import org.springframework.stereotype.Service;

@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Override
    public Response generate(GeneratorVO generatorVO) {
        // 代码生成器
        DataSourceConfig dataSourceConfig = JdbcSessionFactory.tryGetInstance().getDataSourceConfig();

        CoderGenerator mpg = CoderGenerator.builder(generatorVO)
                .dataSourceConfig(dataSourceConfig)
                .strategyConfig(new CoderGeneratorTableVO(generatorVO.getTableName(), ""))
                .globalConfig(generatorVO.getAuthor())
                .packageConfig(generatorVO.getPackageName())
                .build();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
        return Response.success();
    }
}
