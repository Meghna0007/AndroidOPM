package com.example.welcometoopm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private  static  final Pattern EMAIL_PATTERN =Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +"\\@"+
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+"("+"\\."+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+" );
    private  static  final Pattern PASSWORD_PATTERN= Pattern.compile("^(?=.*[0-9]).{6,}$");
    private  static  final Pattern PHONE_PATTERN= Pattern.compile("^(?=.*[0-9]).{10,}$");

    private AppCompatEditText editTextTextEmailAddress3;
    private AppCompatEditText editTextNumberPassword;
    private AppCompatEditText editTextPhone;

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        button = (Button) findViewById(R.id.submit1);

        editTextTextEmailAddress3 = this.findViewById(R.id.editTextTextEmailAddress3);
        editTextNumberPassword = this.findViewById(R.id.editTextNumberPassword);
        editTextPhone = this.findViewById(R.id.editTextPhone);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                boolean isPasswordValid = validatePassword();
                boolean isEmailValid = validateEmail();

                boolean isPhoneValid = validatePhone();
                if (isPasswordValid && isEmailValid && isPhoneValid) {

                        Intent categoryIntent = new Intent(SignUp.this, OTPActivity.class);
                        startActivity(categoryIntent);
                        finish();
                    } } });}
    private boolean validateEmail(){
        String emailInput =editTextTextEmailAddress3.getText().toString().trim();
        if (emailInput.isEmpty()){
            editTextTextEmailAddress3.setError("Field can't be empty");
            return false;}
        else
        if(!EMAIL_PATTERN.matcher(emailInput).matches()){
            editTextTextEmailAddress3.setError("Please enter a valid email.address");
            return false;}


        else   {
            editTextTextEmailAddress3.setError(null);
            return true;}
    }
    private boolean validatePassword(){
        String passwordInput =editTextNumberPassword.getText().toString().trim();
        if (passwordInput.isEmpty()){
            editTextNumberPassword.setError("Field can't be empty");
            return false;}
        else
        if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            editTextNumberPassword.setError("Password should be numeric and contain atleast 6 digits.");
            return false;}
        else {
            editTextNumberPassword.setError(null);
            return true;}
    }
    private boolean validatePhone(){
        String phoneInput =editTextPhone.getText().toString().trim();
        if (phoneInput.isEmpty()){
            editTextPhone.setError("Field can't be empty");
            return false;}
        else
        if(!PHONE_PATTERN.matcher(phoneInput).matches()){
            editTextPhone.setError("Password should be numeric and contain atleast 10 digits.");
            return false;}
        else {
            editTextPhone.setError(null);
            return true;}
    }
}
