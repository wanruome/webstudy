/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月8日 下午10:32:44
 */
package com.ruomm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruomm.dto.UserInfoDto;

import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfoDto> {
	public int insertUserInfo(@Param("userInfoDto") UserInfoDto userInfoDto);

	public List<UserInfoDto> selectUserInfos(@Param("userInfoDto") UserInfoDto userInfoDto);

}
