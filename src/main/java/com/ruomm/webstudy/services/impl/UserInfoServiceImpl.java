/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月8日 下午9:15:49
 */
package com.ruomm.webstudy.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruomm.base.datasource.DataSource;
import com.ruomm.dao.UserInfoMapper;
import com.ruomm.dto.UserInfoDto;
import com.ruomm.webstudy.services.UserInfoService;

@Component
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoMapper userInfoMapper;

	@DataSource("mysql")
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String getUserInfo() {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		Date startDate = null;
		try {
			startDate = sdf.parse("201806090203000");
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String userId = sdf.format(new Date());
		long id = (new Date().getTime() - startDate.getTime()) / (1000 * 30);
		String userId = id + "";

		UserInfoDto user = new UserInfoDto();
		user.setPwd(new Random().nextInt(99999999) + "");
		user.setUserId(userId);
		user.setUserName("张蜜" + new Random().nextInt(9999));
		userInfoMapper.insertSelective(user);
		// userInfoMapper.insertUserInfo(user);

		PageHelper.startPage(1, 10, false);
		List<UserInfoDto> list = userInfoMapper.selectUserInfos(new UserInfoDto());
		PageInfo<UserInfoDto> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.toString());

		return getClass().getName();

	}

	@DataSource("oracle")
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String getUserInfoTest() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		Date startDate = null;
		try {
			startDate = sdf.parse("201806090203000");
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String userId = sdf.format(new Date());
		long id = (new Date().getTime() - startDate.getTime()) / (1000 * 30);
		String userId = id + "";

		UserInfoDto user = new UserInfoDto();
		user.setPwd(new Random().nextInt(99999999) + "");
		user.setUserId(userId);
		user.setUserName("胡雷" + new Random().nextInt(9999));
		userInfoMapper.insertSelective(user);
		userInfoMapper.insertUserInfo(user);

		PageHelper.startPage(1, 10, false);
		List<UserInfoDto> list = userInfoMapper.selectUserInfos(new UserInfoDto());
		PageInfo<UserInfoDto> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.toString());

		return getClass().getName();
	}

}
