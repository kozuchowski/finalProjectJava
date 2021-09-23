package com.beef.beef.controller;


import com.beef.beef.model.TrainingParticipant;
import com.beef.beef.model.User;
import com.beef.beef.model.Trainer;
import com.beef.beef.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/login")
public class LogInController {


    private UserRepository userRepository;

    public LogInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/form")
    public String logIn(){

        return "loginForm";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(!session.isNew()){
            session.invalidate();
        }

        return "index";
    }

    @GetMapping("/back")
    public String backToLogIn(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user = userRepository.findByLogin(String.valueOf(session.getAttribute("login")));
        if(user instanceof TrainingParticipant) {
            return "user-logged";
        }else {
            Trainer trainer = (Trainer) user;
            List<TrainingParticipant> selected = trainer.getUsers();

            model.addAttribute("users", selected);
            return "trainer-logged";
        }
    }

    @PostMapping("/check")
    public String loginUser (@RequestParam String login,
                             @RequestParam String pass,
                             Model model,
                             HttpServletRequest request){
        String error = "";

        User user = userRepository.findByLogin(login);

        if(user == null){
            model.addAttribute("error", "Niepoprawny login");
            return "loginForm";
        }

        if(!pass.equals(user.getPassword())){
            error = "Niepoprawny login lub hasło";
        }

        if(!error.equals("")){
            model.addAttribute("error", error);
            return "loginForm";
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("id", userRepository.findByLogin(login).getId());
            session.setAttribute("login", login);
            if(user instanceof TrainingParticipant) {
                return "user-logged";
            } else {
                Trainer trainer = (Trainer) user;
                List<TrainingParticipant> selected = trainer.getUsers();

                session.setAttribute("users", selected);
                return "trainer-logged";

            }
        }
    }
}
