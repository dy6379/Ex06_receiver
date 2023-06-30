package com.busanit.ex06_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.yanzhenjie.permission.runtime.Permission;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Action;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndPermission.with(this).runtime().permission(Permission.RECEIVE_SMS).onGranted(new Action<List<String>>() {
            @Override
            public void onAction(List<String> data) {
                showToast("허용된 권한 개수 : "+data.size());
            }
        }).onDenied(new Action<List<String>>() {
            @Override
            public void onAction(List<String> data) {
                showToast("거부된 권한 개수 : "+data.size());
            }
        }).start();

    }

    private void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}