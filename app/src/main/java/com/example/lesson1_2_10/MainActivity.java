package com.example.lesson1_2_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);


    }
    public  void  setOnDialogFragment(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(fragmentManager,"error");
    }
    public void seOnRating(View view){
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        RatingBar ratingBar =new RatingBar(this);
        alertdialog.setTitle("Рейтинг");
        alertdialog.setMessage("Оценка");
        alertdialog.setView(ratingBar);

        ratingBar.setMax(7);
        ratingBar.setNumStars(7);
        ratingBar.setStepSize(1.0f);

        alertdialog.setPositiveButton("отлично", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText(""+ratingBar.getRating());

            }
        });
        alertdialog.setNegativeButton("выход", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alertdialog.create();
        alertdialog.show();
    }
}