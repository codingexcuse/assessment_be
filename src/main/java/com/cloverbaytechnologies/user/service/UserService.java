package com.cloverbaytechnologies.user.service;

import com.cloverbaytechnologies.user.model.User;
import com.cloverbaytechnologies.user.repository.UserRepository;
import com.cloverbaytechnologies.user.request.UserRequest;
import com.cloverbaytechnologies.user.response.UserResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getUsers() {
        List<UserResponse> userResponseList = new ArrayList<UserResponse>();
        List<User> userList =  userRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
        for(User temp : userList){
            UserResponse addResponse = new UserResponse();
            addResponse.setFullName(temp.getFirstName() + " " + temp.getLastName());
            addResponse.setEmailAddress(temp.getEmail());
            addResponse.setPhone(temp.getPhoneNumber());
            addResponse.setUserState(temp.isUserState());
            addResponse.setCompanyName(temp.getCompanyName());
            userResponseList.add(addResponse);
        }
        return  userResponseList;
    }

    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User is not present"));
        UserResponse userResponse = new UserResponse();
        userResponse.setFullName(user.getFirstName() + " " + user.getLastName());
        userResponse.setEmailAddress(user.getEmail());
        userResponse.setPhone(user.getPhoneNumber());
        userResponse.setUserState(user.isUserState());
        userResponse.setCompanyName(user.getCompanyName());
        return userResponse;
    }

    public User addUser(@Valid UserRequest request) {

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setUserState(request.isUserState());
        user.setCompanyName(request.getCompanyName());
        return userRepository.save(user);
    }




    @Transactional
    public User editUser(Long UserPathid, UserRequest request) {

        User userSave = userRepository.findById(UserPathid)
                .orElseThrow(() -> new IllegalStateException("User is not present"));
        userSave.setFirstName(request.getFirstName());
        userSave.setLastName(request.getLastName());
        userSave.setEmail(request.getEmail());
        userSave.setPhoneNumber(request.getPhoneNumber());
        userSave.setUserState(request.isUserState());
        userSave.setCompanyName(request.getCompanyName());
        return userSave;
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Id is not present");
        }
        userRepository.deleteById(id);
    }


    public List<User> firstNameFilter(String firstName) {
        return userRepository.findUserByFirstName(firstName);
    }

    public List<User> lastNameFilter(String lastName) {
        return userRepository.findUserByLastName(lastName);
    }

    public Optional<User> emailFilter(String email) {
        return userRepository.findUserByEmail(email);
    }
}
