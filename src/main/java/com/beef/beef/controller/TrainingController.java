package com.beef.beef.controller;

import com.beef.beef.model.*;
import com.beef.beef.repository.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/training"})
@RequiredArgsConstructor
public class TrainingController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final TrainerRepository trainerRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private TrainingParticipantRepository trainingParticipantRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    private List<Exercise> exercises = new ArrayList();


    @PostMapping({"/save"})
    public String save() {
        return "trainer-logged";
    }

    @GetMapping({"/check"})
    public String checkIfTrainingExist(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        TrainingParticipant trainingParticipant = trainingParticipantRepository.
                findByLogin(String.valueOf(session.getAttribute("login")));

        Training training = trainingParticipant.getTraining();

        model.addAttribute("training", training);

        return "training";
    }

    @GetMapping({"/usermaxesForm"})
    public String showMaxesForm(Model model) {
        List<Trainer> treners = trainerRepository.findAll();
        model.addAttribute("users", treners);
        return "maxesForm";
    }

    @PostMapping({"/usermaxes"})
    public String saveUserMaxes(@RequestParam int deadlift,
                                @RequestParam int squat,
                                @RequestParam int benchpress,
                                @RequestParam String trainerLogin,
                                HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = this.userRepository.findById(Integer.parseInt(String.valueOf(session.getAttribute("id"))));
        Trainer trainer = trainerRepository.findByLogin(trainerLogin);


            TrainingParticipant trainingParticipant = (TrainingParticipant)user;
            trainingParticipant.setDeadlift(deadlift);
            trainingParticipant.setSquat(squat);
            trainingParticipant.setBenchpress(benchpress);

            trainingParticipant.setWaitingForTraining(true);
            trainingParticipant.setTrainer(trainer);

            this.userRepository.save(trainingParticipant);
            return "user-logged";

    }

    @GetMapping("/create")
    public String createTraining(@RequestParam String login, Model model){
        model.addAttribute("login", login);


        return "trainingForm";
    }

    @PostMapping("/save-exercises")

    public String saveExercise(@RequestParam String login,
                               @RequestParam String name,
                               @RequestParam String description,
                               @RequestParam int weight,
                               @RequestParam int progress,
                               @RequestParam int series,
                               @RequestParam int weeks,
                               @RequestParam int amount,
                               @RequestParam String end,
                               Model model){

        model.addAttribute("login", login);
        Training training;
        TrainingParticipant trainingParticipant = trainingParticipantRepository.findByLogin(login);
        Integer participantId = trainingParticipantRepository.findByLogin(login).getId();

        if(trainingRepository.findByTrainingParticipantId(participantId) == null) {
            training = new Training();
        }else{
            training = trainingRepository.findByTrainingParticipantId(participantId);
        }

        training.setTrainingParticipant(trainingParticipant);

        trainingParticipant.setWaitingForTraining(false);
        trainingParticipant.setTraining(training);
        List<Exercise> exercises = new ArrayList<>();

        Exercise exercise = new Exercise();

        exercise.setBasicWeight(weight);
        exercise.setName(name);
        exercise.setDescription(description);
        exercise.setAmount(amount);
        exercise.setWeeksAmount(weeks);
        exercise.setProgress(progress);
        exercise.setSeriesAmount(series);
        exercise.setTraining(training);

        exercises.add(exercise);

        trainingRepository.save(training);
        exerciseRepository.save(exercise);

        if(end.equals("true")){
            return "trainingForm";
        }

        Trainer trainer = trainingParticipant.getTrainer();
        List<TrainingParticipant> selected = trainer.getUsers();

        model.addAttribute("users", selected);
        return "trainer-logged";
    }



}
