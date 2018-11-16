package com.example.administrator.mobileshophehaolin.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import com.example.administrator.mobileshophehaolin.R;

public class PersonFragment extends BaseFragment {
    private static final String TAG = "PersonFragment";
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup contanier, Bundle savedInstanceState){
        Log.d(TAG, "1234");
        View view = inflater.inflate(R.layout.fragment_person,contanier,false);
        return view;
    }
}
