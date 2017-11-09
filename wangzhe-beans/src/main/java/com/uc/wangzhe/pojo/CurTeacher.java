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
 * CurTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_teacher", catalog = "db")

public class CurTeacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private UacUserinfor uacUserinfor;
	private String name;
	private Set<CurCourse> curCourses = new HashSet<CurCourse>(0);

	// Constructors

	/** default constructor */
	public CurTeacher() {
	}

	/** full constructor */
	public CurTeacher(UacUserinfor uacUserinfor, String name, Set<CurCourse> curCourses) {
		this.uacUserinfor = uacUserinfor;
		this.name = name;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uac_id")

	public UacUserinfor getUacUserinfor() {
		return this.uacUserinfor;
	}

	public void setUacUserinfor(UacUserinfor uacUserinfor) {
		this.uacUserinfor = uacUserinfor;
	}

	@Column(name = "name", length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curTeacher")

	public Set<CurCourse> getCurCourses() {
		return this.curCourses;
	}

	public void setCurCourses(Set<CurCourse> curCourses) {
		this.curCourses = curCourses;
	}

	@Override
	public String toString() {
		return "CurTeacher [id=" + id + ", uacUserinfor=" + uacUserinfor + ", name=" + name + ", curCourses="
				+ curCourses + "]";
	}

	
	
}