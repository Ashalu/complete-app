package com.developer.aashish.rxpal;

/**
 * Created by Aashish on 7/12/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Belal on 18/09/16.
 */


public class menu1 extends Fragment  {

    @Nullable
    CardView c;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments


        return inflater.inflate(R.layout.menu1, container, false);


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(VerificationForm.a.equals("old"))
        {
c=(CardView)view.findViewById(R.id.card3);
            c.setVisibility(View.GONE);
        }
        else
        {
            c=(CardView)view.findViewById(R.id.card3);
            c.setVisibility(View.VISIBLE);
        }
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Menu 1");
    }
}