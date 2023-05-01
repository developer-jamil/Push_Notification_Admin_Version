package com.jamillabltd.pushnotificationadminversion;

import static com.jamillabltd.pushnotificationadminversion.Constants.TOPIC;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jamillabltd.pushnotificationadminversion.model.ApiUtilities;
import com.jamillabltd.pushnotificationadminversion.model.NotificationData;
import com.jamillabltd.pushnotificationadminversion.model.PushNotification;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextMessage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // //firebase message subscribe - push notification
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        //send notification button
        Button buttonSendNotification = findViewById(R.id.buttonSendNotificationId);
        buttonSendNotification.setOnClickListener(view -> {
            editTextTitle = findViewById(R.id.editTextTitleId);
            editTextMessage = findViewById(R.id.editTextMessageId);

            String title = editTextTitle.getText().toString();
            String message = editTextMessage.getText().toString();

            if (title.isEmpty()) {
                editTextTitle.setError("Enter Title");
                editTextTitle.requestFocus();
            } else if (message.isEmpty()) {
                editTextMessage.setError("Enter Message");
                editTextMessage.requestFocus();
            } else {
                // Send the notification
                sendNotificationMethod(title, message);
            }
        });

    }


    private void sendNotificationMethod(String title, String message) {

        PushNotification notification = new PushNotification(new NotificationData(title, message), TOPIC);

        ApiUtilities.getClient().sendNotification(notification).enqueue(new Callback<PushNotification>() {
            @Override
            public void onResponse(Call<PushNotification> call, Response<PushNotification> response) {

                //if response Successful
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    editTextTitle.setText("");
                    editTextMessage.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<PushNotification> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}