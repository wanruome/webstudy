/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月10日 下午3:09:24
 */
package com.ruomm.webstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruomm.webstudy.dal.request.LoginUserReqDto;
import com.ruomm.webstudy.services.LoginService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginUserInfoController {
	@Autowired
	LoginService loginService;

	@ApiOperation("获取用户支付信息")
	@PostMapping("/doLogin")
	public String doLogin(@RequestBody LoginUserReqDto loginUserReqDto) {
		System.out.println(loginUserReqDto.toString());
		return loginService.doLogin();
	}
}
