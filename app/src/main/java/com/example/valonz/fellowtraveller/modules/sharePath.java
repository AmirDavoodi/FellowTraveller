package com.example.valonz.fellowtraveller.modules;

import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.valonz.fellowtraveller.modules.SQLiteHandler;

public class sharePath {
    private String originLat;
    private String originLng;
    private String destinationLat;
    private String destinationLng;
    private SQLiteHandler db;

    public sharePath( String originAddress, LatLng originLocation, String destinationAddress, LatLng destinationLocation) {
        HashMap<String, String> user = db.getUserDetails();
        String unique_user_id = user.get("uid");


    }

}
