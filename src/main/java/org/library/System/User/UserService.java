package org.library.System.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public static List<User> getAllUsers() {
        List<User> usersInfo = new ArrayList<>();
        userRepository.findAll().forEach(usersInfo::add);
        return usersInfo;
    }

    public static void AddUser(User recent) {
        userRepository.save(recent);
    }

    public static Optional<User> getUser(String userName) {
        return userRepository.findById(userName);
    }

    public static void EditUser(String userName, User AfterEditUser) {
        userRepository.deleteById(userName);
        userRepository.save(AfterEditUser);
    }

    public static void deleteUser(String userName) {
        userRepository.deleteById(userName);
    }
}
