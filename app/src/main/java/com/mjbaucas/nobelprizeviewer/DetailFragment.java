package com.mjbaucas.nobelprizeviewer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    TextView textView;
    View fragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = fragmentView.findViewById(R.id.detail_textview);
        textView.setMovementMethod(new ScrollingMovementMethod());
        return fragmentView;
    }

    public void detailSelector(String category){
        switch(category) {
            case "physics":
                textView.setText(getResources().getString(R.string.physics_detail));
                break;
            case "medicine":
                textView.setText(getResources().getString(R.string.medicine_detail));
                break;
            case "peace":
                textView.setText(getResources().getString(R.string.peace_detail));
                break;
            case "chemistry":
                textView.setText(getResources().getString(R.string.chemistry_detail));
                break;
            default:
                textView.setText("Petros Spachos");
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedState){
        super.onActivityCreated(savedState);
        if (getActivity() instanceof DetailActivity) {
            String selCategory = getActivity().getIntent().getExtras().getString("SELECTED_CATEGORY");
            detailSelector(selCategory);
        }
    }
}
