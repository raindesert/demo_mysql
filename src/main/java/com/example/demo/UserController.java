package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<TUser> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/cnt")
    public Long getCnt() {
        return userService.getCnt();
    }

    @PostMapping("/create")
    public TUser createUser(@RequestBody TUser user) {
        return userService.saveUser(user);
    }

    @PostMapping("/load")
    public Optional<TUser> loadUser(@RequestBody LoadKey key) {
        return userService.loadUser(key.getUserId());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
