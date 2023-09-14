package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn[] = new Button[9];
    TextView p1, p2;
    TextView turn;
    TextView display;
    Button reset;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int count = 0, id;
    int p1count = 1, p2count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        turn = findViewById(R.id.turn);
        reset = findViewById(R.id.reset);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        reset.setOnClickListener(this);

        for (int i = 0; i < btn.length; i++) {

            id = getResources().getIdentifier("btn" + i, "id", getPackageName());
            btn[i] = findViewById(id);
            btn[i].setOnClickListener(this);


        }

    }


    @Override
    public void onClick(View v) {


        for (int i = 0; i < btn.length; i++) {
            if (v.getId() == btn[i].getId()) {
                if (count % 2 == 0) {
                    btn[i].setText("x");

                    btn[i].setEnabled(false);
                    count++;
                    turn.setText("Turn=O");
                    win();


                } else if (count % 2 == 1) {
                    btn[i].setText("O");

                    btn[i].setEnabled(false);
                    count++;
                    turn.setText("Turn=x");
                    win();


                }

            }


            if (v.getId() == reset.getId()) {
                reset();
            }

        }

    }

    public void win() {

        b1 = btn[0].getText().toString();
        b2 = btn[1].getText().toString();
        b3 = btn[2].getText().toString();
        b4 = btn[3].getText().toString();
        b5 = btn[4].getText().toString();
        b6 = btn[5].getText().toString();
        b7 = btn[6].getText().toString();
        b8 = btn[7].getText().toString();
        b9 = btn[8].getText().toString();

        if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {

            if (b1.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);
            } else {
                p2.setText("0 is winner"+p2count++);
            }
            diseble();
        } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
            if (b4.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);

            } else {
                p2.setText("o is winner"+p2count++);
            }
            diseble();
        } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
            if (b7.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);
            } else {
                p2.setText("0 is winner"+p2count++);
            }
            diseble();
        } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
            if (b1.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);
            } else {
                p2.setText("0 is winner"+p2count++);
            }

            diseble();
        } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
            if (b2.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);

            } else {
                p2.setText("0 is winner"+p2count++);

            }
            diseble();
        } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
            if (b3.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);
            } else {
                p2.setText("0 is winner"+p2count++);
            }
            diseble();
        } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
            if (b1.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);
            } else {
                p2.setText("0 is winner"+p2count++);
            }
            diseble();
        } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
            if (b3.equalsIgnoreCase("x")) {
                p1.setText("x is winner"+p1count++);
            } else {
                p2.setText("0 is winner"+p2count++);
            }
            diseble();
        }
        if (count == 9) {
            Toast.makeText(MainActivity.this, "Draw Game!", Toast.LENGTH_LONG).show();

        }


    }

    private void diseble() {
        for (int i = 0; i < btn.length; i++) {
            btn[i].setEnabled(false);
        }
    }

    public void reset() {

        for (int i = 0; i < btn.length; i++) {
            btn[i].setText("");
            reset.setVisibility(View.VISIBLE);
            count = 0;
            btn[i].setEnabled(true);
           // p1.clearComposingText();
            //p2.clearComposingText();


        }
    }


}