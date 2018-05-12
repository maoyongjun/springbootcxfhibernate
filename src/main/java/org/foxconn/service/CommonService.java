package org.foxconn.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月12日 下午7:06:05
*/
@WebService(name = "CommonService", // 暴露服务名称
targetNamespace = "http://webservice.leftso.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {
@WebMethod
@WebResult(name = "String", targetNamespace = "")
public String sayHello(@WebParam(name = "userName") String name);

}
