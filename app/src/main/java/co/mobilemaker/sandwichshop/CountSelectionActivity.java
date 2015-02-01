package co.mobilemaker.sandwichshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by diany_000 on 1/27/2015.
 */
public class CountSelectionActivity extends ActionBarActivity {

    private final static String LOG_TAG = CountSelectionActivity.class.getSimpleName();
    final static String NUM_SANDW = "NUM_SANDW";
    EditText mNumSandwichesEditText;
    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countselection);
        Log.d(LOG_TAG, "Count selection activity created.");
        prepareStartButton();
        prepareNumberParameter();
    }

    private void prepareNumberParameter() {
        mNumSandwichesEditText = (EditText)findViewById(R.id.editText_numSandwiches);
        mNumSandwichesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(mNumSandwichesEditText.getText()) ||
                        Integer.parseInt(mNumSandwichesEditText.getText().toString()) > 5)
                    Toast.makeText(getApplicationContext(), "Invalid number: up to 5",
                            Toast.LENGTH_SHORT).show();
                else
                    mStartButton.setEnabled(true);

            }
        });
    }

    private void prepareStartButton() {
        mStartButton = (Button)findViewById(R.id.button_start);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numSand = Integer.parseInt(mNumSandwichesEditText.getText().toString());
                Intent intent = new Intent(CountSelectionActivity.this, OrderFormActivity.class);
                intent.putExtra(NUM_SANDW ,numSand);
                startActivity(intent);
            }
        });
    }


}
