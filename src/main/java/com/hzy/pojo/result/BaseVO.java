package com.hzy.pojo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BaseVO",description="BaseVOBean")
public class BaseVO {

	@ApiModelProperty(value="提示信息" ,name="message")
	private String message;
	
	@ApiModelProperty(value="true:成功，false:失败",name="success")
	private boolean success;
	
	@ApiModelProperty(value="状态码",name="code")
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}

