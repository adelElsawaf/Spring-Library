package org.library.System.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {
    private static Boolean isDataNotValid(Object Data) {
        return Data == null;
    }

    @RequestMapping("/")
    public static List<User> readAllUsers() {
        return UserService.readAllUsers();
    }

    @RequestMapping("/{userId}")
    public static Optional<User> readUser(@PathVariable UUID userId) {
        return UserService.readUser(userId);
    }

    @PostMapping("/users")
    public static void createUser(@RequestBody User recent) {
        UserService.createUser(recent);
    }

    @PutMapping("/{userId}")
    public static void updateUser(@PathVariable UUID userId, @RequestBody User recent) {
        UserService.updateUser(userId, recent);
    }

    @DeleteMapping("/{userId}")
    public static void delete(@PathVariable UUID userId) {
        UserService.deleteUser(userId);
    }

    @PostMapping("/login")
    public Object logIn(@RequestBody User user) {
        if (isDataNotValid(user.getUserName())) {
            return "empty user name field";
        } else if (isDataNotValid(user.getPassword())) {
            return "empty password field";
        } else {
            return UserService.logIn(user.getUserName(), user.getPassword());
        }
    }
}
