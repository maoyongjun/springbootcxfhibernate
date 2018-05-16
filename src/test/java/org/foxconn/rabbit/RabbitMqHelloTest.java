package org.foxconn.rabbit;


import org.foxconn.rabbit.sender.HelloSender;
import org.foxconn.rabbit.sender.NeoSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月16日 下午8:38:01
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;
    
    @Autowired
    private NeoSender neoSender;

    @Test
    public void hello() throws Exception {
//        helloSender.send();
//    	helloSender.send1();
//    	helloSender.send2();
    	helloSender.send3();
        
    }
    
//    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
        }
    }

}
