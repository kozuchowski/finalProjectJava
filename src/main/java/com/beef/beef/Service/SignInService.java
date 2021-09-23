package com.beef.beef.Service;


import com.beef.beef.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface SignInService {
    boolean loginAndPasswordValidation(String passError, String loginError, Model model);
    void saveUser(User user, String login, HttpSession session );
}
