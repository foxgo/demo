package com.foxgo.admin.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.foxgo.admin.common.util.SqlUtil;
import com.foxgo.admin.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class PageUtil {

    private static final Logger logger = LoggerFactory.getLogger(PageUtil.class);

    public static IPage buildPage(BaseQuery params) {
        /**
         * 当前页码
         */
        int currPage;
        /**
         * 每页条数
         */
        int limit;
        /**
         * 排序
         * */
        String sort;

        //分页参数
        currPage = params.getPage();
        limit = params.getLimit();

        //每页条数不得超过100，为了避免内存泄漏
        if (limit > 100) {
            limit = 100;
        }
        //mybatis-plus分页
        IPage page = new Page(currPage, limit);

        setOrder(page, params.getSort());

        return page;
    }

    /**
     * 排序 多个字段要逗号隔开，例如 select * from sys_config ORDER BY id desc, remark asc
     */
    private static void setOrder(IPage page, String sort) {
        try {
            sort = SqlUtil.sqlInject(sort); //防止SQL注入（因为order是通过拼接SQL实现排序的，会有SQL注入风险）
        } catch (Exception e) {
            logger.error(e.getMessage());
            return;
        }
        if (StringUtil.isBlank(sort)) {
            return;
        }
        String[] items = StringUtil.split(sort, ',');
        ArrayList<String> descList = null;
        ArrayList<String> ascList = null;
        for (int i = 0, len = items.length; i < len; i++) {
            String item = StringUtil.trim(items[i]);
            if (StringUtil.isBlank(item)) {
                continue;
            }
            String[] orders = StringUtil.split(item, ' ');
            if (orders.length == 2) {
                if ("desc".equals(orders[1].toLowerCase())) {
                    if (descList == null) {
                        descList = new ArrayList<String>();
                    }
                    descList.add(orders[0]);
                } else {
                    if (ascList == null) {
                        ascList = new ArrayList<String>();
                    }
                    ascList.add(orders[0]);
                }
            } else if (orders.length == 1) {
                if (ascList == null) {
                    ascList = new ArrayList<String>();
                }
                ascList.add(orders[0]);
            }

            if (descList != null) {
                ((Page) page).setDescs(descList);
            }
            if (ascList != null) {
                ((Page) page).setAscs(ascList);
            }
        }
    }

}
