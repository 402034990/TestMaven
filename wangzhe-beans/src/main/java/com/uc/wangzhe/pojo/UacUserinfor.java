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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UacUserinfor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uac_userinfor", catalog = "db")

public class UacUserinfor implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<CurCourse> curCourses = new HashSet<CurCourse>(0);
	private Set<CurTeacher> curTeachers = new HashSet<CurTeacher>(0);

	// Constructors

	/** default constructor */
	public UacUserinfor() {
	}

	/** full constructor */
	public UacUserinfor(String name, Set<CurCourse> curCourses, Set<CurTeacher> curTeachers) {
		this.name = name;
		this.curCourses = curCourses;
		this.curTeachers = curTeachers;
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

	@Column(name = "name", length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "cur_user_course", catalog = "db", joinColumns = {
			@JoinColumn(name = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "cur_id", nullable = false, updatable = false) })

	public Set<CurCourse> getCurCourses() {
		return this.curCourses;
	}

	public void setCurCourses(Set<CurCourse> curCourses) {
		this.curCourses = curCourses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacUserinfor")

	public Set<CurTeacher> getCurTeachers() {
		return this.curTeachers;
	}

	public void setCurTeachers(Set<CurTeacher> curTeachers) {
		this.curTeachers = curTeachers;
	}

	@Override
	public String toString() {
		return "UacUserinfor [id=" + id + ", name=" + name + ", curCourses=" + curCourses + ", curTeachers="
				+ curTeachers + "]";
	}

	
}