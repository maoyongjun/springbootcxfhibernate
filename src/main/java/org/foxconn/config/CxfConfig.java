package org.foxconn.config;


import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxrs.spring.JAXRSServerFactoryBeanDefinitionParser.SpringJAXRSServerFactoryBean;
import org.apache.cxf.jaxws.EndpointImpl;
import org.foxconn.service.CommonService;
import org.foxconn.service.RestService;
import org.foxconn.service.impl.RestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:myz
 * @version 1.0 创建时间：2018年5月12日 下午7:07:59
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

	@Bean
	public SpringJAXRSServerFactoryBean createRs() {
		SpringJAXRSServerFactoryBean restFactory = new SpringJAXRSServerFactoryBean();
		restFactory.setServiceClass(RestService.class);
		restFactory.setServiceBean(new RestServiceImpl());
		restFactory.setAddress("/restServices");
		restFactory.setBus(bus);
		
		restFactory.getInInterceptors().add(new LoggingInInterceptor());
		
		restFactory.create();
		return restFactory;
	}

	
}
