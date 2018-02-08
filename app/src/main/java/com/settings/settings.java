package com.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.draft.distress.distress.MainPage;
import com.draft.distress.distress.R;


public class settings extends AppCompatActivity {

    static final int PICK_CONTACT = 1;  // The request code
    static final int PICK_CONTACT2 = 2;
    static final int PICK_CONTACT3 = 3;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == PICK_CONTACT){
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);

                // Do something with the phone number...

                TextView firstContact = (TextView) findViewById(R.id.firstContact);
                firstContact.setText(number);
                if (number.isEmpty())
                    number="0";
                SharedPreferences settings = getSharedPreferences("AppStorage", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("MyKey", number);
                editor.apply();
                return;


        }



        if (requestCode == PICK_CONTACT2){
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToNext();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number2 = cursor.getString(column);

                // Do something with the phone number...

                TextView secondContact = (TextView) findViewById(R.id.secondContact);
                secondContact.setText(number2);
                if (number2.isEmpty())
                    number2="0";
                SharedPreferences settings2 = getSharedPreferences("AppStorage", 0);
                SharedPreferences.Editor editor2 = settings2.edit();
                editor2.putString("MyKey2", number2);
                editor2.apply();
                return;


        }


        if (requestCode == PICK_CONTACT3){
            // Make sure the request was successful

                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToLast();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number3 = cursor.getString(column);

                // Do something with the phone number...

                TextView thirdContact = (TextView) findViewById(R.id.thirdContact);
                thirdContact.setText(number3);
                if (number3.isEmpty())
                    number3="0";
                SharedPreferences settings3 = getSharedPreferences("AppStorage", 0);
                SharedPreferences.Editor editor3 = settings3.edit();
                editor3.putString("MyKey3", number3);
                editor3.apply();
                return;


        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        pickContact();
        addListenerButton4();






    }

    public void addListenerButton4()

    {

        Button onSync4ButtonClick = (Button) findViewById(R.id.Sync4);
        onSync4ButtonClick.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                EditText getEmergencyMessage = (EditText) findViewById(R.id.EmergencyMessage);
                String text4 = getEmergencyMessage.getText().toString();
                if (text4.isEmpty())
                    text4 = "0";
                SharedPreferences settings4 = getSharedPreferences("AppStorage", 0);
                SharedPreferences.Editor editor4 = settings4.edit();
                editor4.putString("MyKey4", text4);
                editor4.apply();
                Toast.makeText(settings.this, "Saved!", Toast.LENGTH_SHORT).show();

            }

        });
    }

    public void onMainPageButtonClick (View view)
    {
        Intent intent = new Intent(this, MainPage.class);

        startActivity(intent);
    }


    private void pickContact() {

        Button onSyncButtonClick = (Button) findViewById(R.id.Sync);
        onSyncButtonClick.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
                startActivityForResult(pickContactIntent, PICK_CONTACT);

            }

        });


        Button onSync2ButtonClick = (Button) findViewById(R.id.Sync2);
        onSync2ButtonClick.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent pickContactIntent2 = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                pickContactIntent2.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
                startActivityForResult(pickContactIntent2, PICK_CONTACT2);

            }

        });


        Button onSync3ButtonClick = (Button) findViewById(R.id.Sync3);
        onSync3ButtonClick.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent pickContactIntent3 = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                pickContactIntent3.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
                startActivityForResult(pickContactIntent3, PICK_CONTACT3);


            }

        });


    }


    }




