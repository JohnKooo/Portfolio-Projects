package com.example.finaltypeb.model;

import com.example.finaltypeb.QuestionsRepository;
import com.example.finaltypeb.TestRepository;
import com.example.finaltypeb.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/")
public class MainController {
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private UserRepository userRepository;

    //User methods below
    @PostMapping(path = "/user/add")
    public @ResponseBody String addNewUser(@RequestBody User user){
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/user/all")
    public @ResponseBody Iterable<User> getUser(){
        return userRepository.findAll();
    }

    @PutMapping(path = "/user/update/{id}")
    public @ResponseBody String updateUser(@PathVariable("id")int id, @RequestBody User updatedUser){
        //find the game
        Optional<User> optionalUser = userRepository.findById(id);

        //update the game
        if (optionalUser.isPresent()){
            //make a new user
            User existingUser = optionalUser.get();
            //update
            existingUser.setBestScore(updatedUser.getBestScore());
            // update database
            userRepository.save(existingUser);
            //inform user
            return "Updated";
        }else {
            //throw an error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    //Question methods below
    @PostMapping(path = "/dev/questions/add")
    public @ResponseBody String addQuestions(@RequestBody Questions questions){
        questionsRepository.save(questions);
        return "Saved";
    }

    @GetMapping(path = "/questions/all")
    public @ResponseBody Iterable<Questions> getQuestions(){
        return questionsRepository.findAll();
    }

    @DeleteMapping(path = "/dev/question/delete/{id}")
    public @ResponseBody String deleteQuestion(@PathVariable("id")Integer id){
        Optional<Questions> optionalQuestions = questionsRepository.findById(id);

        if (optionalQuestions.isPresent()){
            // delete the Question
            Questions question = optionalQuestions.get();
            questionsRepository.delete(question);
            return "Deleted";
        }else {
            //throw an error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found");
        }
    }

    // Once the user selects an answer and hits next, make a json object only
    // including the userChoice and userId variables values from the user.
    @PutMapping(path = "/question/update/{id}")
    public @ResponseBody String updateQuestions(@PathVariable("id")int id, @RequestBody Questions updatedQuestion){
        //find the game
        Optional<Questions> optionalQuestions = questionsRepository.findById(id);

        //update the game
        if (optionalQuestions.isPresent()){
            //make a new question
            Questions existingQuestion = optionalQuestions.get();
            //update
            existingQuestion.setUserChoice(updatedQuestion.getUserChoice());
            existingQuestion.setUserId(updatedQuestion.getUserId());
            // update database
            questionsRepository.save(existingQuestion);
            //inform user
            return "Updated";
        }else {
            //throw an error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found");
        }
    }

    //Test methods below
    @PostMapping(path = "/dev/test/add")
    public @ResponseBody String addTest(@RequestBody Test test){
        testRepository.save(test);
        return "Saved";
    }
}
