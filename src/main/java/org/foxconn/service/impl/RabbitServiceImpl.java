package org.foxconn.service.impl;

import org.foxconn.entity.User;
import org.foxconn.rabbit.sender.NeoSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月16日 下午9:58:44
*/
@RestController
@RequestMapping("/rabbit")
public class RabbitServiceImpl {

	 @Autowired
	    private NeoSender neoSender;
    
	@GetMapping("/send")
	public void test(String msg){
		User user = new User();
		user.setUsername(msg);
		neoSender.send(user);
		neoSender.send("{username:abc}");
	}
}
