package com.learning.lesson01.controllers;

import com.learning.lesson01.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"user"})
public class UserController {

    @GetMapping("index")
    public String index(){
        return "Index";
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        try {
            List<User> users = new ArrayList<>();
            users.add(new User(1, "username1", "password1"));
            users.add(new User(2, "username2", "password2"));
            users.add(new User(3, "username3", "password3"));
            return new ResponseEntity<>( users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    // http://localhost:8080/user/add?username=phupro
    @GetMapping("add")
    public String add(@RequestParam("username") String username){

        return "Added a User with userrname: " + username;
    }

    // http://localhost:8080/user/getDetail/123/phupro
    @GetMapping("getDetail/{id}/{username}")
    public String getDetail(@PathVariable("id") String id, @PathVariable("username") String username) {

        return "hello " + username + "  have id: " + id ;
    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        return "Update: " + user.toString();
    }

    //http://localhost:8080/user/updateList
    @PostMapping("/updateList")
    public String updateList(@RequestBody List<User> users) {
        String usersString =  users.stream()
                                    .map(User::toString)
                                    .collect(Collectors.joining("\n"));
        return "Updated List User:\n" + usersString  ;
    }

}
