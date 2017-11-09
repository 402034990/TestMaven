package com.uc.wangzhe.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CurMarterial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_marterial", catalog = "db")

public class CurMarterial implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurCourse curCourse;

	// Constructors

	/** default constructor */
	public CurMarterial() {
	}

	/** full constructor */
	public CurMarterial(CurCourse curCourse) {
		this.curCourse = curCourse;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cur_id")

	public CurCourse getCurCourse() {
		return this.curCourse;
	}

	public void setCurCourse(CurCourse curCourse) {
		this.curCourse = curCourse;
	}

}