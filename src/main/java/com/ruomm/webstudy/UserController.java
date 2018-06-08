/**
 *	@copyright wanruome-2018
 * 	@author wanruome
 * 	@create 2018年6月6日 下午2:46:48
 */
package com.ruomm.webstudy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/getUserInfo")
public class UserController {
	@ApiOperation("获取用户支付信息")
	@GetMapping("/getUserPayinfo/{phoneNumber}")
	public Object getUserPayinfo(@PathVariable String phoneNumber) {
		return "你好吗";
	}

}
