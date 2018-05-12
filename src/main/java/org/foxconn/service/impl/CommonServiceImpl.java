package org.foxconn.service.impl;

import javax.jws.WebService;

import org.foxconn.service.CommonService;
import org.springframework.stereotype.Component;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月12日 下午7:06:58
*/
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
targetNamespace = "http://webservice.foxconn.org/", // 与接口中的命名空间一致,一般是接口的包名倒
endpointInterface = "org.foxconn.service.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {

@Override
public String sayHello(String name) {

return "Hello ," + name;
}

}