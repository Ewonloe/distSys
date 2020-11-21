package com.example.services;

import com.example.models.User;
import com.example.repositories.UserRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserService {

    @Resource
    UserRepo userRepo;

    @GetMapping("/all")
    public List<User> getAllUser()
    {
        return userRepo.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id)
    {
        return userRepo.getUser(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public String createUser(@RequestBody User user)
    {
        return userRepo.createUser(user);
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateUser(@RequestBody User user)
    {
        return userRepo.updateUser(user);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody User user)
    {
        return userRepo.deleteUser(user);
    }
}
