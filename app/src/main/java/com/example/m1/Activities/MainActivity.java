package com.example.m1.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import com.example.m1.Model.User;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    EditText email;
    EditText f_name;
    EditText l_name;
    EditText number;
    EditText age;
    RadioGroup gender;
    RadioGroup dopa;
    EditText password;
    EditText confirmPassword;
    Button register;
    TextView switchAuthMode;
    TextView authMode;
    FirebaseAuth auth;
    boolean authflag;
    String docOrpat;
    String choose_gender;
    FirebaseDatabase database;
    FloatingActionButton addPic;
    private Uri imageUri;
    ImageView profilrPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setListeners();
        auth = FirebaseAuth.getInstance();

    }

    private void setListeners() {
        profilrPic = findViewById(R.id.profile);
        f_name = (EditText) findViewById(R.id.f_name);
        l_name = (EditText) findViewById(R.id.l_name);
        number = (EditText) findViewById(R.id.number);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirm_password);
        register = (Button) findViewById(R.id.register);
        switchAuthMode = (TextView) findViewById(R.id.switchAuthMode);
        authMode = (TextView) findViewById(R.id.authMode);
        database = FirebaseDatabase.getInstance();
        switchAuthMode.setOnClickListener(this);
        register.setOnClickListener(this);
        gender = findViewById(R.id.gender);
        dopa = findViewById(R.id.dopa);
        gender.setOnCheckedChangeListener(this);
        dopa.setOnCheckedChangeListener(this);
        addPic = findViewById(R.id.add_pic);
        addPic.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switchAuthMode:
                if (!authflag) {
                    authflag = true;
                    setContentView(R.layout.activity_signin);
                    email = (EditText) findViewById(R.id.email);
                    password = (EditText) findViewById(R.id.password);
                    authMode = (TextView) findViewById(R.id.authMode);
                    switchAuthMode = (TextView) findViewById(R.id.switchAuthMode);
                    switchAuthMode.setOnClickListener(this);
                    register = (Button) findViewById(R.id.register);
                    register.setOnClickListener(this);
                    switchAuthMode.setText("create a new account");
                    authMode.setText("log in");
                    register.setText("log in");
                } else {
                    authflag = false;
                    setContentView(R.layout.activity_signup);
                    setListeners();
                    switchAuthMode.setText("i already have an account");
                    register.setText("sign up");
                    authMode.setText("sign up");
                }
                break;
            case R.id.register:
                if (!authflag) {
                    signUp(email.getText().toString(), password.getText().toString(), confirmPassword.getText().toString(), f_name.getText().toString(), l_name.getText().toString(), number.getText().toString(), age.getText().toString());
                } else if (authflag) {
                    signIN(email.getText().toString(), password.getText().toString());
                }
                break;
            case R.id.add_pic:
                checkPermissions();
                break;
        }
    }

    private void signIN(String email, String password) {
        if (email.equals(""))
            Toast.makeText(MainActivity.this, "please enter your email", Toast.LENGTH_SHORT).show();
        else if (password.equals(""))
            Toast.makeText(MainActivity.this, "please enter your password", Toast.LENGTH_SHORT).show();
        else if (password.length() < 6)
            Toast.makeText(MainActivity.this, "password must have at least 6 characters", Toast.LENGTH_SHORT).show();
        else
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                    MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(MainActivity.this, "welcome back", Toast.LENGTH_SHORT).show();
                            } else if (task.getException().toString().contains("blocked")) {
                                Toast.makeText(MainActivity.this, "you have been blocked try again latter"
                                        , Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(MainActivity.this, (task.getException().toString().substring(task.getException().toString().indexOf(":") + 1))
                                        , Toast.LENGTH_SHORT).show();
                        }
                    }
            );
    }

    private void signUp(String email, String password, String confirmPassword, String f_name, String l_name, String number, String age) {
        if (f_name.equals(""))
            Toast.makeText(MainActivity.this, "please enter your first name", Toast.LENGTH_SHORT).show();
        else if (l_name.equals(""))
            Toast.makeText(MainActivity.this, "please enter your last name", Toast.LENGTH_SHORT).show();
        else if (email.equals(""))
            Toast.makeText(MainActivity.this, "please enter your email", Toast.LENGTH_SHORT).show();
        else if (password.equals(""))
            Toast.makeText(MainActivity.this, "please enter your password", Toast.LENGTH_SHORT).show();
        else if (number.equals(""))
            Toast.makeText(MainActivity.this, "please enter your phone number", Toast.LENGTH_SHORT).show();
        else if (age.equals(""))
            Toast.makeText(MainActivity.this, "please enter your age", Toast.LENGTH_SHORT).show();
        else if (gender.getCheckedRadioButtonId() == -1)
            Toast.makeText(MainActivity.this, "please select your gender", Toast.LENGTH_SHORT).show();
        else if (dopa.getCheckedRadioButtonId() == -1)
            Toast.makeText(MainActivity.this, "please select whether you are doctor or patent", Toast.LENGTH_SHORT).show();
        else if (password.length() < 6)
            Toast.makeText(MainActivity.this, "password must have at least 6 characters", Toast.LENGTH_SHORT).show();
        else if (confirmPassword.equals(""))
            Toast.makeText(MainActivity.this, "please confirm your password", Toast.LENGTH_SHORT).show();
        else if (!password.equals(confirmPassword))
            Toast.makeText(MainActivity.this, "password mismatch", Toast.LENGTH_SHORT).show();
        else
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        String uid = auth.getCurrentUser().getUid();
                        User newuser = new User(f_name, l_name, email, choose_gender, number, Integer.parseInt(age), docOrpat);
                            database.getReference().child("users").child(uid).setValue(newuser).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(MainActivity.this, "user added successfully", Toast.LENGTH_SHORT).show();
                                } else
                                    Toast.makeText(MainActivity.this, (task.getException().toString().substring(task.getException().toString().indexOf(":") + 1))
                                            , Toast.LENGTH_SHORT).show();

                            }
                        });

                    } else
                        Toast.makeText(MainActivity.this, (task.getException().toString().substring(task.getException().toString().indexOf(":") + 1))
                                , Toast.LENGTH_SHORT).show();

                }

            });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.male:
                choose_gender = "male";
                break;
            case R.id.female:
                choose_gender = "female";
                break;
            case R.id.doctor:
                docOrpat = "doctor";
                break;
            case R.id.patient:
                docOrpat = "patient";
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            imageUri = data.getData();
            profilrPic.getLayoutParams().height=200;
            profilrPic.getLayoutParams().width=200;
            profilrPic.setImageURI(imageUri);

        }
    }

    private void checkPermissions() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                        Intent galleryIntent = new Intent();
                        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                        galleryIntent.setType("image/*");
                        startActivityForResult(galleryIntent, 1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getPackageName(), "");
                            intent.setData(uri);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }
}