package com.beef.beef.Service;


import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface SignInService {
    boolean loginAndPasswordValidation(String passError, String loginError, Model model);
}
