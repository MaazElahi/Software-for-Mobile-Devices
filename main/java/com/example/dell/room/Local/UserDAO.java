package com.example.dell.room.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.dell.room.Model.User;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM users WHERE id=:userID")
    Flowable<User> getUserById(int userID);

    @Query("SELECT * FROM users")
    Flowable<List<User>> getAllUsers();

    @Insert
    void insertUser(User... users);

    @Update
    void updateUser(User... users);

    @Delete
    void deleteUser(User... user);

    @Query("DELETE FROM users")
    void deleteAllUsers();
}
