package org.foxconn.rabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月16日 下午8:36:44
*/
@Component
//@RabbitListener(queues = "hello")
//@RabbitListener(queues = "topic.message")
@RabbitListener(queues = "fanout.B")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}