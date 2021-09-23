package com.beef.beef.controller;


import com.beef.beef.model.TrainingParticipant;
import com.beef.beef.model.Trainer;
import com.beef.beef.model.User;
import com.beef.beef.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/signin")
public class SignInController {

    private UserRepository userRepository;

    public SignInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/form")
    public String signIn() {
        return "signinForm";
    }

    @PostMapping("/check")
    public String signinCheck(@RequestParam String login,
                              @RequestParam String pass,
                              @RequestParam String confirm,
                              @RequestParam String role,
                              Model model,
                              HttpServletRequest request) {

        User user;
        if (role.equals("u")) {
            user = new TrainingParticipant();
        } else {
            user = new Trainer();
        }
        String passError = "";
        String loginError = "";
        String loginPattern = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{1,19}$";
        String passPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";


        if (pass.equals(confirm) && pass.matches(passPattern)) {
            user.setPassword(pass);
        } else {
            passError = "Hasło musi zawierać przynajmniej 8 znaków," +
                    " przynajmniej jedną literę i przynajmniej jedną cyfrę.";

        }

        if (login.matches(loginPattern) && userRepository.findByLogin(login) == null) {
            user.setLogin(login);
        } else {
            loginError = " Niepoprawny login";
        }

        if (!passError.equals("") || !loginError.equals("")) {
            model.addAttribute("passError", passError);
            model.addAttribute("loginError", loginError);
            return "signinForm";
        } else {
            userRepository.save(user);
            HttpSession session = request.getSession();
            session.setAttribute("id", userRepository.findByLogin(login).getId());
            session.setAttribute("login", login);

            if (role.equals("u")) {
                return "user-logged";
            } else {
                return "trainer-logged";
            }
        }
    }

}
