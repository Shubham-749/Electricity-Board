package com.example.ElectricityBoardCaseStudy.services;

import com.example.ElectricityBoardCaseStudy.model.User;
import com.example.ElectricityBoardCaseStudy.repositories.UserRepository;
import com.example.ElectricityBoardCaseStudy.requestObjects.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.name);
        user.setGender(request.gender);
        user.setDistrict(request.district);
        user.setState(request.state);
        user.setPinCode(request.pinCode);
        user.setOwnership(request.ownership);
        user.setGovernment_id_number(request.government_id_number);
        user.setGovernment_id_type(request.government_id_type);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

