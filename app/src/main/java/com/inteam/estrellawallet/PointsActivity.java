package com.inteam.estrellawallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.inteam.estrellawallet.domain.managers.UserManager;

import java.util.List;


public class PointsActivity extends Activity {

    private static final int SPEECH_REQUEST_CODE = 0;

    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_2);
        //TODO : preguntar si ja estic registrat
    }

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    private boolean isNumber(String word) {
        boolean isNumber = false;
        try {
            Integer.parseInt(word);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }
        return isNumber;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);

            if (isNumber(spokenText)) {
                TextView Pamount = (TextView) findViewById(R.id.P_amount);
                Pamount.setText(spokenText);

                Button next = (Button) findViewById(R.id.B_OK_config2);
                next.setText("Next");
                next.setEnabled(true);

                points = Integer.parseInt(spokenText);
            } else {
                TextView Pamount = (TextView) findViewById(R.id.P_amount);
                if (Pamount.getText().equals("0")) {
                    Button next = (Button) findViewById(R.id.B_OK_config2);
                    next.setText("Try again!");
                }
            }

            ScrollView view = (ScrollView) findViewById(R.id.scrollView);
            view.scrollTo(0, 200);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void onClickSetPoints(View v) {
        displaySpeechRecognizer();
    }

    public void onClickNextView(View v) {
        UserManager manager = new UserManager(getApplicationContext());
        manager.setUserPoints(points);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
