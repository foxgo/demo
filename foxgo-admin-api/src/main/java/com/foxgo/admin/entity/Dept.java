package com.foxgo.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.foxgo.admin.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@TableName("sys_dept")
@ApiModel(value="Dept对象", description="部门")
public class Dept extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "上级部门ID，一级部门为0")
    private Integer parentId;

    @ApiModelProperty(value = "排序号")
    private Integer orderNum;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Dept{" +
        "deptName=" + deptName +
        ", parentId=" + parentId +
        ", orderNum=" + orderNum +
        "}";
    }
}
