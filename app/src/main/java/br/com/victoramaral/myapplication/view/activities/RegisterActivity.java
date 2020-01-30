package br.com.victoramaral.myapplication.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import br.com.victoramaral.myapplication.R;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private TextInputLayout inputEmail;
    private Button buttonLogin;
    private Button buttonAnonimo;

    public static final String NOME_KEY = "nome";
    public static final String EMAIL_KEY = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inputNome.getEditText().getText().toString().isEmpty()
                        && !inputEmail.getEditText().getText().toString().isEmpty()) {

                    Intent intent = new Intent(RegisterActivity.this,
                            MainActivity.class);
                    String nomeDigitado = inputNome.getEditText().getText().toString();
                    String emailDigitado = inputEmail.getEditText().getText().toString();

                    Bundle bundle = new Bundle();
                    bundle.putString(NOME_KEY, nomeDigitado);
                    bundle.putString(EMAIL_KEY, emailDigitado);

                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    inputNome.setError("Este campo não pode ser vazio");
                    inputEmail.setError("Este campo não pode ser vazio");
                }
            }
        });

        buttonAnonimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this,
                        MainActivity.class);

                String nomeDigitado = "Anônimo";
                String emailDigitado = "Anônimo";

                Bundle bundle = new Bundle();
                bundle.putString(NOME_KEY, nomeDigitado);
                bundle.putString(EMAIL_KEY, emailDigitado);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void initViews() {
        inputNome = findViewById(R.id.textInputNome);
        inputEmail = findViewById(R.id.textInputEmail);
        buttonLogin = findViewById(R.id.buttonLogar);
        buttonAnonimo = findViewById(R.id.buttonAnonimo);
    }
}
