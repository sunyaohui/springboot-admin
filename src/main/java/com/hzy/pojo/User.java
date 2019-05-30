package com.hzy.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User",description="用户")
public class User implements Serializable {
	
	private static final long serialVersionUID = -3885313706621697914L;
	
	@ApiModelProperty(value="id",name="id")
	private Integer id;
	
	@ApiModelProperty(value="name",name="name")
	private String name;
	
	@ApiModelProperty(value="age",name="age")
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
