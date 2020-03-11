package com.example.buildmenanodegreeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.buildmenanodegreeapp.ui.AndroidMeActivity;
import com.example.buildmenanodegreeapp.ui.MasterListFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    // Creating free variables to hold the data that will be put in the Bundle
    private int headIndex;
    private int bodyIndex;
    private int legIndex;


    //    Overriding the onCreat method and setting the activity_main layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //    Overriding the onImageSelected method from the OnImageClickListener interface
    @Override
    public void onImageSelected(int position) {

//        Making a toast appear every time an item is clicked with its position inside the array
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();



//        Getting the index of the chosen image inside the allArray
//        and then transforming it to values
//        that can be used to navigate through body part arrays (head, body, legs)
        int bodyPartNumber = position/12;
        int listIndex = position - 12*bodyPartNumber;

        switch(bodyPartNumber){
            case 0: headIndex = listIndex;
                break;
            case 1: bodyIndex = listIndex;
                break;
            case 2: legIndex = listIndex;
                break;
            default: break;
        }
//      Creating a Bundle and putting variables inside
        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);
//      Creating an Intent and adding the 'b' Bundle to it
        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);

        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }});}



}
