package com.ssafy.vue.model;

public class HouseDto {
	private int no;
	private String dong;
	private String code;
	private String aptName;
	private int dealAmount; //매매가
	private int buildYear;
	private String jibun;
	private int rentMoney; //전월세가
	
	public HouseDto() {}

	public HouseDto(int no, String dong, String code, String aptName, int dealAmount, int buildYear, String jibun,
			int rentMoney) {
		this.no = no;
		this.dong = dong;
		this.code = code;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.jibun = jibun;
		this.rentMoney = rentMoney;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public int getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(int dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public int getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(int rentMoney) {
		this.rentMoney = rentMoney;
	}

	@Override
	public String toString() {
		return "HouseDto [no=" + no + ", dong=" + dong + ", code=" + code + ", aptName=" + aptName + ", dealAmount="
				+ dealAmount + ", buildYear=" + buildYear + ", jibun=" + jibun + ", rentMoney=" + rentMoney + "]";
	}

}
