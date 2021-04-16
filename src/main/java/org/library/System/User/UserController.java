package org.library.System.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class UserController {

    @RequestMapping("/users")
    public static List<User> readAllUsers() {
        return UserService.readAllUsers();
    }

    @RequestMapping("/users/{userId}")
    public static Optional<User> readUser(@PathVariable UUID userId) {
        return UserService.readUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public static void createUser(@RequestBody User recent) {
        UserService.createUser(recent);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
    public static void updateUser(@PathVariable UUID userId, @RequestBody User recent) {
        UserService.updateUser(userId, recent);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public static void delete(@PathVariable UUID userId) {
        UserService.deleteUser(userId);
    }


}
