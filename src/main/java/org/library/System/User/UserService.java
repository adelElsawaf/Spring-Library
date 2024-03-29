package org.library.System.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
        Optional<User> oldOptionalUser = userRepository.findById(userId);
        if (oldOptionalUser.isPresent()) {
            User oldUser = oldOptionalUser.get();
            oldUser.setUserName(recentUser.getUserName());
            oldUser.setFirstName((recentUser.getFirstName()));
            oldUser.setLastName(recentUser.getLastName());
            oldUser.setPassword(recentUser.getPassword());
            oldUser.setType(recentUser.getType());
            userRepository.save(oldUser);
        }

    }

    public static void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    public static Object logIn(String userName, String password) {
        User loggedInUser = userRepository.findByUserName(userName);
        if (loggedInUser == null) {
            return "user name doest exist";
        } else {
            if (!Objects.equals(loggedInUser.getPassword(), password)) {
                return "Wrong password";
            } else {
                return loggedInUser;
            }
        }
    }
}
