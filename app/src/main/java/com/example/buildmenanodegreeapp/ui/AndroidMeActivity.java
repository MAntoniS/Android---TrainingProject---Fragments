package com.example.buildmenanodegreeapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.buildmenanodegreeapp.R;
import com.example.buildmenanodegreeapp.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);


//        Check if there is a previously saved state.
//        If not, create new fragments
        if(savedInstanceState == null) {

//          Creating the FragmentManager
            FragmentManager fragmentManager = getSupportFragmentManager();
           // FragmentManager fragmentManager = getSupportFragmentManager();

            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());

//             Getting data from the Bundle added to the Intent
            int headIndex = getIntent().getIntExtra("headIndex", 0);
//            Setting the displayed image
            headFragment.setListIndex(headIndex);


//          Adding the headFragment to the corresponding container set in the activity_android_me.xml layout
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

//          Doing the same for the body && the leg fragment
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setListIndex(bodyIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setListIndex(legIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}
