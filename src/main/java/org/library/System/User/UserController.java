package org.library.System.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class UserController {

    @RequestMapping("/users")
    public static List<User> getAllUsers() {
        return UserService.getAllUsers();
    }

    @RequestMapping("/users/{userName}")
    public static Optional<User> getUser(@PathVariable String userName) {
        return UserService.getUser(userName);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/Register")
    public static void Register(@RequestBody User recent) {
        UserService.AddUser(recent);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/update/{userName}")
    public static void update(@PathVariable String userName,@RequestBody User recent) {
        UserService.EditUser(userName, recent);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{userName}")
    public static void delete(@PathVariable String userName) {
        UserService.deleteUser(userName);
    }


}
