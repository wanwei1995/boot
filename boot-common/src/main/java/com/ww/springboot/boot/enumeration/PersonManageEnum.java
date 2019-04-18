package com.ww.springboot.boot.enumeration;

public class PersonManageEnum {

	public enum statusEnum {

		INIT(0, "参加面试"), STATUS1(1, "初试"), STATUS2(2, "复试"), STATUS3(3, "终试");
		private Integer value;

		private String name;

		statusEnum(Integer value, String name) {
			this.setValue(value);
			this.setName(name);
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public enum typeEnum {

		INIT(0, "等待结果"), STATUS1(1, "是/通过"), STATUS2(2, "否/淘汰");
		private Integer value;

		private String name;

		typeEnum(Integer value, String name) {
			this.setValue(value);
			this.setName(name);
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public enum departmentEnum {

		YouNeng(0, "优能班教事业部");
		private Integer value;

		private String name;

		departmentEnum(Integer value, String name) {
			this.setValue(value);
			this.setName(name);
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public enum jobEnum {

		Xxghs(0, "学习规划师"), Xzzl(1, "校长助理"), Xqxz(2, "校区校长");
		private Integer value;

		private String name;

		jobEnum(Integer value, String name) {
			this.setValue(value);
			this.setName(name);
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public enum sexEnum {

		man(0, "男"), woman(1, "女");
		private Integer value;

		private String name;

		sexEnum(Integer value, String name) {
			this.setValue(value);
			this.setName(name);
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public enum educationEnum {
		Specialist(0, "大专及以下"), Bachelor(1, "本科"), Postgraduate(2, "研究生"), Master(3, "硕士"), Doctor(4, "博士");
		private Integer value;

		private String name;

		educationEnum(Integer value, String name) {
			this.setValue(value);
			this.setName(name);
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	public enum schoolAttributeEnum {
		Two(0, "211"), Nine(1, "985"), ordinary(2, "普通院校");
		private Integer value;

		private String name;

		schoolAttributeEnum(Integer value, String name) {
			this.setValue(value);
			this.setName(name);
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
