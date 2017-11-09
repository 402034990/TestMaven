package com.uc.wangzhe.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CurCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_category", catalog = "db")

public class CurCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Integer PId;
	private Set<CurCourse> curCourses = new HashSet<CurCourse>(0);

	// Constructors

	/** default constructor */
	public CurCategory() {
	}

	/** full constructor */
	public CurCategory(String code, String name, Integer PId, Set<CurCourse> curCourses) {
		this.code = code;
		this.name = name;
		this.PId = PId;
		this.curCourses = curCourses;
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

	@Column(name = "code", length = 50)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "p_id")

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCategory")

	public Set<CurCourse> getCurCourses() {
		return this.curCourses;
	}

	public void setCurCourses(Set<CurCourse> curCourses) {
		this.curCourses = curCourses;
	}

	@Override
	public String toString() {
		return "CurCategory [id=" + id + ", code=" + code + ", name=" + name + ", PId=" + PId + "]";
	}
	
}