package org.foxconn.rabbit.receiver;

import org.foxconn.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:myz
 * @version 1.0 创建时间：2018年5月16日 下午10:02:44
 */
@Component
public class CodeReceiver {
	@RabbitHandler
	@RabbitListener(queues = "code")
	public void process(User  user) {
		System.out.println("Receiver  : " +user);
	}
	@RabbitHandler
	@RabbitListener(queues = "msg")
	public void process2(String msg) {
		System.out.println("Receiver  : " +msg);
	}
}
