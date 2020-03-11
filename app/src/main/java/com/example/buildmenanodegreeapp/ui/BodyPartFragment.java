package com.example.buildmenanodegreeapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.buildmenanodegreeapp.R;

import java.util.ArrayList;
import java.util.List;


public class BodyPartFragment extends Fragment {

    //  Creating an empty public Constructor of the class
    public BodyPartFragment(){
    }

    //    Setting the 'SET' methods for private variables imageIds && listIndex
//    in order to allow other classes setting their value
    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }
    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    //  Declaring needed variables
    private List<Integer> imageIds;
    private int listIndex;
    private static final String TAG = "BodyPartFragment";
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


    //    Overriding the onCrewateView method that is called every time this fragment is created
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

//       Checking if there already is an instacne of this fragment
//       If yes, setting the values of the imageIds && listIndex to their value from that instance
        if (savedInstanceState != null)
        {
            imageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            listIndex = savedInstanceState.getInt(LIST_INDEX);
        }

//        Inflating the Android - Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

//        Getting a reference to the ImageView inside the fragment layout
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_fragment);


//        Setting onClickListener on every created BodyPartFragment
//        and setting new image every time it is clicked on
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listIndex < imageIds.size() - 1)
                {
                    listIndex ++;
                }else
                {
                    listIndex = 0;
                }
                imageView.setImageResource(imageIds.get(listIndex));
            }
        });

//        Checking if imageIds is not null
        if(imageIds != null) {
//        Setting the  image  as displayImage
            imageView.setImageResource(imageIds.get(listIndex));
        }else
        {
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        // Returning the rootView
        return rootView;
    }

    //    Saving the current state of the fragment
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>)imageIds );
        currentState.putInt(LIST_INDEX, listIndex);
    }
}
