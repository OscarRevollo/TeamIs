package t2company.com.uy.teamis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText mEditTextEmail;
    private Button mButtonResetPassword;

    private String email="";
    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mButtonResetPassword = (Button) findViewById(R.id.btnResetPassword);


        mButtonResetPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                email = mEditTextEmail.getText().toString();
                if(!validarEmail(email)){
                    mEditTextEmail.setError("Por favor ingrese un correo valido");
                    mEditTextEmail.requestFocus();
                }else {
                    if (!email.isEmpty()) {
                        mDialog.setMessage("Espere un momento...");
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.show();
                        resetPassword();

                    } else {

                        Toast.makeText(ResetPasswordActivity.this, "Debe ingresar el email", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void resetPassword() {
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    Toast.makeText(ResetPasswordActivity.this,"Se ha enviado un correo para reestablecer tu contraseña",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ResetPasswordActivity.this,"No se pudo enviar el correo para reestablecer tu contraseña",Toast.LENGTH_SHORT).show();

                }
                mDialog.dismiss();
            }
        });
    }
    private boolean validarEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }
}
