package com.example.welcometoopm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Profile extends AppCompatActivity {
    private  static  final Pattern Aadhaar_PATTERN= Pattern.compile("^(?=.*[0-9]).{12,}$");
private Button button4;
private TextView profile_btn;
private Uri imageUri;
private String myUri ="";
public Button Button4;
 private EditText area4;
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        button4 = findViewById(R.id.button4);
        area4=(EditText)findViewById(R.id.area4);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }


        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntent = new Intent(Profile.this,Congo.class);
                startActivity(categoryIntent);
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
        final String Name=area4.getText().toString();

        if(Name.length()==0)
        {
            area4.requestFocus();

            area4.setError("FIELD CANNOT BE EMPTY");
        }
        else if(!Name.matches("[a-zA-Z ]+"))
        {
            area4.requestFocus();
            area4.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }
        else
        {
            Toast.makeText(Profile.this,"Validation Successful",Toast.LENGTH_LONG).show();
        }
    }
}