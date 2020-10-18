package com.cj.tools.mybatisplus.dynamic;

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
