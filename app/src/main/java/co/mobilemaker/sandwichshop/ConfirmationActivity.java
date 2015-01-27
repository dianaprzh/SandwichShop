package co.mobilemaker.sandwichshop;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by diany_000 on 1/26/2015.
 */
public class ConfirmationActivity extends ActionBarActivity {

    private final static String LOG_TAG = ConfirmationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Log.d(LOG_TAG, "Confirmation activity created.");
        ArrayList<String> results = getIntent().getStringArrayListExtra(Intent.EXTRA_TEXT);
        TextView textView = (TextView)findViewById(R.id.textView_summary_order);
        StringBuilder summary = new StringBuilder();
        summary.append("Your sandwich is with " + results.get(results.size()-1) + " bread and the following toppings: ");
        for (int i = 0; i < results.size() - 1 ; i++){
            if(i == results.size() - 2)
                summary.append(results.get(i) + ".");
            else
                summary.append(results.get(i) + ", ");
        }
        textView.setText(summary);
    }

}
