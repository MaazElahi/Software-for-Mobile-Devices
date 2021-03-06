package com.example.dell.room;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.room.Database.UserRepository;
import com.example.dell.room.Local.UserData;
import com.example.dell.room.Local.UserDatabase;
import com.example.dell.room.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ListView lstUser;
    private FloatingActionButton fab;
    List<User> userList=new ArrayList<>();
    ArrayAdapter adapter;
    private CompositeDisposable compositeDisposable;
    private UserRepository userRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable=new CompositeDisposable();


        lstUser=(ListView)findViewById(R.id.lstUser);
        fab=(FloatingActionButton)findViewById(R.id.fab);

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,userList);
        registerForContextMenu(lstUser);
        lstUser.setAdapter(adapter);

        UserDatabase userDatabase=UserDatabase.getInstance(this);
        userRepository=UserRepository.getInstance(UserData.getInstance(userDatabase.userDAO()));
        loadData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disposable disposable= io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
                @Override
                    public void subscribe(ObservableEmitter<Object> e) throws Exception{
                        User user=new User("MalikMaaz", UUID.randomUUID().toString()+"@hotmail.com");
                        userRepository.insertUser(user);
                        e.onComplete();
                }
                })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer() {
                                       @Override
                                       public void accept(Object o) throws Exception {
                                           Toast.makeText(MainActivity.this, "User added!", Toast.LENGTH_SHORT).show();
                                       }
                                   }, new Consumer<Throwable>() {
                                       @Override
                                       public void accept(Throwable throwable) throws Exception {
                                           Toast.makeText(MainActivity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                       }
                                   },
                                new Action() {
                                    @Override
                                    public void run() throws Exception {
                                        loadData();
                                    }
                                }
                        );
            }
        });
    }

    private void loadData() {
        Disposable disposable=userRepository.getAllUsers().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<List<User>>() {
            @Override
            public void accept(List<User> users) throws Exception {
                onGetAllUserSuccess(users);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Toast.makeText(MainActivity.this,""+throwable.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        compositeDisposable.add(disposable);
    }

    private void onGetAllUserSuccess(List<User> users) {
        userList.clear();
        userList.addAll(users);
        adapter.notifyDataSetChanged();
    }
}
