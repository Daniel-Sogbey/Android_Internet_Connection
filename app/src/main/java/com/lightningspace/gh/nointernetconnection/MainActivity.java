package com.lightningspace.gh.nointernetconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.InetAddresses;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
//
//        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        boolean isConnected = isConnectedToInternet();
        Log.d("TAG", "onCreate: " + isConnected);

        if(isConnected){
            Snackbar.make(findViewById(R.id.textView), "Connected", Snackbar.LENGTH_SHORT).show();
        }else{
            Snackbar.make(findViewById(R.id.textView), "No Internet Connection", Snackbar.LENGTH_SHORT).show();

        }




        // Snackbar.make(findViewById(R.id.textView), "Application Running", Snackbar.LENGTH_SHORT).show();

    }

    public boolean isConnectedToInternet () {
       try {
           InetAddress inetAddresses = InetAddress.getByName("www.google.com");
           return inetAddresses.equals("");
       }catch (UnknownHostException){
           return false;
       }

    }
}
