package com.example.krid.ut9_test;

import android.database.DataSetObserver;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ListAdapter;

public class MainActivity extends FragmentActivity {
    private static final int TUTORIAL_PAGE=9;
    private static final int MAIN_PAGE=1;
    private static final int MENU_MAP=0;
    private static final int MENU_ROUTE=1;
    private static final int MENU_PROFILE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container,new first_page()).commit();
        }
    }
    public void change_page(int page){
        if (page==9){
            //Page Tutorial
            while(0<getSupportFragmentManager().beginTransaction().replace(R.id.container, new tutorial_page()).commit());
        }
        else if (page==1){
            //Page Main
            while(0<getSupportFragmentManager().beginTransaction().replace(R.id.container, new main_page()).commit());
        }
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
    public class first_page extends Fragment {
        public first_page() {}
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.first_page, container, false);
            CheckBox box = (CheckBox)rootView.findViewById(R.id.checkBox);
            box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    EditText confirm = (EditText)rootView.findViewById(R.id.confirm);
                    if (isChecked)
                        confirm.setVisibility(View.VISIBLE);
                    else confirm.setVisibility(View.INVISIBLE);
                }
            });
            ImageButton btn = (ImageButton)rootView.findViewById(R.id.next);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    change_page(TUTORIAL_PAGE);
                }
            });
            return rootView;
        }
    }
    public class tutorial_page extends Fragment {
        public tutorial_page(){}
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.second_page, container, false);
            final PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
            final ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);
            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i2) {
                    if (i==2){
                        TextView txt = (TextView)rootView.findViewById(R.id.finish);
                        txt.setVisibility(View.VISIBLE);
                        ImageButton btn = (ImageButton)rootView.findViewById(R.id.next);
                        btn.setVisibility(View.INVISIBLE);
                        TextView txt2 = (TextView)rootView.findViewById(R.id.skip);
                        txt2.setVisibility(View.INVISIBLE);
                        txt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                change_page(MAIN_PAGE);
                            }
                        });
                    }
                }

                @Override
                public void onPageSelected(int i) {

                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
            ImageButton next = (ImageButton)rootView.findViewById(R.id.next);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pager.setCurrentItem(pager.getCurrentItem() + 1);
                }
            });
            TextView skip = (TextView)rootView.findViewById(R.id.skip);
            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    change_page(1);
                }
            });
            return rootView;
        }
    }
    public class main_page extends Fragment {
        public main_page(){}
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.main_page, container, false);
            final TextView m1 = (TextView)rootView.findViewById(R.id.map);
            final TextView m2 = (TextView)rootView.findViewById(R.id.route);
            final TextView m3 = (TextView)rootView.findViewById(R.id.profile);
            Display display = getWindowManager().getDefaultDisplay();
            Point size=new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;
            if (width%3!=0){
                m1.setMinWidth(width/3);
                m2.setMinWidth((width/3)+(width%3));
                m3.setMinWidth(width/3);
            }
            else {
                m1.setMinWidth(width/3);
                m2.setMinWidth(width/3);
                m3.setMinWidth(width/3);
            }
            m1.setBackgroundResource(R.color.material_blue_grey_800);
            change_menu(0);
            m1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    m1.setBackgroundResource(R.color.material_blue_grey_800);
                    m2.setBackgroundResource(0);
                    m3.setBackgroundResource(0);
                    change_menu(MENU_MAP);
                    EditText editSearch = (EditText)rootView.findViewById(R.id.editSearch);
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
                    change_menu(MENU_ROUTE);
                    EditText editSearch = (EditText)rootView.findViewById(R.id.editSearch);
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
                    change_menu(MENU_PROFILE);
                    EditText editSearch = (EditText)rootView.findViewById(R.id.editSearch);
                    editSearch.setVisibility(View.INVISIBLE);
                    editSearch.setText("");
                }
            });
            /*final PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
            final ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);*/
            ImageButton search = (ImageButton)rootView.findViewById(R.id.btnSearch);
            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editSearch = (EditText)rootView.findViewById(R.id.editSearch);
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
            return rootView;
        }
    }
    public class page_map extends Fragment {
        public page_map() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.map, container, false);
            TextView center = (TextView) rootView.findViewById(R.id.center);
            return rootView;
        }
    }
    public class page_route extends Fragment {
        public page_route(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.route,container,false);
            return rootView;
        }
    }
    public class page_profile extends Fragment {
        public page_profile(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.profile,container,false);
            return rootView;
        }
    }
}
