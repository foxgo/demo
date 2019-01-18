package com.foxgo.admin.common.page;



public class BaseQuery {
    /**
     * 当前页码

     查询条件
     query criteria
     */
    private int page = 1;
    /**
     * 每页条数
     */
    private int limit = 10;
    /**
     * 排序 多个字段要逗号隔开，例如 select * from sys_config ORDER BY id DESC, remark ASC
     * */
    private String sort;


    public BaseQuery() {
    }

    public int getPage() {
        return this.page;
    }

    public int getLimit() {
        return this.limit;
    }

    public String getSort() {
        return this.sort;
    }



    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }




    public String toString() {
        return "BaseQuery(currPage=" + this.page + ", limit=" + this.limit + ", sort=" + this.sort + ")";
    }
}
