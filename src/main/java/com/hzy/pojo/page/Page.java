package com.hzy.pojo.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Page",description="PageBean")
public class Page {
	
	@ApiModelProperty(value="当前页数",name="pageNum")
	private int pageNum = 1;
	
	@ApiModelProperty(value="每页条数",name="pageSize")
	private int pageSize = 10;

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
	
}
