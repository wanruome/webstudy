/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月8日 下午10:29:51
 */
package com.ruomm.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "TBL_USRE_INFO")
public class UserInfoDto {
	@Id
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "USER_NAME")
	private String userName;

}
