package org.library.System.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/")
    public List<User> readAllUsers() {
        return UserService.readAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> readUser(@PathVariable UUID userId) {
        return UserService.readUser(userId);
    }

    @PostMapping("/")
    public void createUser(@RequestBody User recent) {
        UserService.createUser(recent);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable UUID userId, @RequestBody User recent) {
        UserService.updateUser(userId, recent);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        UserService.deleteUser(userId);
    }


}