package org.foxconn.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.foxconn.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月12日 下午7:07:59
*/
@Configuration
public class CxfConfig {
	@Autowired
	private Bus bus;

	@Autowired
	CommonService commonService;

	/** JAX-WS **/
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, commonService);
		endpoint.publish("/CommonService");
		return endpoint;
	}
}
