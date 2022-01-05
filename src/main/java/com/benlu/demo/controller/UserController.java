package com.benlu.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.benlu.demo.model.Person;
import com.benlu.demo.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {

    boolean params_present = false; // awful solution, fix
    List <Person> output;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "people", params = {"userId", "name", "byear", "dyear", "profession"})
    public List <Person> getUsers(@RequestParam String userId, String name, String byear, String dyear, String profession) throws IOException, URISyntaxException {
        params_present = true;

        // awful solution, shouldnt take this many ifs... has to be more succinct way to do this
        if (!userId.equals("") && name.equals("") && byear.equals("") && dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByIdentifier(userId);
            return output;
        }
        else if (userId.equals("") && !name.equals("") && byear.equals("") && dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByName(name);
            return output;
        }
        else if (userId.equals("") && name.equals("") && !byear.equals("") && dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByBirthYear(byear);
            return output;
        }
        else if (userId.equals("") && name.equals("") && byear.equals("") && !dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByDeathYear(dyear);
            return output;
        }
        else if (userId.equals("") && name.equals("") && byear.equals("") && dyear.equals("") && !profession.equals("")) {
            output = this.userRepository.findByProfession(profession);
            return output;
        }
        else if (!userId.equals("") && !name.equals("") && byear.equals("") && dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByIdentifierAndName(userId, name);
            return output;
        }
        else if (!userId.equals("") && name.equals("") && !byear.equals("") && dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByIdentifierAndBirthYear(userId, byear);
            return output;
        }
        else if (!userId.equals("") && name.equals("") && byear.equals("") && !dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByIdentifierAndDeathYear(userId, dyear);
            return output;
        }
        else if (!userId.equals("") && name.equals("") && byear.equals("") && dyear.equals("") && !profession.equals("")) {
            output = this.userRepository.findByIdentifierAndProfession(userId, profession);
            return output;
        }
        else if (userId.equals("") && !name.equals("") && !byear.equals("") && dyear.equals("") && profession.equals("")) {
            output = this.userRepository.findByNameAndBirthYear(name, byear);
            return output;
        }

        return output;
    }

    @GetMapping(value = "people", params = {})
    public List <Person> getUsers() throws IOException, URISyntaxException {
        if (!params_present) { // bad solution
            return this.userRepository.findAll();
        } else {
            params_present = false;
            return output;
        }
    }
}