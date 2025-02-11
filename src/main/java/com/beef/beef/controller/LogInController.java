package com.beef.beef.controller;

import com.beef.beef.Service.LoginServiceImpl;
import com.beef.beef.model.TrainingParticipant;
import com.beef.beef.model.User;
import com.beef.beef.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/login")
public class LogInController {

    private LoginServiceImpl loginServiceImpl;
    private User user;

    @Autowired
    public LogInController(LoginServiceImpl loginServiceImpl) {

        this.loginServiceImpl = loginServiceImpl;
    }


    @GetMapping("/form")
    public String logIn(){

        return "loginForm";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){

        loginServiceImpl.sessionInvalidate(session);
        return "index";
    }


    @GetMapping("/back")
    public String backToLogIn(HttpSession session, Model model){

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
    public String logInUser (@RequestParam String login,
                             @RequestParam String pass,
                             Model model,
                             HttpSession session){
        String error = "";

        user = loginServiceImpl.getUserFromDataBase(login);

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
            session.setAttribute("id", user.getId());
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
