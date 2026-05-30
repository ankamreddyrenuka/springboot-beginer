package com.renuka.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.renuka.demo.model.User;

public class UserService {

    private List<User> allUsers;

    public UserService(){
        allUsers = new ArrayList<>(); // Empty Array List
        allUsers.add(new User("Renuka", "Female", "/img/Renuka.png", 1));
        allUsers.add(new User("Hasini", "Female", "/img/Hasini.png", 2));
    }
    
    // Name is of our choice
    public List<User> getAllUsers(){
        return allUsers;
    }

    public User getOneUser(int id){
        for(int i = 0; i < allUsers.size(); i++){
            User u = allUsers.get(i);
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

    public User createUser(User u){
        allUsers.add(u);
        return u;
    }

    public User updateUser(int id, User user){
        for(int i = 0; i < allUsers.size(); i++){
            User u = allUsers.get(i);
            if(u.getId() == id){
                allUsers.set(i, user);
                return u;
            }
        }
        return null;
    }
    public void deleteUser(int id){
        for(int i = 0; i < allUsers.size(); i++){
            User u = allUsers.get(i);
            if(u.getId() == id){
                allUsers.remove(i);
                break;
            }
        }
    }
}