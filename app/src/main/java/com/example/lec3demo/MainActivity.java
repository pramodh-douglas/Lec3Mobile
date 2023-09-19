package com.example.lec3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Concert Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNumTickets = findViewById(R.id.editTxtNumTickets);
        Button btnBookConcert = findViewById(R.id.btnBookConcert);
        Spinner spinnerConcertTypes = findViewById(R.id.spinnerConcertType);

        spinnerConcertTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Selected Rock Band", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Selected Jazz Band", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Selected Country Band", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Selected Blues Band", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnBookConcert.setOnClickListener((View view) -> {
            if(editTextNumTickets.getText().toString().isEmpty()) {
                Toast.makeText(this, "Number of tickets must be entered", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    int numTickets = Integer.parseInt((editTextNumTickets.getText().toString()));
                    int index = spinnerConcertTypes.getSelectedItemPosition();
                    double cost = 0;
                    switch (index) {
                        case 0:
                            cost = numTickets*79.99;
                            break;
                        case 1:
                            cost = numTickets*69.99;
                            break;
                        case 2:
                            cost = numTickets*59.99;
                            break;
                        case 3:
                            cost = numTickets*49.99;
                            break;
                    }
                    DecimalFormat df = new DecimalFormat("$#.##");
                    String outputCostTxt = df.format(cost);

                    Toast.makeText(this, outputCostTxt, Toast.LENGTH_SHORT).show();
                    // Create a bundle of data
                    // Create intent and Put it in the intent object
                    // Use the intent to start next activity
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.d(TAG, "Error in parse in number of tickets");
                    Toast.makeText(this, "Number of tickets must be whole number > 0", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}