package com.cj.tools.mybatisplus.entity.vo;

import lombok.Data;

@Data
public class CoderGeneratorTableVO {
    private String tableName;
    private String entityPrefix;

    public CoderGeneratorTableVO(String tableName, String entityPrefix) {
        this.tableName = tableName;
        this.entityPrefix = entityPrefix;
    }
}
