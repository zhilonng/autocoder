package com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo;

import com.cj.tools.mybatisplus.entity.vo.CoderGeneratorPathVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class GeneratorVO extends CoderGeneratorPathVO {
    @ApiModelProperty("表名")
    @NotBlank(message = "不可为空")
    private String tableName;
    @ApiModelProperty("作者")
    @NotBlank(message = "不可为空")
    private String author;
    @ApiModelProperty("包名")
    @NotBlank(message = "不可为空")
    private String packageName;
}
