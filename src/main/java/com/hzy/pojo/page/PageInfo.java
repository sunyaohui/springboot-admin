package com.hzy.pojo.page;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageSerializable;

@ApiModel(value = "PageInfo",description="PageInfoBean")
@SuppressWarnings({"rawtypes", "serial"})
public class PageInfo<T> extends PageSerializable<T> {
	@ApiModelProperty(value="当前页",name="pageNum")
    private int pageNum;
	@ApiModelProperty(value="每页的数量",name="pageSize")
    private int pageSize;
	@ApiModelProperty(value="当前页的数量",name="size")
    private int size;
	@ApiModelProperty(value="总页数",name="pages")
    private int pages;
   
	public PageInfo() {
    }

    public PageInfo(List<T> list) {
        this(list, 8);
    }
    public PageInfo(List<T> list, int navigatePages) {
        super(list);
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.size = page.size();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = this.pageSize > 0 ? 1 : 0;
            this.size = list.size();
        }
    }

    public static <T> PageInfo<T> of(List<T> list){
        return new PageInfo<T>(list);
    }

    public static <T> PageInfo<T> of(List<T> list, int navigatePages){
        return new PageInfo<T>(list, navigatePages);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", size=").append(size);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", navigatepageNums=");
        sb.append('}');
        return sb.toString();
    }
}
