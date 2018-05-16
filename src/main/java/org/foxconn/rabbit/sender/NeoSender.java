package org.foxconn.rabbit.sender;

import java.util.Date;

import org.foxconn.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月16日 下午8:45:07
*/
@Component
public class NeoSender {
	 @Autowired
	    private AmqpTemplate rabbitTemplate;

	    public void send(int i) {
	        String context = "hello " +i+ new Date();
	        System.out.println("Sender : "+ context);
	        this.rabbitTemplate.convertAndSend("hello", context);
	    }
	    
	    public void send(User user){
	    	 System.out.println("Sender : "+ user);
	    	 this.rabbitTemplate.convertAndSend("code", user);
	    }
	    
	    public void send(String code){
	    	 System.out.println("Sender : "+ code);
	    	 this.rabbitTemplate.convertAndSend("code", code);
	    }
	    
	   
}
