package t2company.com.uy.teamis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity {
    EditText emailid,password;
    Button btn_login;
    Button btnSendToResetPassword;
    FirebaseAuth mFirebaseAuth;
    private ProgressDialog mDialog;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private boolean validarEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        btnSendToResetPassword=findViewById(R.id.btnSendToResetPassword);
        mDialog = new ProgressDialog(this);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){
                    Toast.makeText(LoginActivity.this,"Usted está conectado",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Por favor Iniciar sesión",Toast.LENGTH_SHORT).show();
                }
            }
        };

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty() || !validarEmail(email)){
                    emailid.setError("Por favor ingrese un correo valido");
                    emailid.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Por favor ingrese una contraseña valida");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Campo vacio!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mDialog.setMessage("Iniciando sesion...");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"Error de inicio de sesión, cuenta invalida",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intToHome = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intToHome);

                            }
                            mDialog.dismiss();
                        }
                    });

                }
                else{
                    Toast.makeText(LoginActivity.this,"Se produjo un error!",Toast.LENGTH_SHORT).show();

                }

            }
        });
        btnSendToResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ResetPasswordActivity.class));
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
