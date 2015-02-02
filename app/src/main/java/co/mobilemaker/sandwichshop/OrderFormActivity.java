package co.mobilemaker.sandwichshop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by diany_000 on 1/26/2015.
 */
public class OrderFormActivity extends ActionBarActivity {

    private final static String LOG_TAG = OrderFormActivity.class.getSimpleName();
    final static String SANDWICH_LIST = "SANDWICH_LIST";

    private Button mContinueButton;
    private Button mPlaceOrderButton;
    private RadioGroup mRadioGroupBreads;
    private RadioButton mRadioButtonWheat;
    private RadioButton mRadioButtonWhite;
    private RadioButton mRadioButtonRye;
    private CheckBox mCheckBoxMayo;
    private CheckBox mCheckBoxKetchup;
    private CheckBox mCheckBoxBbq;
    private CheckBox mCheckBoxBacon;
    private CheckBox mCheckBoxExtraCheese;
    private CheckBox mCheckBoxGarlicSauce;
    private CheckBox mCheckBoxOlives;
    private CheckBox mCheckBoxPepper;
    private String bread;
    private ArrayList<String> results = new ArrayList<>();
    private int numSandw;
    ArrayList<Sandwich> sandwiches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderform);
        Log.d(LOG_TAG, "Order form activity created.");
        numSandw = getIntent().getIntExtra(CountSelectionActivity.NUM_SANDW, 1);
        if(savedInstanceState != null){
            sandwiches = savedInstanceState.getParcelableArrayList(SANDWICH_LIST);
        }else {
            sandwiches = new ArrayList<Sandwich>();
        }
        prepareButtons();
    }

    private void prepareSandwichOptions() {
        prepareBreadOptions();
        prepareToppingsOptions();
    }


    private void prepareToppingsOptions() {
        mCheckBoxMayo = (CheckBox)findViewById(R.id.checkBox_mayo);
        mCheckBoxKetchup = (CheckBox)findViewById(R.id.checkBox_ketchup);
        mCheckBoxBbq = (CheckBox)findViewById(R.id.checkBox_bbq);
        mCheckBoxBacon = (CheckBox)findViewById(R.id.checkBox_bacon);
        mCheckBoxExtraCheese = (CheckBox)findViewById(R.id.checkBox_extraCheese);
        mCheckBoxGarlicSauce = (CheckBox)findViewById(R.id.checkBox_garlic_sauce);
        mCheckBoxOlives = (CheckBox)findViewById(R.id.checkBox_olives);
        mCheckBoxPepper = (CheckBox)findViewById(R.id.checkBox_pepper);
        if(mCheckBoxMayo.isChecked())
            results.add("Mayonnaise");
        if(mCheckBoxKetchup.isChecked())
            results.add("Ketchup");
        if(mCheckBoxBbq.isChecked())
            results.add("Bbq");
        if(mCheckBoxBacon.isChecked())
            results.add("Bacon");
        if(mCheckBoxExtraCheese.isChecked())
            results.add("Extra cheese");
        if(mCheckBoxGarlicSauce.isChecked())
            results.add("Garlic sauce");
        if(mCheckBoxOlives.isChecked())
            results.add("Olives");
        if(mCheckBoxPepper.isChecked())
            results.add("Pepper");
    }

    private void prepareBreadOptions() {
        mRadioGroupBreads = (RadioGroup)findViewById(R.id.radioGroup_breads);
        mRadioButtonWheat = (RadioButton)findViewById(R.id.radioButton_wheat);
        mRadioButtonWhite = (RadioButton)findViewById(R.id.radioButton_white);
        mRadioButtonRye = (RadioButton)findViewById(R.id.radioButton_rye);
        if(mRadioGroupBreads.getCheckedRadioButtonId() != -1) {
            if (mRadioButtonWheat.isChecked())
                bread = "Wheat";
            else if (mRadioButtonWhite.isChecked())
                bread = "White";
            else
                bread = "Rye";
        }
    }

    private void prepareButtons() {
        mPlaceOrderButton = (Button)findViewById(R.id.button_placeOrder);
        mContinueButton = (Button)findViewById(R.id.button_continue);
        if(numSandw == 1){
            mPlaceOrderButton.setEnabled(true);
            mContinueButton.setEnabled(false);
            mPlaceOrderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareSandwichOptions();
                    Bundle bundle = setParcelableBundle();
                    Intent intent = new Intent(OrderFormActivity.this, ConfirmationActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }else{
            mContinueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareSandwichOptions();
                    Bundle bundle = setParcelableBundle();
                    Intent intent = new Intent(v.getContext(), OrderFormActivity.class);
                    intent.putExtras(bundle);
                    intent.putExtra(CountSelectionActivity.NUM_SANDW, numSandw--);
                    startActivity(intent);
                }
            });
        }
    }

    private Bundle setParcelableBundle() {
        Bundle bundle = new Bundle();
        Sandwich sandwich = new Sandwich();
        sandwich.setResults(results);
        sandwiches.add(sandwich);
        bundle.putParcelableArrayList(SANDWICH_LIST, sandwiches);
        return bundle;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(SANDWICH_LIST, sandwiches);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
