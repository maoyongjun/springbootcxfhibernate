package org.foxconn.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.foxconn.dao.UserRepository;
import org.foxconn.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月13日 下午5:49:15
*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    /**
     * 通过构造器注入UserRepository
     * @param userRepository
     */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }

	private Collection<? extends GrantedAuthority> emptyList() {
		// TODO Auto-generated method stub
		return new ArrayList<GrantedAuthority>();
	}

}