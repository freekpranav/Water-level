package com.hoperaiser.dam_monitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private static final String HI = "\n" +
            "https://script.googleusercontent.com/macros/echo?user_content_key=huYnlYl50G69TBaVDUP25TDwUmVB2CvkWbleNTE_ph2_w6x8Jich7-SpBR0gkRbfGZ4-YviunOaoUpHP6TYwzBca_H_gHjZKm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnDP2YtNm8C7_Ho7YwyZ18E4v5TmIunLwNvTZjhMd3sgkuCCc37pIxJfPXYlP7srrAA&lib=MnO3TbhSRvKfsUQS8RutMAEp06igyh02c";
    private RecyclerView rv;
    private List<UserModal> list_data;
    private MyAdapter adapter;
String date,level,time,temp,hum;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));


        if (list_data == null)
            list_data = new ArrayList<>();
        adapter = new MyAdapter(list_data, this);
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
//
        getData();
    }


    // Fetch Data

    private void getData() {
        pDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    pDialog.show();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("user");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);

                        date = ob.getString("date");
                        time = ob.getString("time");
                        level = ob.getString("waterlevel");
                        temp = ob.getString("temperature");
                        hum = ob.getString("humidity");



                                    UserModal ld = new UserModal(date, time,level,temp,hum);


                                    list_data.add(ld);


                                }

                    rv.setAdapter(adapter);

                    adapter.notifyDataSetChanged();

                    pDialog.dismiss();
                    if (pDialog.isShowing())
                        pDialog.dismiss();


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
