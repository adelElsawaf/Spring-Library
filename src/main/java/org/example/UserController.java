package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/users")
    public static List<User> getAllUsers() {
        return User.getAllUsers();
    }

    @RequestMapping("/users/{userName}")
    public static User getUser(@PathVariable String userName) {
        return User.getUser(userName);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/Register")
    public static void Register(@RequestBody User recent) {
        User.Register(recent);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/update/{userName}")
    public static void update(@RequestBody User recent, @PathVariable String userName) {
        User.Edit(recent, userName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{userName}")
    public static void delete(@PathVariable String userName) {
        User.delete(userName);
    }
}
