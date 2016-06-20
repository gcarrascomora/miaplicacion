package com.example.gcarrasco.miaplicacion;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
       CallbackManager callbackManager;
       public  LoginButton loginButton;
       private AccessToken stado;
       TextView textView2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        System.out.println(loginButton);
        callbackManager = CallbackManager.Factory.create();
        //obtengo estado de la sesion
        stado=AccessToken.getCurrentAccessToken();
        sesionFacebook();


    }



//inicio de session de facebook}
    public  void sesionFacebook(){
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
               // Intent mainLobby = new Intent(MainActivity.this, homeacty.class);
                //AccessToken accessToken = loginResult.getAccessToken();
                //Profile profile = Profile.getCurrentProfile();
               // displayMessage(profile);
                getUserInfo(loginResult);

                finish();
            }

            

            @Override
            public void onCancel() {
                Intent main = new Intent(MainActivity.this, MainActivity.class);

                startActivity(main);

            }
            @Override
            public void onError(FacebookException error) {
            }
        });
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.e("data",data.toString());
    }









}
