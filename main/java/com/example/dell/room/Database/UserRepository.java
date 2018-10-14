package com.example.dell.room.Database;

import com.example.dell.room.Model.User;

import java.util.List;

import io.reactivex.Flowable;

public class UserRepository implements UserDataSource {

    private UserDataSource mLocalDataSource;
    private static UserRepository mInstance;

    public UserRepository(UserDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }
    public static UserRepository getInstance(UserDataSource mLocalDataSource)
    {
        if(mInstance==null)
        {
            mInstance= new UserRepository(mLocalDataSource);
        }
        return mInstance;
    }
    @Override
    public Flowable<User> getUserById(int userID) {
        return mLocalDataSource.getUserById(userID);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return mLocalDataSource.getAllUsers();
    }

    @Override
    public void insertUser(User... users) {
        mLocalDataSource.insertUser(users);
    }

    @Override
    public void updateUser(User... users) {
        mLocalDataSource.updateUser(users);
    }

    @Override
    public void deleteUser(User... user) {
        mLocalDataSource.deleteUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mLocalDataSource.deleteAllUsers();
    }
}
