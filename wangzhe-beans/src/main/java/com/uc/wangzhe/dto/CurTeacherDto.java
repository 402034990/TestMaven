package com.uc.wangzhe.dto;

import com.uc.wangzhe.pojo.UacUserinfor;

public class CurTeacherDto {
	private Integer id;
	private String name;
	public CurTeacherDto() {
		super();
	}
	
	public CurTeacherDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "CurTeacherDto [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
