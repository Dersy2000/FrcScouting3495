package mindcraft.scouting3495test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etGrade =  findViewById(R.id.etGrade);
        final EditText etName =  findViewById(R.id.etName);
        final EditText etPassword =  findViewById(R.id.etPassword);
        final Button bRegister = findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = etName.getText().toString();
                final String password = etPassword.getText().toString();
                final int grade = Integer.parseInt( etGrade.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                      try{
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean sucess =  jsonResponse.getBoolean("sucess");
                        if(sucess){
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            RegisterActivity.this.startActivity(intent);

                        }else{
                            AlertDialog.Builder
                        }
                    }catch (JSONObject e){
                          e.printStackTrace();
                      }

                }

                RegisterRequest registerRequest = new RegisterRequest(name, grade, password, );

            }
        });

    }
}


