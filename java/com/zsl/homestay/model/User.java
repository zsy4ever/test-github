package com.zsl.homestay.model;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.zsl.homestay.service.MyStringImageConverter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
@ContentRowHeight(80)
public class User {

	@ExcelIgnore
	private String id;
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "userName")
	@ExcelProperty(value = "用户名", index = 0)
	private String userName;
	/**
	 * 密码
	 */
	@ExcelIgnore
	@ApiModelProperty(value = "password")
	private String password;
	/**
	 * 护照编号
	 */
	@ExcelProperty(value = "护照编号", index = 1)
	@ApiModelProperty(value = "passport")
	private String passport;

	/**
	 * 护照
	 */
	@ApiModelProperty(value = "passportPhoto")
	@ExcelProperty(value = "护照", index = 2, converter = MyStringImageConverter.class)
	@ColumnWidth(40)
	private String passportPhoto;
	/**
	 * 地址
	 */
	@ApiModelProperty(value = "address")
	@ExcelProperty(value = "地址", index = 3)
	private String address;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "createBy")
	@ExcelIgnore
	private String createBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "createTime")
	@ExcelIgnore
	private Date createTime;

	/**
	 * 修改人
	 */
	@ApiModelProperty(value = "modifyBy")
	@ExcelIgnore
	private String modifyBy;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "modifyTime")
	@ExcelIgnore
	private Date modifyTime;

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
	// 当前页
	@ExcelIgnore
	private int pageNum;
	// 每页的数量
	@ExcelIgnore
	private int pageSize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
