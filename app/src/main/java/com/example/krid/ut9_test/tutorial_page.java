package com.example.krid.ut9_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by KridsadaTh on 17/3/2558.
 */
public class tutorial_page extends FragmentActivity {
    public tutorial_page(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.second_page);
        super.onCreate(savedInstanceState);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        final ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                if (i==2){
                    TextView txt = (TextView)findViewById(R.id.finish);
                    txt.setVisibility(View.VISIBLE);
                    ImageButton btn = (ImageButton)findViewById(R.id.next);
                    btn.setVisibility(View.INVISIBLE);
                    TextView txt2 = (TextView)findViewById(R.id.skip);
                    txt2.setVisibility(View.INVISIBLE);
                    txt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(tutorial_page.this,main_page.class);
                            startActivity(intent);
                            //change_page(MAIN_PAGE);
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
        ImageButton next = (ImageButton)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem() + 1);
            }
        });
        TextView skip = (TextView)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(2);
            }
        });
    }
}
