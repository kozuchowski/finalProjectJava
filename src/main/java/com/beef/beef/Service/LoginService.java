package com.beef.beef.Service;



import javax.servlet.http.HttpSession;


public interface LoginService {
    void sessionInvalidate(HttpSession session);
}
