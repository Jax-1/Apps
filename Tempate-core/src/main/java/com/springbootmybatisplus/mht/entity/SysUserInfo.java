package com.springbootmybatisplus.mht.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.app.core.include.basic.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : SysUserInfo 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-02-22
 */
@TableName("t_sys_user_info")
public class SysUserInfo extends IBaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 用户账号
     */
	@ApiModelProperty("用户账号")
	@TableField("user_name")
	private String userName;
    /**
     * 性别
     */
	@ApiModelProperty("性别")
	private String Sex;
    /**
     * 手机号
     */
	@ApiModelProperty("手机号")
	private String Phone;
    /**
     * 邮箱
     */
	@ApiModelProperty("邮箱")
	private String email;
    /**
     * QQ
     */
	@ApiModelProperty("QQ")
	private String qq;
    /**
     * 省
     */
	@ApiModelProperty("省")
	@TableField("address_province")
	private String addressProvince;
    /**
     * 市
     */
	@ApiModelProperty("市")
	@TableField("address_city")
	private String addressCity;
    /**
     * 区/县
     */
	@ApiModelProperty("区/县")
	@TableField("address_area")
	private String addressArea;
    /**
     * 街道
     */
	@ApiModelProperty("街道")
	@TableField("address_street")
	private String addressStreet;
    /**
     * 用户头像
     */
	@ApiModelProperty("用户头像")
	private String headimgurl;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	@TableField("Create_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createAt;
    /**
     * 最后修改时间
     */
	@ApiModelProperty("最后修改时间")
	@TableField("Update_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
    /**
     * 最后登陆时间
     */
	@ApiModelProperty("最后登陆时间")
	@TableField("LastSign_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lastsignTime;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String Sex) {
		this.Sex = Sex;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddressProvince() {
		return addressProvince;
	}

	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressArea() {
		return addressArea;
	}

	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getLastsignTime() {
		return lastsignTime;
	}

	public void setLastsignTime(Date lastsignTime) {
		this.lastsignTime = lastsignTime;
	}


	@Override
	public String toString() {
		return "SysUserInfo{" +
			", userName=" + userName +
			", Sex=" + Sex +
			", Phone=" + Phone +
			", email=" + email +
			", qq=" + qq +
			", addressProvince=" + addressProvince +
			", addressCity=" + addressCity +
			", addressArea=" + addressArea +
			", addressStreet=" + addressStreet +
			", headimgurl=" + headimgurl +
			", createAt=" + createAt +
			", updateTime=" + updateTime +
			", lastsignTime=" + lastsignTime +
			"}";
	}
}
