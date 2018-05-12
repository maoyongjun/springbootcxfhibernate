package org.foxconn.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.foxconn.service.RestService;
public class RestServiceImpl implements RestService{
	
	@GET
	@Path("/say")
	public String sayHi() {
		StringBuilder s = new StringBuilder();
		for(int i=0;i<8000;i++){
			s.append("abcqweszxfqwedzwerpjewrjwpcsdfaewrjpzfjweorhpuwerjpjfsjdpofweriufjpsjerpjeottttttttt"+i+";");
		}
		return s.toString();
	}
	
	

}
