package com.foxgo.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.foxgo.admin.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 字典
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@TableName("sys_dict")
@ApiModel(value="Dict对象", description="字典")
public class Dict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典名称")
    private String dictName;

    @ApiModelProperty(value = "字典编码")
    private String dictCode;

    @ApiModelProperty(value = "小项名称")
    private String itemName;

    @ApiModelProperty(value = "小项数值")
    private Integer itemValue;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "排序号")
    private Integer orderNum;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }
    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getItemValue() {
        return itemValue;
    }

    public void setItemValue(Integer itemValue) {
        this.itemValue = itemValue;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Dict{" +
        "dictName=" + dictName +
        ", dictCode=" + dictCode +
        ", itemName=" + itemName +
        ", itemValue=" + itemValue +
        ", remark=" + remark +
        ", orderNum=" + orderNum +
        "}";
    }
}
