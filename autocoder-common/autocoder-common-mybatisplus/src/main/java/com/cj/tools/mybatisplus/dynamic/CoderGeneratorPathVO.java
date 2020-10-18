package com.cj.tools.mybatisplus.dynamic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CoderGeneratorPathVO {
    @ApiModelProperty("项目根路径")
    private String projectPath;
    @ApiModelProperty("实体类输出路径")
    private String entityOutputPath;
    @ApiModelProperty("mapper层输出路径")
    private String mapperOutputPath;
    @ApiModelProperty("dao层输出路径")
    private String daoOutputPath;
    @ApiModelProperty("xml输出路径")
    private String xmlOutputPath;
    @ApiModelProperty("服务层输出路径")
    private String serviceOutputPath;
    @ApiModelProperty("控制层输出路径")
    private String controllerOutputPath;
}
