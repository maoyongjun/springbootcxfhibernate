package org.foxconn.exception;

import org.springframework.security.core.AuthenticationException;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月13日 下午6:09:57
*/
public class UsernameIsExitedException extends AuthenticationException {

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}