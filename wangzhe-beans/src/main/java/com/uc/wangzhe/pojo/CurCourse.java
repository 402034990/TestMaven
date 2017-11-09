package com.uc.wangzhe.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CurCourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_course", catalog = "db")

public class CurCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurCategory curCategory;
	private CurTeacher curTeacher;
	private String code;
	private Date curStartDate;
	private String curDesc;
	private String curMovieFile;
	private String curGoal;
	private String curTargetUser;
	private Set<CurDiscuss> curDiscusses = new HashSet<CurDiscuss>(0);
	private Set<UacUserinfor> uacUserinfors = new HashSet<UacUserinfor>(0);
	private Set<CurCharpter> curCharpters = new HashSet<CurCharpter>(0);
	private Set<CurMarterial> curMarterials = new HashSet<CurMarterial>(0);

	// Constructors

	/** default constructor */
	public CurCourse() {
	}

	/** minimal constructor */
	public CurCourse(CurCategory curCategory, String code) {
		this.curCategory = curCategory;
		this.code = code;
	}

	/** full constructor */
	public CurCourse(CurCategory curCategory, CurTeacher curTeacher, String code, Date curStartDate, String curDesc,
			String curMovieFile, String curGoal, String curTargetUser, Set<CurDiscuss> curDiscusses,
			Set<UacUserinfor> uacUserinfors, Set<CurCharpter> curCharpters, Set<CurMarterial> curMarterials) {
		this.curCategory = curCategory;
		this.curTeacher = curTeacher;
		this.code = code;
		this.curStartDate = curStartDate;
		this.curDesc = curDesc;
		this.curMovieFile = curMovieFile;
		this.curGoal = curGoal;
		this.curTargetUser = curTargetUser;
		this.curDiscusses = curDiscusses;
		this.uacUserinfors = uacUserinfors;
		this.curCharpters = curCharpters;
		this.curMarterials = curMarterials;
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
	@JoinColumn(name = "id", unique = true, nullable = false, insertable = false, updatable = false)

	public CurCategory getCurCategory() {
		return this.curCategory;
	}

	public void setCurCategory(CurCategory curCategory) {
		this.curCategory = curCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cur_id")

	public CurTeacher getCurTeacher() {
		return this.curTeacher;
	}

	public void setCurTeacher(CurTeacher curTeacher) {
		this.curTeacher = curTeacher;
	}

	@Column(name = "code", nullable = false, length = 50)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cur_start_date", length = 10)

	public Date getCurStartDate() {
		return this.curStartDate;
	}

	public void setCurStartDate(Date curStartDate) {
		this.curStartDate = curStartDate;
	}

	@Column(name = "cur_desc", length = 65535)

	public String getCurDesc() {
		return this.curDesc;
	}

	public void setCurDesc(String curDesc) {
		this.curDesc = curDesc;
	}

	@Column(name = "cur_movie_file", length = 50)

	public String getCurMovieFile() {
		return this.curMovieFile;
	}

	public void setCurMovieFile(String curMovieFile) {
		this.curMovieFile = curMovieFile;
	}

	@Column(name = "cur_goal", length = 150)

	public String getCurGoal() {
		return this.curGoal;
	}

	public void setCurGoal(String curGoal) {
		this.curGoal = curGoal;
	}

	@Column(name = "cur_target_user", length = 150)

	public String getCurTargetUser() {
		return this.curTargetUser;
	}

	public void setCurTargetUser(String curTargetUser) {
		this.curTargetUser = curTargetUser;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCourse")

	public Set<CurDiscuss> getCurDiscusses() {
		return this.curDiscusses;
	}

	public void setCurDiscusses(Set<CurDiscuss> curDiscusses) {
		this.curDiscusses = curDiscusses;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCourses")

	public Set<UacUserinfor> getUacUserinfors() {
		return this.uacUserinfors;
	}

	public void setUacUserinfors(Set<UacUserinfor> uacUserinfors) {
		this.uacUserinfors = uacUserinfors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCourse")

	public Set<CurCharpter> getCurCharpters() {
		return this.curCharpters;
	}

	public void setCurCharpters(Set<CurCharpter> curCharpters) {
		this.curCharpters = curCharpters;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curCourse")

	public Set<CurMarterial> getCurMarterials() {
		return this.curMarterials;
	}

	public void setCurMarterials(Set<CurMarterial> curMarterials) {
		this.curMarterials = curMarterials;
	}

	@Override
	public String toString() {
		return "CurCourse [id=" + id +  ", code=" + code
				+ ", curStartDate=" + curStartDate + ", curDesc=" + curDesc + ", curGoal=" + curGoal + "]";
	}
	
}