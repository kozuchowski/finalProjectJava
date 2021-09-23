package com.beef.beef.Service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService{
    @Override
    public void sessionInvalidate(HttpSession session) {
        if(!session.isNew()){
            session.invalidate();
        }
    }
}
