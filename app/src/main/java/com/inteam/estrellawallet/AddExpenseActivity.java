package com.inteam.estrellawallet;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inteam.estrellawallet.domain.entities.User;
import com.inteam.estrellawallet.domain.listeners.OnSwipeTouchListener;
import com.inteam.estrellawallet.domain.managers.UserManager;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class AddExpenseActivity extends SlidingActivity {

    private final AddExpenseActivity self = this;
    private static final int SPEECH_EXPENSE_REQUEST_CODE = 0;
    private static final int SPEECH_DESCRIPTION_REQUEST_CODE = 1;

    private TextView mTextView;
    private UserManager um;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        exitPoint = ExitPoint.BOTTOM;

        um = new UserManager(this.getApplicationContext());

        setContentView(R.layout.activity_add_expense);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_expense);
        layout.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            @Override
            public void onSwipeBottom() {
                self.finish();
            }
        });
    }

    private void displaySpeechRecognizer(int code) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, code);
    }

    private boolean isNumber(String word) {
        boolean isNumber = false;
        try {
            NumberFormat.getNumberInstance(java.util.Locale.US).parse(word);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        } catch (ParseException e) {
            isNumber = false;
        }
        return isNumber;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPEECH_DESCRIPTION_REQUEST_CODE && resultCode == RESULT_OK){
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            description = results.get(0);
        }
        else if (requestCode == SPEECH_EXPENSE_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);

            if (isNumber(spokenText)) {
                TextView expense = (TextView) findViewById(R.id.expense);
                expense.setText(spokenText);

                Button next = (Button) findViewById(R.id.add_expense);

                try {
                    next.setText(" Next +" + (NumberFormat.getNumberInstance(java.util.Locale.US).parse(spokenText).intValue()/6) + " points ");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                next.setEnabled(true);

            } else {
                TextView expense = (TextView) findViewById(R.id.expense);
                if (!isNumber((String) expense.getText())) {
                    Button next = (Button) findViewById(R.id.add_expense);
                    next.setText("Try again!");
                }
            }

        } else if (requestCode == SPEECH_DESCRIPTION_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);

            TextView description = (TextView) findViewById(R.id.description);
            description.setText(spokenText);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onExpenseClick(View v) {
        displaySpeechRecognizer(SPEECH_EXPENSE_REQUEST_CODE);
    }

    public void onDescriptionClick(View v) {
        displaySpeechRecognizer(SPEECH_DESCRIPTION_REQUEST_CODE);
    }

    public void onClickNext(View v) {
        UserManager manager = new UserManager(getApplicationContext());

        TextView expense = (TextView) findViewById(R.id.expense);
        int spent = Integer.parseInt((String) expense.getText());
        manager.addExpense(spent, description);
        this.finish();
    }
}
