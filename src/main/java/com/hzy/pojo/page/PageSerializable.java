package com.hzy.pojo.page;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;
import com.hzy.pojo.result.BaseVO;

public class PageSerializable<T> extends BaseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="总条数",name="total")
    protected long    total;
    @ApiModelProperty(value="结果集",name="list")
    protected List<T> list;

    public PageSerializable() {
    }

    @SuppressWarnings("rawtypes")
	public PageSerializable(List<T> list) {
        this.list = list;
        if(list instanceof Page){
            this.total = ((Page)list).getTotal();
        } else {
            this.total = list.size();
        }
    }

    public static <T> PageSerializable<T> of(List<T> list){
        return new PageSerializable<T>(list);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageSerializable{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}

