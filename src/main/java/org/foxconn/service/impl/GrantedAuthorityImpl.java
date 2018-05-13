package org.foxconn.service.impl;

import org.springframework.security.core.GrantedAuthority;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月13日 下午5:49:51
*/
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
