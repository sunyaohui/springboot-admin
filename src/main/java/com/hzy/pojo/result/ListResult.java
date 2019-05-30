package com.hzy.pojo.result;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ListResult<T> extends BaseVO {

    @ApiModelProperty(value="查询对象列表",name="list")
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
}