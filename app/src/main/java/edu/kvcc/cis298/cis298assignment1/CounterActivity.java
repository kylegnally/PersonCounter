// CIS298 Assignment 1 - Person Counter
// Kyle Nally
// Description - This application creates a person counter in a single activity.
// Reducing the number to less than zero, and also toasts the user if the number
// of people exceeds twenty. It does NOT toast the user if the number is then
// reduced to less than twenty, and does NOT toast the user for all number above twenty.

package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    // working variables
    private TextView mPersonCountTextView;
    private int mPersonCount = 0;

    // inflate the layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // cast variable and buttons to their associated views
        mPersonCountTextView = (TextView) findViewById(R.id.personCountID);
        Button mMinusButton = (Button) findViewById(R.id.minusButtonID);
        Button mPlusButton = (Button) findViewById(R.id.plusButtonID);

        // Minus button event listener
        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPersonCount--;

                // Negative person toast. Resets person counter to 0 if it goes below 0 and then
                // toasts the user per strings.xml
                if (mPersonCount < 0)
                {
                    mPersonCount = 0;
                    Toast.makeText(CounterActivity.this, R.string.negative_toast, Toast.LENGTH_LONG).show();
                }

                // update the person count TextView
                mPersonCountTextView.setText(String.valueOf(mPersonCount));
            }
        });

        // plus button event listener
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPersonCount++;
                mPersonCountTextView.setText(String.valueOf(mPersonCount));

                // Person count toast. Toast the user if the count equals 21. Exists only in this listener
                // so we don't toast the user if they are decrementing the value
                if (mPersonCount == 21) {
                    Toast.makeText(CounterActivity.this, R.string.toast_message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
