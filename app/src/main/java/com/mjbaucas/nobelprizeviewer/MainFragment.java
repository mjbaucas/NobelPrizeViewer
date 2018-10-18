package com.mjbaucas.nobelprizeviewer;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.style.DrawableMarginSpan;
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
        Drawable physicsIconMd =this.getResources(). getDrawable( R.drawable.physics_icon_md);
        Drawable physicsIconSm =this.getResources(). getDrawable( R.drawable.physics_icon_sm);

        physBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("physics");
            }
        });
        setButtonIcon(physBtn, physicsIconMd, physicsIconSm);

        medBtn = fragmentView.findViewById(R.id.medicine_button);
        Drawable medicineIconMd =this.getResources(). getDrawable( R.drawable.medicine_icon_md);
        Drawable medicineIconSm =this.getResources(). getDrawable( R.drawable.medicine_icon_sm);

        medBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("medicine");
            }
        });
        setButtonIcon(medBtn, medicineIconMd, medicineIconSm);

        pceBtn = fragmentView.findViewById(R.id.peace_button);
        Drawable peaceIconMd =this.getResources(). getDrawable( R.drawable.peace_icon_md);
        Drawable peaceIconSm =this.getResources(). getDrawable( R.drawable.peace_icon_sm);

        pceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("peace");
            }
        });
        setButtonIcon(pceBtn, peaceIconMd, peaceIconSm);

        chemBtn = fragmentView.findViewById(R.id.chemistry_button);
        Drawable chemistryIconMd =this.getResources(). getDrawable( R.drawable.chemistry_icon_md);
        Drawable chemistryIconSm =this.getResources(). getDrawable( R.drawable.chemistry_icon_sm);

        chemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails("chemistry");
            }
        });
        setButtonIcon(chemBtn, chemistryIconMd, chemistryIconSm);

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

    public void setButtonIcon(Button btn, Drawable iconMd, Drawable iconSm){
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            btn.setCompoundDrawablesWithIntrinsicBounds(null, null, iconMd, null);
        } else {
            btn.setCompoundDrawablesWithIntrinsicBounds(null, null, iconSm, null);
        }
    }
}
