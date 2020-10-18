package com.cj.tools.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhilonng
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ces_field_kongj")
@ApiModel(value="CesFieldKongj对象", description="")
public class CesFieldKongj extends Model<CesFieldKongj> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "创建日期")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty(value = "更新日期")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "所属部门")
    @TableField("sys_org_code")
    private String sysOrgCode;

    @ApiModelProperty(value = "用户名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "下拉框")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "radio")
    @TableField("radio")
    private String radio;

    @ApiModelProperty(value = "checkbox")
    @TableField("checkbox")
    private String checkbox;

    @ApiModelProperty(value = "下拉多选")
    @TableField("sel_mut")
    private String selMut;

    @ApiModelProperty(value = "下拉搜索")
    @TableField("sel_search")
    private String selSearch;

    @ApiModelProperty(value = "时间")
    @TableField("birthday")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "图片")
    @TableField("pic")
    private String pic;

    @ApiModelProperty(value = "文件")
    @TableField("files")
    private String files;

    @ApiModelProperty(value = "markdown")
    @TableField("remakr")
    private String remakr;

    @ApiModelProperty(value = "富文本")
    @TableField("fuwenb")
    private String fuwenb;

    @ApiModelProperty(value = "选择用户")
    @TableField("user_sel")
    private String userSel;

    @ApiModelProperty(value = "选择部门")
    @TableField("dep_sel")
    private String depSel;

    @ApiModelProperty(value = "DD类型")
    @TableField("ddd")
    private Double ddd;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
