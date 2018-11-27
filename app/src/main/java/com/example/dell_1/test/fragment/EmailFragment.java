package com.example.dell_1.test.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dell_1.test.R;
import com.example.dell_1.test.adapter.Adapter;
import com.example.dell_1.test.baseactivity.BaseActivity;
import com.example.dell_1.test.model.ServiceProvider;
import com.example.dell_1.test.util.API;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailFragment extends Fragment {

    public static Fragment getInstance() {
        EmailFragment fragmnet = new EmailFragment();
        return fragmnet;
    }


    private Activity activity;


    private String id = "";
    private String company_id = "";
    private String first_name = "";
    private String last_name = "";
    private String description = "";
    private String date_of_birth = "";
    private String profile_pic = "";
    private String username = "";
    private String email = "";
    private String password = "";
    private String mobile = "";
    private String phone_no = "";
    private String address = "";
    private String latitude = "";
    private String longitude = "";
    private String user_role = "";
    private String is_active = "";
    private String created_at = "";
    private String updated_at = "";
    private String city = "";
    private String zip = "";
    private String distance = "";

    public List<ServiceProvider> serviceProviderList;

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        View view = inflater.inflate(R.layout.message_fragment, container, false);
        inItView(view);
        vollyRequest(activity);
        return view;
    }

    private void inItView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(mLayoutManager);
    }


    /*only for testing this code write here we create another class for it*/
    public void vollyRequest(final Activity activity) {

        RequestQueue queue = Volley.newRequestQueue(activity);
        StringRequest sr = new StringRequest(Request.Method.POST, API.TestApi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("volly", "response = " + response);
                parseTest(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("volly", "VolleyError = " + error);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(activity.getString(R.string.user_id), "2");
                params.put(activity.getString(R.string.user_late), "22.7196");
                params.put(activity.getString(R.string.user_log), "75.8577");
                params.put(activity.getString(R.string.distance), "20");
                params.put(activity.getString(R.string.date), "2018-09-20");
                params.put(activity.getString(R.string.time), "10:00:00");


                return params;
            }


        };
        queue.add(sr);
    }

    public void parseTest(String response) {
        JSONObject obj = null;
        JSONObject JSONObjectSP = null;
        JSONObject response_obj = null;
        JSONArray jsonArray = null;
        String msg = "";
        ServiceProvider serviceProvider;

        serviceProviderList = new ArrayList<>();

        try {
            obj = new JSONObject(response);
            Log.d("volly", "parseTest  = " + obj.toString());

            msg = obj.getString(getString(R.string.message));
            Log.d("volly", "parseTest  = " + obj.toString());

        } catch (Throwable t) {
            Log.e("volly", "msg  " + msg);
        }


        try {
            response_obj = obj.getJSONObject(getString(R.string.response));
            Log.e("volly", "response_obj  " + response_obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            jsonArray = response_obj.getJSONArray(getString(R.string.service_provider));
            Log.e("volly", "jsonArray  " + jsonArray);


            for (int i = 0; i <= jsonArray.length() - 1; i++) {

                JSONObjectSP = jsonArray.getJSONObject(i);
                serviceProvider = new ServiceProvider();

                if (JSONObjectSP.has(getString(R.string.id))) {
                    id = JSONObjectSP.getString(getString(R.string.id));
                    serviceProvider.setId(id);
                    Log.e("volly", "id  " + id);
                }

                if (JSONObjectSP.has(getString(R.string.company_id))) {
                    company_id = JSONObjectSP.getString(getString(R.string.company_id));
                    serviceProvider.setCompany_id(company_id);
                    Log.e("volly", "company_id  " + company_id);
                }

                if (JSONObjectSP.has(getString(R.string.first_name))) {
                    first_name = JSONObjectSP.getString(getString(R.string.first_name));
                    serviceProvider.setFirst_name(first_name);
                    Log.e("volly", "first_name  " + first_name);
                }

                if (JSONObjectSP.has(getString(R.string.last_name))) {
                    last_name = JSONObjectSP.getString(getString(R.string.last_name));
                    serviceProvider.setLast_name(last_name);
                    Log.e("volly", "last_name  " + last_name);
                }

                if (JSONObjectSP.has(getString(R.string.description))) {
                    description = JSONObjectSP.getString(getString(R.string.description));
                    serviceProvider.setDescription(description);
                    Log.e("volly", "description  " + description);
                }

                if (JSONObjectSP.has(getString(R.string.date_of_birth))) {
                    date_of_birth = JSONObjectSP.getString(getString(R.string.date_of_birth));
                    serviceProvider.setDate_of_birth(date_of_birth);
                    Log.e("volly", "date_of_birth  " + date_of_birth);
                }

                if (JSONObjectSP.has(getString(R.string.profile_pic))) {
                    profile_pic = JSONObjectSP.getString(getString(R.string.profile_pic));
                    serviceProvider.setProfile_pic(profile_pic);
                    Log.e("volly", "profile_pic  " + profile_pic);
                }

                if (JSONObjectSP.has(getString(R.string.username))) {
                    username = JSONObjectSP.getString(getString(R.string.username));
                    serviceProvider.setUsername(username);
                    Log.e("volly", "username  " + username);
                }

                if (JSONObjectSP.has(getString(R.string.email))) {
                    email = JSONObjectSP.getString(getString(R.string.email));
                    serviceProvider.setEmail(email);
                    Log.e("volly", "email  " + email);
                }

                if (JSONObjectSP.has(getString(R.string.password))) {
                    password = JSONObjectSP.getString(getString(R.string.password));
                    serviceProvider.setPassword(password);
                    Log.e("volly", "password  " + password);
                }

                if (JSONObjectSP.has(getString(R.string.mobile))) {
                    mobile = JSONObjectSP.getString(getString(R.string.mobile));
                    serviceProvider.setMobile(mobile);
                    Log.e("volly", "mobile  " + mobile);
                }

                if (JSONObjectSP.has(getString(R.string.phone_no))) {
                    phone_no = JSONObjectSP.getString(getString(R.string.phone_no));
                    serviceProvider.setPhone_no(phone_no);
                    Log.e("volly", "phone_no  " + phone_no);
                }

                if (JSONObjectSP.has(getString(R.string.address))) {
                    address = JSONObjectSP.getString(getString(R.string.address));
                    serviceProvider.setAddress(address);
                    Log.e("volly", "address  " + address);
                }

                if (JSONObjectSP.has(getString(R.string.latitude))) {
                    latitude = JSONObjectSP.getString(getString(R.string.latitude));
                    serviceProvider.setLatitude(latitude);
                    Log.e("volly", "latitude  " + latitude);
                }

                if (JSONObjectSP.has(getString(R.string.longitude))) {
                    longitude = JSONObjectSP.getString(getString(R.string.longitude));
                    serviceProvider.setLongitude(longitude);
                    Log.e("volly", "longitude  " + longitude);
                }


                if (JSONObjectSP.has(getString(R.string.user_role))) {
                    user_role = JSONObjectSP.getString(getString(R.string.user_role));
                    serviceProvider.setUser_role(user_role);
                    Log.e("volly", "user_role  " + user_role);
                }

                if (JSONObjectSP.has(getString(R.string.is_active))) {
                    is_active = JSONObjectSP.getString(getString(R.string.is_active));
                    serviceProvider.setIs_active(is_active);
                    Log.e("volly", "is_active  " + is_active);
                }

                if (JSONObjectSP.has(getString(R.string.created_at))) {
                    created_at = JSONObjectSP.getString(getString(R.string.created_at));
                    serviceProvider.setCreated_at(created_at);
                    Log.e("volly", "user_role  " + created_at);
                }

                if (JSONObjectSP.has(getString(R.string.updated_at))) {
                    updated_at = JSONObjectSP.getString(getString(R.string.updated_at));
                    Log.e("volly", "updated_at  " + updated_at);
                    serviceProvider.setUpdated_at(updated_at);
                }

                if (JSONObjectSP.has(getString(R.string.city))) {
                    city = JSONObjectSP.getString(getString(R.string.city));
                    Log.e("volly", "city  " + city);
                    serviceProvider.setCity(city);
                }

                if (JSONObjectSP.has(getString(R.string.zip))) {
                    zip = JSONObjectSP.getString(getString(R.string.zip));
                    Log.e("volly", "zip  " + zip);
                    serviceProvider.setZip(zip);
                }

                if (JSONObjectSP.has(getString(R.string.distance))) {
                    distance = JSONObjectSP.getString(getString(R.string.distance));
                    Log.e("volly", "distance  " + distance);
                    serviceProvider.setDistance(distance);
                }
                serviceProviderList.add(serviceProvider);

                if (serviceProviderList != null && serviceProviderList.size() > 0) {
                    setAdapter();
                } else {
                    Log.e("volly", "serviceProviderList list is null  ");
                }
            }

            Log.e("volly", "serviceProviderList size  " + serviceProviderList.size());


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void setAdapter() {
        adapter = new Adapter(serviceProviderList, activity);
        recyclerView.setAdapter(adapter);
    }

}






