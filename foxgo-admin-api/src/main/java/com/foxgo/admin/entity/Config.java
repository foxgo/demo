package com.foxgo.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.foxgo.admin.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 配置
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@TableName("sys_config")
@ApiModel(value="Config对象", description="配置")
public class Config extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目名称")
    private String itemKey;

    @ApiModelProperty(value = "项目值")
    private String itemValue;

    @ApiModelProperty(value = "备注")
    private String remark;

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }
    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Config{" +
        "itemKey=" + itemKey +
        ", itemValue=" + itemValue +
        ", remark=" + remark +
        "}";
    }
}
