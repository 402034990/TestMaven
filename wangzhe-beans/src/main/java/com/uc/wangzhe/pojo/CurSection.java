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
 * CurSection entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_section", catalog = "db")

public class CurSection implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurCharpter curCharpter;

	// Constructors

	/** default constructor */
	public CurSection() {
	}

	/** full constructor */
	public CurSection(CurCharpter curCharpter) {
		this.curCharpter = curCharpter;
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

	public CurCharpter getCurCharpter() {
		return this.curCharpter;
	}

	public void setCurCharpter(CurCharpter curCharpter) {
		this.curCharpter = curCharpter;
	}

}