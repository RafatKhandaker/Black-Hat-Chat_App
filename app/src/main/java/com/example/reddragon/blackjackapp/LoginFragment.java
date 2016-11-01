package com.example.reddragon.blackjackapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by RedDragon on 10/27/16.
 */

public class LoginFragment extends Fragment {
    public static EditText emailTextView;
    public static  String emailText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_layout, container , false);
    }

    // -----------------------------LOGIN FRAG METHODS --------------------------------------------
    // -------------------------NEEDS TO BE CALLED IN FRAGMENT ACTIVITY ----------------------------

    public void emailTextLogic(){
        if(buildEmailTextlogic(emailTextView, emailText) == false){
            emailTextView.setTextColor(500000);
            emailTextView.setText("! Error Email Format !");

        }else{/* send data to server (sql database) */}
    }

    public boolean buildEmailTextlogic(EditText emailTextView, String emailText){

        int i = 0;
        boolean result = false;
        boolean checkpass1 = false;
        boolean checkpass2 = false;

        emailTextView.findViewById(R.id.et_enter_email);
        emailText = emailTextView.getText().toString();
        String checkCom = (emailText.substring(i, (i+2)));
        String com = ".com";


        for ( i = 0; i < emailText.length(); i++){

            if(emailText.charAt(i) == '@'){
                checkpass1 = true;
            }
            if(checkCom.equals(com)){
                checkpass2 = true;
            }
        }

        if(checkpass1 == checkpass2 == true){
            result = true;
        }
        return result;
    }
}
