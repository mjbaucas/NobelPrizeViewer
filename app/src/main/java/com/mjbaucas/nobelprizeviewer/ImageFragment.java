package com.mjbaucas.nobelprizeviewer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageFragment extends Fragment {
    TextView textView;
    ImageView imageView;
    View fragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_image, container, false);
        textView = fragmentView.findViewById(R.id.image_textview);
        imageView = fragmentView.findViewById(R.id.image_imageview);
        return fragmentView;
    }

    public void imageSelector(String category){
        switch(category) {
            case "physics":
                textView.setText("Gérard Albert Mourou");
                imageView.setBackgroundResource(R.drawable.gerard_morou);
                break;
            case "medicine":
                textView.setText("Tasuku Honjo");
                imageView.setBackgroundResource(R.drawable.tasuku_honjo);
                break;
            case "peace":
                textView.setText("Nadia Murad Basee Taha");
                imageView.setBackgroundResource(R.drawable.nadia_murad);
                break;
            case "chemistry":
                textView.setText("Gregory Paul Winter");
                imageView.setBackgroundResource(R.drawable.gregory_winter);
                break;
            default:
                textView.setText("Petros Spachos");
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedState){
        super.onActivityCreated(savedState);
        if (getActivity() instanceof DetailActivity){
            String selCategory = getActivity().getIntent().getExtras().getString("SELECTED_CATEGORY");
            imageSelector(selCategory);
        }
    }
}
