package com.example.reddragon.blackjackapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import static com.example.reddragon.blackjackapp.IntroPageActivity.TAG;
import static com.example.reddragon.blackjackapp.IntroPageActivity.checkGetStartedVal;
import static com.example.reddragon.blackjackapp.IntroPageActivity.checkLoginVal;

/**
 * Created by RedDragon on 10/28/16.
 */

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        if(checkLoginVal == true){
            Log.d(TAG, "" + checkLoginVal);
            launchLoginFragment();
        }else if(checkGetStartedVal == true){
            Log.d(TAG, "" + checkGetStartedVal);
            launchGetStartedFragment();
        }

    }

    private void launchLoginFragment(){
        checkLoginVal = false;
        FragmentManager fragManage = getFragmentManager();
        FragmentTransaction fragTrans = fragManage.beginTransaction();
        final LoginFragment loginFrag = new LoginFragment();
        fragTrans.add(R.id.fragment_container, loginFrag);
        fragTrans.commit();
    }

    private void launchGetStartedFragment(){
        checkGetStartedVal = false;
        FragmentManager fragManager = getFragmentManager();
        FragmentTransaction fragTransact = fragManager.beginTransaction();
        final GetStartedFragment getStartFrag = new GetStartedFragment();
        fragTransact.add(R.id.fragment_container,getStartFrag);
        fragTransact.commit();
    }
}
