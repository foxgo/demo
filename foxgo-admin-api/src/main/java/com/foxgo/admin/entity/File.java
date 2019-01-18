package com.foxgo.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.foxgo.admin.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文件
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@TableName("sys_file")
@ApiModel(value="File对象", description="文件")
public class File extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件类型")
    private Integer type;

    @ApiModelProperty(value = "URL地址")
    private String url;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "File{" +
        "type=" + type +
        ", url=" + url +
        "}";
    }
}
