/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月6日 下午2:46:48
 */
package com.ruomm.webstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruomm.webstudy.services.UserInfoService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserInfoService userInfoService;

	@ApiOperation("获取用户支付信息")
	@GetMapping("/getUserInfo")
	public Object getUserPayinfo() {
		log.info("更新设置");
		String str = "更新设置";
		try {
			str = userInfoService.getUserInfo();
			userInfoService.getUserInfoTest();
		}
		catch (Exception e) {
			e.printStackTrace();
			str = "更新设置";
		}

		return str;
	}

}
