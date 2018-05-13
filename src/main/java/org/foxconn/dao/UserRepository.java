package org.foxconn.dao;

import org.foxconn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月13日 下午5:25:54
*/
public interface UserRepository extends JpaRepository<User, Long> {  
	  
    User findByUsername(String username);  
  
}  