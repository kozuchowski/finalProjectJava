package com.beef.beef.Service;

import com.beef.beef.model.User;
import com.beef.beef.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService{

    private UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void sessionInvalidate(HttpSession session) {
        if(!session.isNew()){
            session.invalidate();
        }
    }

    @Override
    public User getUserFromDataBase(String login){
        User user;
        if((user = userRepository.findByLogin(login)) != null){
            return user;
        }
        return null;
    }

}
