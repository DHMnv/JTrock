package com.jtrok.iceteck.jtrock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;


public class sign_in extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private static final int RC_SIGN_IN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        // we check if the user is already look in and send him to his page directly
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(this, dashbord.class)); // launch the dashboard
            // we will put the code later
        } else {
            startActivityForResult(
                    AuthUI.getInstance() //call the various providers to sign in the user
                            .createSignInIntentBuilder()
                            .setProviders(
                                    AuthUI.GOOGLE_PROVIDER,
                                    AuthUI.FACEBOOK_PROVIDER
                            ).build(), RC_SIGN_IN
            );
        }

    }

    // here we check if the sign in was successful and redirect the user to the home page
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if(resultCode == RESULT_OK) {
                // user is signed in!
                startActivity(new Intent(this, dashbord.class)); // to complete after
                //finish();
               // return;
            }
        }

        else {

            Toast.makeText(this, "sorry we couldn't sign you in", Toast.LENGTH_SHORT).show();
        }


    }
}
