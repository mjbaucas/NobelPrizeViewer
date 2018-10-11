package com.mjbaucas.nobelprizeviewer;


import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {
    Button physBtn;
    Button medBtn;
    Button pceBtn;
    Button chemBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);

        physBtn = fragmentView.findViewById(R.id.physics_button);
        physBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("physics");
            }
        });

        medBtn = fragmentView.findViewById(R.id.medicine_button);
        medBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("medicine");
            }
        });

        pceBtn = fragmentView.findViewById(R.id.peace_button);
        pceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("peace");
            }
        });

        chemBtn = fragmentView.findViewById(R.id.chemistry_button);
        chemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("chemistry");
            }
        });

        return fragmentView;
    }

    public void openDetails(String category){
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
            detailIntent.putExtra("SELECTED_CATEGORY", category);
            startActivity(detailIntent);
        } else {
            ImageFragment imgFrag = (ImageFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.image_fragment);
            DetailFragment detFrag = (DetailFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
            imgFrag.imageSelector(category);
            detFrag.detailSelector(category);
        }
    }
}
