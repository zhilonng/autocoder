package com.cj.tools.autocoderserver.dynamic.jdbc.entity.vo;

import com.cj.tools.autocoderserver.base.base.entity.vo.PageVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DBSearchVO extends PageVO {
    @ApiModelProperty("表名")
    private String tableName;
    @ApiModelProperty("表描述")
    private String tableDesc;
}
