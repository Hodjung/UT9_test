package com.example.krid.ut9_test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.test.TouchUtils.drag;

/**
 * Created by Krid on 13/2/2558.
 */
public class Tab_map extends android.app.Fragment {
    public Tab_map(){}
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.map, container, false);
        return rootView;
    }

    private void drag(MotionEvent event, View v) {
        RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) v.getLayoutParams();
        switch(event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
            {
                params.topMargin = (int)event.getRawY() - (v.getHeight());
                params.leftMargin = (int)event.getRawX() - (v.getWidth()/2);
                v.setLayoutParams(params);
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                params.topMargin = (int)event.getRawY() - (v.getHeight());
                params.leftMargin = (int)event.getRawX() - (v.getWidth()/2);
                v.setLayoutParams(params);
                break;
            }
            case MotionEvent.ACTION_DOWN:
            {
                v.setLayoutParams(params);
                break;
            }
        }
    }
}
