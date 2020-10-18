package com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class JdbcConnectVO {
    @ApiModelProperty("jdbc地址")
    @NotBlank(message = "不可为空")
    private String jdbcUrl;
    @ApiModelProperty("用户")
    @NotBlank(message = "不可为空")
    private String name;
    @ApiModelProperty("密码")
    @NotBlank(message = "不可为空")
    private String password;
}
