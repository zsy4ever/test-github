package com.zsl.homestay.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户DTO")
public class UserDTO {
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "userName")
	private String userName;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "password")
	private String password;
	/**
	 * 护照编号
	 */
	@ApiModelProperty(value = "passport")
	private String passport;

	/**
	 * 护照
	 */
	@ApiModelProperty(value = "passportPhoto")
	private MultipartFile passportPhoto;
	/**
	 * 地址
	 */
	@ApiModelProperty(value = "address")
	private String address;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "createBy")
	private String createBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "createTime")
	private Date createTime;

	/**
	 * 修改人
	 */
	@ApiModelProperty(value = "modifyBy")
	private String modifyBy;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "modifyTime")
	private Date modifyTime;
	/**
	 * 职业
	 */
	@ApiModelProperty(value = "csJob")
	private String csJob;
	/**
	 * 目的地
	 */
	@ApiModelProperty(value = "destination")
	private String destination;
	/**
	 * 前住宿地
	 */
	@ApiModelProperty(value = "bfDestination")
	private String bfDestination;
	/**
	 * 签名
	 */
	@ApiModelProperty(value = "sign")
	private MultipartFile sign;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public MultipartFile getPassportPhoto() {
		return passportPhoto;
	}

	public void setPassportPhoto(MultipartFile passportPhoto) {
		this.passportPhoto = passportPhoto;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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

	public MultipartFile getSign() {
		return sign;
	}

	public void setSign(MultipartFile sign) {
		this.sign = sign;
	}

}
