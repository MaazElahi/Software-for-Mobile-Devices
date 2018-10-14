package com.example.dell.room.Database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.dell.room.Model.User;

import java.util.List;

import io.reactivex.Flowable;

public interface UserDataSource {
    Flowable<User> getUserById(int userID);
    Flowable<List<User>> getAllUsers();
    void insertUser(User... users);
    void updateUser(User... users);
    void deleteUser(User... user);
    void deleteAllUsers();
}
