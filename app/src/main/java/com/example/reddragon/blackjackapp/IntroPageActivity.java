package com.example.reddragon.blackjackapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.example.reddragon.blackjackapp.configuration.config;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by RedDragon on 10/26/16.
 */

public class IntroPageActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{


    private static final int RECOVERY_DIALOG_REQUEST = 1;
    public static final String TAG = "Log:";
    private YouTubePlayerView youTubeView;   // Youtube Player View
    public static boolean checkLoginVal = false;
    public static boolean checkGetStartedVal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page_main);

        Button login = (Button) findViewById(R.id.btn_Login);
        Button getStarted = (Button) findViewById(R.id.btn_Start);

        startYoutube();

        login.setOnClickListener(buildLoginListener());
        getStarted.setOnClickListener(buildGetStartedlistener());
    }

    public View.OnClickListener buildLoginListener(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkLoginVal = true;
                launchFragmentActivity(v.getContext());
            }
        };
    }

    public View.OnClickListener buildGetStartedlistener(){
        return new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkGetStartedVal = true;
                launchFragmentActivity(v.getContext());
            }
        };
    }

    public void launchFragmentActivity(Context context){
        Intent intent = new Intent(context, FragmentActivity.class);
        context.startActivity(intent);
    }



// ---------------------------------------YOUTUBE OVERRIDE METHODS-----------------------------------------------
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.loadVideo(config.YOUTUBE_VIDEO_CODE);

            // Hiding player controls
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(config.DEVELOPER_KEY, this);
        }
    }

//---------------------------------------------YOUTUBE METHODS --------------------------------------

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.vv_anon_vid);
    }

    public void startYoutube(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        youTubeView = (YouTubePlayerView) findViewById(R.id.vv_anon_vid);

        // Initializing video player with developer key
        youTubeView.initialize(config.DEVELOPER_KEY, this);
    }

}

//---------------------------------------REPLACE INTO CLASS (OLD)------------------------

// private YouTubePlayer.OnInitializedListener onInitializedListener;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.intro_page_main);
//
//        final YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.vv_anon_vid);
//        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.loadVideo("_oEA18Y8gM0");
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };
//
//
//        Button b = (Button) findViewById(R.id.btn_Login);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                youTubeView.initialize(config.DEVELOPER_KEY, onInitializedListener);
//
//            }
//        });
//    }