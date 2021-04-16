package org.library.System.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserService {
    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public static List<User> readAllUsers() {
        List<User> usersInfo = new ArrayList<>();
        userRepository.findAll().forEach(usersInfo::add);
        return usersInfo;
    }

    public static void createUser(User recent) {
        userRepository.save(recent);
    }

    public static Optional<User> readUser(UUID userId) {
        return userRepository.findById(userId);
    }

    public static void updateUser(UUID userId, User recentUser) {
        Optional<User> oldUser = userRepository.findById(userId);
        oldUser.get().setUserName(recentUser.getUserName());
        oldUser.get().setFirstName((recentUser.getFirstName()));
        oldUser.get().setLastName(recentUser.getLastName());
        oldUser.get().setPassword(recentUser.getPassword());
        oldUser.get().setType(recentUser.getType());
        userRepository.save(oldUser.get());

    }

    public static void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
