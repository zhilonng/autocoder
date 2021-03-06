package com.cj.tools.mybatisplus;

import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.cj.tools.mybatisplus.dynamic.CoderGenerator;
import com.cj.tools.mybatisplus.entity.vo.CoderGeneratorPathVO;
import com.cj.tools.mybatisplus.entity.vo.CoderGeneratorTableVO;

public class MySqlGenerator {

    public static void main(String[] args) {
        // 代码生成器
        String jdbcUrl = "jdbc:mysql://120.78.162.148:3306/jeecg-boot?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "AIRbriagE1001";
        CoderGeneratorPathVO coderGeneratorPathVO = new CoderGeneratorPathVO();
        coderGeneratorPathVO.setControllerOutputPath("/Users/zhilonng/Documents/test/autocoder/src/main/java/com/cj/tools/");
        coderGeneratorPathVO.setDaoOutputPath("/Users/zhilonng/Documents/test/autocoder/src/main/java/com/cj/tools/");
        coderGeneratorPathVO.setEntityOutputPath("/Users/zhilonng/Documents/test/autocoder/src/main/java/com/cj/tools/");
        coderGeneratorPathVO.setMapperOutputPath("/Users/zhilonng/Documents/test/autocoder/src/main/java/com/cj/tools/");
        coderGeneratorPathVO.setProjectPath("/Users/zhilonng/Documents/test/autocoder");
        coderGeneratorPathVO.setServiceOutputPath("/Users/zhilonng/Documents/test/autocoder/src/main/java/com/cj/tools/");
        coderGeneratorPathVO.setXmlOutputPath("/Users/zhilonng/Documents/test/autocoder/src/main/java/com/cj/tools/");


        CoderGenerator mpg = CoderGenerator.builder(coderGeneratorPathVO)
                .dataSourceConfig(jdbcUrl, "com.mysql.jdbc.Driver", username, password)
                .strategyConfig(new CoderGeneratorTableVO("sys_user", ""))
                .globalConfig("zhilong")
                .packageConfig("/com/cj/tools")
                .build();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
