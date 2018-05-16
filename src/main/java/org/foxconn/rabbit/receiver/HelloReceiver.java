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
public class HelloReceiver {

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

}