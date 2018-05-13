package org.foxconn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月13日 下午5:24:48
*/
@Entity  
@Table(name = "tb_user")  
public class User {  
  
    @Id  
    @GeneratedValue  
    private long id;  
    private String username;  
    private String password;  
  
    public long getId() {  
        return id;  
    }  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
}  