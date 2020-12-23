package com.example.welcometoopm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.util.regex.Pattern;

public class logos extends AppCompatActivity {
    private  static  final Pattern EMAIL_PATTERN =
            Pattern.compile(
                   "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +"\\@"+
                           "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+"("+"\\."+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+" );
    private  static  final Pattern PASSWORD_PATTERN= Pattern.compile("^(?=.*[0-9]).{6,}$");
    private  static  final Pattern PHONE_PATTERN= Pattern.compile("^(?=.*[0-9]).{10,}$");
    private Button signUp;
public Button login;
private AppCompatEditText createNewUser;
private AppCompatEditText loginPassword;
    private ImageView logo12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logos);
        signUp = findViewById(R.id.signUp);
        logo12= findViewById(R.id.logo12);

    createNewUser = this.findViewById(R.id.createNewUser);
     loginPassword = this.findViewById(R.id.loginPassword);

        logo12.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent categoryIntent = new Intent(logos.this,OTPActivity.class);
            startActivity(categoryIntent);
            finish();
        }
    });

    signUp.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent categoryIntent = new Intent(logos.this,SignUp.class);
                                      startActivity(categoryIntent);
                                      finish();
                                  }});
    login = findViewById(R.id.login);
    login.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {
            boolean isPasswordValid = validatePassword();
            boolean isEmailValid = validateEmail();

            if (isPasswordValid && isEmailValid) {
                Intent categoryIntent = new Intent(logos.this, Profile.class);
                startActivity(categoryIntent);
                finish();
            }
        }
    });


}
private boolean validateEmail(){
     String emailInput =createNewUser.getText().toString().trim();
     if (emailInput.isEmpty()){
         createNewUser.setError("Field can't be empty");
         return false;}
     else
         if(!EMAIL_PATTERN.matcher(emailInput).matches()){
         createNewUser.setError("Please enter a valid email.address");
         return false;}


      else   {
         createNewUser.setError(null);
         return true;}
     }
    private boolean validatePassword(){
        String passwordInput =loginPassword.getText().toString().trim();
        if (passwordInput.isEmpty()){
            loginPassword.setError("Field can't be empty");
            return false;}
        else
            if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
                loginPassword.setError("Password should be numeric and contain atleast 6 digits.");
                return false;}
            else {
                loginPassword.setError(null);
                return true;}
        }




    }
