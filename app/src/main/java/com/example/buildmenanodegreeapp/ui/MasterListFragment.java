package com.example.buildmenanodegreeapp.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.buildmenanodegreeapp.R;
import com.example.buildmenanodegreeapp.data.AndroidImageAssets;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {

    public MasterListFragment() {
    }

    OnImageClickListener  onImageClickListener;

    public interface OnImageClickListener
    {
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onImageClickListener = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnImageClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView)rootView.findViewById(R.id.images_grid_view);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                onImageClickListener.onImageSelected(position);
            }
        });

        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);



        return rootView;
    }

}
