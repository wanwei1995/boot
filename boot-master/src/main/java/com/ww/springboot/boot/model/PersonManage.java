package com.ww.springboot.boot.model;

public class PersonManage extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Long id;
    
	 //人员名称
     private  String personName;
     
     //结果
     private  Integer type;
    
	 //部门
     private  Integer department;
    
	 //岗位名称
     private  Integer jobName;
    
	 //性别
     private  Integer sex;
    
	 //年龄
     private  String age;
    
	 //学校名
     private  String school;
    
	 //学历
     private  Integer education;
    
	 //专业
     private  String profession;
    
	 //院校属性
     private  Integer schoolAttribute;
    
	 //工作经历
     private  String experience;
    
	 //电话
     private  String phone;
    
	 //邮箱
     private  String email;
    
	 //人员状态
     private  Integer status;
     	
     //0
     private  int isDeleted;
     
    
	 public Long getId() {
		return id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getJobName() {
		return jobName;
	}

	public void setJobName(Integer jobName) {
		this.jobName = jobName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getSchoolAttribute() {
		return schoolAttribute;
	}

	public void setSchoolAttribute(Integer schoolAttribute) {
		this.schoolAttribute = schoolAttribute;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
}
