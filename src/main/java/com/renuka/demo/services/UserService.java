package com.renuka.demo.services;
import java.util.ArrayList;
import java.util.List;
import com.renuka.demo.model.User;

public class UserService{
    public List<User> allUsers;

    public UserService(){
        allUsers = new ArrayList<>();
        allUsers.add(new User("Renuka","/img/Jane.png","female",0));
        allUsers.add(new User("Sirish","/img/John.png","male",0));
    }
    

    public void addUser(String name,String image,String gender){
        User newUser = new User(name,image,gender,allUsers.size());
        allUsers.add(newUser);
    }

    public List<User> getAllUsers(){
        return allUsers;
    }

    public User getSingleUser(Integer id){
        return allUsers.get(id);
    }

    public void updateUser(String name,String gender,String image,int idx){
        User updatedUser = new User(name,image,gender,idx);
        allUsers.set(idx,updatedUser);
    }

    public void deleteUser(Integer id){
        allUsers.remove((int)id);
    }
}