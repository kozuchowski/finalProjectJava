package com.beef.beef.Service;



import com.beef.beef.model.User;

import javax.servlet.http.HttpSession;


public interface LoginService {
    void sessionInvalidate(HttpSession session);
    User getUserFromDataBase(String login);
}
