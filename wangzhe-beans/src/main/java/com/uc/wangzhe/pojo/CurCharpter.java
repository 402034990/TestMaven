package com.uc.wangzhe.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CurCharpter entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_charpter", catalog = "db")

public class CurCharpter implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurCourse curCourse;
	private Set<CurSection> curSections = new HashSet<CurSection>(0);

	// Constructors

	/** default constructor */
	public CurCharpter() {
	}

	/** full constructor */
	public CurCharpter(CurCourse curCourse, Set<CurSection> curSections) {
		this.curCourse = curCourse;
		this.curSections = curSections;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCharpter")

	public Set<CurSection> getCurSections() {
		return this.curSections;
	}

	public void setCurSections(Set<CurSection> curSections) {
		this.curSections = curSections;
	}

}