package com.example.krid.ut9_test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KridsadaTh on 17/3/2558.
 */
public class first_page extends Activity {
    private ProgressDialog pDialog;
    JSONParser jParser = new JSONParser();
    public first_page() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.first_page);
        CheckBox box = (CheckBox)findViewById(R.id.checkBox);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText confirm = (EditText)findViewById(R.id.confirm);
                if (isChecked)
                    confirm.setVisibility(View.VISIBLE);
                else confirm.setVisibility(View.INVISIBLE);
            }
        });
        ImageButton btn = (ImageButton)findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new checkUser().execute();
            }
        });
        super.onCreate(savedInstanceState);
    }
    class checkUser extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(first_page.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", ));
            params.add(new BasicNameValuePair("password", )));
            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jParser.makeHttpRequest("localhost/check_user", "POST", params);

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
        }
    }
}
