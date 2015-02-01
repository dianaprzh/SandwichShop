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
        Bundle bundle = getIntent().getExtras();
        ArrayList<Sandwich> options = bundle.getParcelableArrayList(OrderFormActivity.SANDWICH_LIST);
        TextView textView = (TextView)findViewById(R.id.textView_summary_order);
        StringBuilder summary = new StringBuilder();
        for (Sandwich sandwich : options){
            ArrayList<String> results = sandwich.getResults();
            summary.append("Sandwich bread: " + results.get(results.size()-1) + "\n");
            summary.append("Sandwich toppings: \n");
            for (int i = 0; i < results.size() - 1 ; i++){
                if(i == results.size() - 2)
                    summary.append(results.get(i) + ".");
                else
                    summary.append(results.get(i) + ", ");
            }
            summary.append("\n\n\n");
        }
        textView.setText(summary);
    }

}
