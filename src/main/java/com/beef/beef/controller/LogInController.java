package com.beef.beef.controller;


import com.beef.beef.model.TrainingParticipant;
import com.beef.beef.model.User;
import com.beef.beef.model.Trainer;
import com.beef.beef.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
//@RequiredArgsConstructor
public class LogInController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/form")
    public String logIn(){
        return "loginForm";
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
            if(user instanceof TrainingParticipant) {
                return "user-logged";
            } else {
                Trainer trainer = (Trainer) user;
                List<TrainingParticipant> selected = trainer.getUsers();
                model.addAttribute("users", selected);
                return "trainer-logged";

            }
        }
    }
}
