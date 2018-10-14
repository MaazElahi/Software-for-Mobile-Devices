package com.example.dell.room.Local;

import com.example.dell.room.Database.UserDataSource;
import com.example.dell.room.Model.User;

import java.util.List;

import io.reactivex.Flowable;

public class UserData implements UserDataSource {

    private UserDAO userDAO;
    private static UserDataSource mInstance;
    public UserData(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public static UserDataSource getInstance(UserDAO userDAO)
    {
        if(mInstance==null)
        {
            mInstance=new UserData(userDAO);
        }
        return mInstance;
    }
    @Override
    public Flowable<User> getUserById(int userID) {
        return userDAO.getUserById(userID);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void insertUser(User... users) {
        userDAO.insertUser(users);
    }

    @Override
    public void updateUser(User... users) {
        userDAO.updateUser(users);
    }

    @Override
    public void deleteUser(User... user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void deleteAllUsers() {
        userDAO.deleteAllUsers();
    }
}
