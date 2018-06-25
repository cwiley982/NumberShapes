package com.caitlynwiley.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkNumber(View view) {
        EditText numberEditText = (EditText) findViewById(R.id.number);
        String toastText = "";

        if (numberEditText.getText().toString().isEmpty()) {
            toastText = "Please enter a number.";
        } else {
            Number num = new Number();
            num.number = Integer.parseInt(numberEditText.getText().toString());

            if (num.isSquare() && num.isTriangular()) {
                toastText = "That number is square and triangular!";
            } else if (num.isSquare()) {
                toastText = "That number is square!";
            } else if (num.isTriangular()) {
                toastText = "That number is triangular!";
            } else {
                toastText = "That number is shapeless.";
            }

        }

        Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
    }

    class Number {
        int number;

        public boolean isSquare() {
            double root = sqrt(number);
            return Math.pow((int) root, 2) == number;
        }

        public boolean isTriangular() {
            int x = 1;
            int temp = number;
            while (temp > 0) {
                temp -= x;
                x++;
                if (temp == 0) {
                    return true;
                }
            }
            return false;
        }
    }
}
