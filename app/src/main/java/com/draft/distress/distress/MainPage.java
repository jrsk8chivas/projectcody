package com.draft.distress.distress;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.settings.settings;

public class MainPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, new LocationListener() {
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
            }

            @Override
            public void onProviderEnabled(String s) {
            }

            @Override
            public void onProviderDisabled(String s) {
            }

            @Override
            public void onLocationChanged(final Location location) {
            }
        });
        Location myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        final double longitude = myLocation.getLongitude();
        final double latitude = myLocation.getLatitude();



        TextView textView1 = (TextView) findViewById(R.id.textView1);
        final SharedPreferences settings = getSharedPreferences("AppStorage", 0);
        final String str = settings.getString("MyKey", null);
       textView1.setText(str);




        TextView textView2 = (TextView) findViewById(R.id.textView2);
        final SharedPreferences settings2 = getSharedPreferences("AppStorage", 0);
        final String str2 = settings2.getString("MyKey2", null);
        textView2.setText(str2);

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        final SharedPreferences settings3 = getSharedPreferences("AppStorage", 0);
        final String str3 = settings3.getString("MyKey3", null);
        textView3.setText(str3);

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        final SharedPreferences settings4 = getSharedPreferences("AppStorage", 0);
        final String str4 = settings4.getString("MyKey4", null);
        textView4.setText(str4);

        TextView textView5 = (TextView) findViewById(R.id.textView5);
      final String str5 = " https://maps.google.com/maps/?q=@"+latitude+","+longitude;
        textView5.setText(str5);

        final String str6 = str4+str5;





        Button Send_Message = (Button) findViewById(R.id.send_Message);
        Send_Message.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                sendSMS(str, str2, str3, str6);
                Toast.makeText(MainPage.this, "Alert is sent.", Toast.LENGTH_SHORT).show();






            }


        });



    }

    private void sendSMS(String str, String str2, String str3,  String str6) {

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(str, null, str6, null, null);
        sms.sendTextMessage(str2, null, str6, null, null);
        sms.sendTextMessage(str3, null, str6, null, null);

    }

    public void onSettingsButtonClick (View view)
    {
        Intent intent = new Intent(this, settings.class);

        startActivity(intent);
    }


}


