/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月10日 下午3:09:24
 */
package com.ruomm.webstudy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruomm.base.spring.RuommParam;
import com.ruomm.webstudy.dal.request.LoginUserReqDto;
import com.ruomm.webstudy.dal.request.LoginUserReqDto2;
import com.ruomm.webstudy.services.LoginService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/login")

public class LoginUserInfoController {
	@Autowired
	LoginService loginService;

	@ApiOperation("用户登录")
	@PostMapping("/doLogin")
	public String doLogin(@Validated @RequestBody LoginUserReqDto loginUserReqDto, BindingResult bindingResult) {
		System.out.println(loginUserReqDto.toString());
		return loginService.doLogin();
	}

	@ApiOperation("用户登录")
	@PostMapping("/postLogin")
	public String postLogin(@Valid @RuommParam LoginUserReqDto2 mapString) {
		// System.out.println(loginUserReqDto.toString());
		System.out.println(mapString.toString());
		return "adsfdsa";
	}

	@ApiOperation("用户登录")
	@GetMapping("/getLogin")
	public String getLogin(@Valid @RuommParam LoginUserReqDto2 mapString) {
		// System.out.println(loginUserReqDto.toString());
		System.out.println(mapString.toString());
		return "adsfdsa";
	}
}
