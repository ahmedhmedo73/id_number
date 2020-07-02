package com.example.magicidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText id;
    Button submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);
        result.setVisibility(View.GONE);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = id.getText().toString().trim();

                String dob = idNumber.substring(0,6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sgender ;

                if (gender < 5)
                    sgender = getString(R.string.female);
                else
                    sgender = getString(R.string.male);

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String snationality;
                if (nationality == 0)
                    snationality = getString(R.string.sa);
                else
                    snationality = getString(R.string.resident);

                String text = getString(R.string.dob) + dob + getString(R.string.brline) +getString(R.string.gender) + sgender + getString(R.string.brline)
                            + getString(R.string.nationality) + snationality + getString(R.string.brline);
                result.setText(text);
                result.setVisibility(View.VISIBLE);

            }
        });
    }
}





