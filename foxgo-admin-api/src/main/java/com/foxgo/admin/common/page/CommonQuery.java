package com.foxgo.admin.common.page;

public class CommonQuery extends BaseQuery {

    /**
    * 名称
    * */
    private String name;

    /**
     * 类型
     * */
    private Integer type;

    public CommonQuery() {
    }


    public String getName() {
        return this.name;
    }

    public Integer getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String toString() {
        return "CommonQuery(name=" + this.name + ", type=" + this.type + ")";
    }
}
