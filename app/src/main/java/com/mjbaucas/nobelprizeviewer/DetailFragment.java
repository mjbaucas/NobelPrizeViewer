package com.mjbaucas.nobelprizeviewer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        return fragmentView;
    }

    public void detailSelector(String category){
        textView.setText(category);
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
