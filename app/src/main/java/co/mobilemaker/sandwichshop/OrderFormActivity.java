package co.mobilemaker.sandwichshop;

import android.content.Intent;
import android.os.Bundle;
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
    Button mPlaceOrderButton;
    RadioGroup mRadioGroupBreads;
    RadioButton mRadioButtonWheat;
    RadioButton mRadioButtonWhite;
    RadioButton mRadioButtonRye;
    CheckBox mCheckBoxMayo;
    CheckBox mCheckBoxKetchup;
    CheckBox mCheckBoxBbq;
    CheckBox mCheckBoxBacon;
    CheckBox mCheckBoxExtraCheese;
    CheckBox mCheckBoxGarlicSauce;
    CheckBox mCheckBoxOlives;
    CheckBox mCheckBoxPepper;
    String bread;
    ArrayList<String> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderform);
        Log.d(LOG_TAG, "Order form activity created.");
        preparePlaceOrderButton();
    }

    private void prepareSandwichOptions() {
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
    private void preparePlaceOrderButton() {
        mPlaceOrderButton = (Button)findViewById(R.id.button_placeOrder);
        mPlaceOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderFormActivity.this, ConfirmationActivity.class);
                prepareSandwichOptions();
                results.add(bread);
                intent.putExtra(Intent.EXTRA_TEXT,results);
                startActivity(intent);
            }
        });
    }


}
