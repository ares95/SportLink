package com.project.is.sportlink.ui;

import android.content.Intent;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.is.sportlink.R;
import com.project.is.sportlink.logic.LoginController;

/**
 * Created by luciogrimaldi on 22/12/16.
 */

public class LoginActivity extends AppCompatActivity {

    private boolean IS_UTENTE;
    private boolean IS_GESTORE;
    private TextView titleAppNameTextView;
    private EditText eMailEditText;
    private EditText passwordEditText;
    private LoginController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        titleAppNameTextView = (TextView) findViewById(R.id.titleAppName);
        eMailEditText = (EditText) findViewById(R.id.editTextEmail);
        passwordEditText = (EditText) findViewById(R.id.ediTextPassword);

        //prendo i dati della welcome activity per sapere se è un utente o un gestore
        IS_UTENTE = getIntent().getBooleanExtra("IS_UTENTE",false);
        IS_GESTORE = getIntent().getBooleanExtra("IS_GESTORE",false);


        //Set custom font
        Typeface RobotoThinFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        titleAppNameTextView.setTypeface(RobotoThinFont);
        eMailEditText.setTypeface(RobotoThinFont);
        passwordEditText.setTypeface(RobotoThinFont);

        eMailEditText.setFocusableInTouchMode(true);


        //da inserire nel click listner per login
        controller= new LoginController(this);
        controller.MetodoLogin();
    }

    public String getEmail(){
        return eMailEditText.getText().toString();
    }

    public String getPassword(){
        return passwordEditText.getText().toString();
    }

    public void openSignUpForm(View v){
            Intent i = new Intent(this, RegistrationActivity.class);
            i.putExtra("IS_UTENTE",IS_UTENTE);
            i.putExtra("IS_GESTORE",IS_GESTORE);
            startActivity(i);
    }

    public boolean isUtente(){
        if (IS_UTENTE) {
            return true;
        }
        else
            return false;
    }

    public boolean isGestore(){

        if (IS_GESTORE) {
            return true;
        }
        else
            return false;
    }

}
