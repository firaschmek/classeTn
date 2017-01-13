package com.example.applisys.classetn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.applisys.classetn.activities.BaseActivity;
import com.example.applisys.classetn.fragment.AuthFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new AuthFragment(),R.id.activity_main_FrameLayout);
    }
}
