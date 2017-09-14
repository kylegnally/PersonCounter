package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    private TextView mPersonCountTextView;
    private int mPersonCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        mPersonCountTextView = (TextView) findViewById(R.id.personCountID);
        Button mMinusButton = (Button) findViewById(R.id.minusButtonID);
        Button mPlusButton = (Button) findViewById(R.id.plusButtonID);

        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPersonCount--;
                if (mPersonCount < 0)
                {
                    mPersonCount = 0;
                    Toast.makeText(CounterActivity.this, R.string.negative_toast, Toast.LENGTH_LONG).show();
                }
                mPersonCountTextView.setText(String.valueOf(mPersonCount));
            }
        });

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPersonCount++;
                mPersonCountTextView.setText(String.valueOf(mPersonCount));
                if (mPersonCount == 21) {
                    Toast.makeText(CounterActivity.this, R.string.toast_message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
