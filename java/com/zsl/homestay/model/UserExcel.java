package com.zsl.homestay.model;

import com.alibaba.excel.annotation.ExcelProperty;

import io.swagger.annotations.ApiModelProperty;

public class UserExcel {

	/**
	 * 姓名
	 */
	@ExcelProperty(value = "用户名", index = 0)
	@ApiModelProperty(value = "userName")
	private String userName;
	/**
	 * 护照编号
	 */
	@ExcelProperty(value = "护照编号", index = 1)
	@ApiModelProperty(value = "passport")
	private String passport;

	/**
	 * 护照
	 */
	@ExcelProperty(value = "护照", index = 2)
	@ApiModelProperty(value = "passportPhoto")
	private String passportPhoto;
	/**
	 * 地址
	 */
	@ApiModelProperty(value = "address")
	@ExcelProperty(value = "地址", index = 3)
	private String address;


	/**
	 * 职业
	 */
	@ApiModelProperty(value = "csJob")
	@ExcelProperty(value = "职业", index = 4)
	private String csJob;
	/**
	 * 目的地
	 */
	@ApiModelProperty(value = "destination")
	@ExcelProperty(value = "目的地", index = 5)
	private String destination;
	/**
	 * 前住宿地
	 */
	@ApiModelProperty(value = "bfDestination")
	@ExcelProperty(value = "前住宿地", index = 6)
	private String bfDestination;
	/**
	 * 签名
	 */
	@ApiModelProperty(value = "sign")
	@ExcelProperty(value = "签名", index = 7)
	private String sign;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPassportPhoto() {
		return passportPhoto;
	}

	public void setPassportPhoto(String passportPhoto) {
		this.passportPhoto = passportPhoto;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCsJob() {
		return csJob;
	}

	public void setCsJob(String csJob) {
		this.csJob = csJob;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBfDestination() {
		return bfDestination;
	}

	public void setBfDestination(String bfDestination) {
		this.bfDestination = bfDestination;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
