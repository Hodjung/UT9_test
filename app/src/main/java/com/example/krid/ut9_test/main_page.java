package com.example.krid.ut9_test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by KridsadaTh on 17/3/2558.
 */
public class main_page extends FragmentActivity{
    public main_page(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.main_page);
        super.onCreate(savedInstanceState);
        final TextView m1 = (TextView)findViewById(R.id.map);
        final TextView m2 = (TextView)findViewById(R.id.route);
        final TextView m3 = (TextView)findViewById(R.id.profile);
        m1.setBackgroundResource(R.color.material_blue_grey_800);
        change_menu(0);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.setBackgroundResource(R.color.material_blue_grey_800);
                m2.setBackgroundResource(0);
                m3.setBackgroundResource(0);
                change_menu(0);
                EditText editSearch = (EditText)findViewById(R.id.editSearch);
                editSearch.setVisibility(View.INVISIBLE);
                editSearch.setText("");
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.setBackgroundResource(0);
                m2.setBackgroundResource(R.color.material_blue_grey_800);
                m3.setBackgroundResource(0);
                change_menu(1);
                EditText editSearch = (EditText)findViewById(R.id.editSearch);
                editSearch.setVisibility(View.INVISIBLE);
                editSearch.setText("");
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.setBackgroundResource(0);
                m2.setBackgroundResource(0);
                m3.setBackgroundResource(R.color.material_blue_grey_800);
                change_menu(2);
                EditText editSearch = (EditText)findViewById(R.id.editSearch);
                editSearch.setVisibility(View.INVISIBLE);
                editSearch.setText("");
            }
        });
            /*final PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
            final ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);*/
        ImageButton search = (ImageButton)findViewById(R.id.btnSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editSearch = (EditText)findViewById(R.id.editSearch);
                if (editSearch.getVisibility()==View.INVISIBLE){
                    editSearch.setVisibility(View.VISIBLE);
                }
                else {
                    editSearch.setVisibility(View.INVISIBLE);
                    editSearch.setText("");
                    //search
                }
            }
        });
    }
    public void change_menu(int menu){
        if (menu==0){
            //Map
            while(0<getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, new page_map()).commit());
        }
        else if (menu==1){
            //Route
            while(0<getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, new page_route()).commit());
        }
        else {
            //Profile
            while(0<getSupportFragmentManager().beginTransaction().replace(R.id.containerMain, new page_profile()).commit());
        }
    }
    static public class page_map extends Fragment {
        public page_map() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.map, container, false);
            TextView center = (TextView) rootView.findViewById(R.id.center);
            return rootView;
        }
    }
    static public class page_route extends Fragment {
        public page_route(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.route,container,false);
            return rootView;
        }
    }
    static public class page_profile extends Fragment {
        public page_profile(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.profile,container,false);
            return rootView;
        }
    }
}
