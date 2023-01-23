package com.example.currencyconvertercop2805;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnKeyListener {

    private EditText Num1;
    private LinearLayout first, second;
    private TextView fixedText1, fixedText2, fixedText3, Convert;
    private Spinner spinner;
    private String[] convertType = {"Select Your Choice", "USD to YUAN", "YUAN to USD", "USD to CAD", "CAD to USD", "USD to EUR", "EUR to USD"};


    int pos = 0;
    String yuan, usd, cad, eur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUiObject();
        setSpinner();
    }

    //setting ui part of the view
    private void getUiObject() {
        fixedText1 = findViewById(R.id.Conversion);
        fixedText2 = findViewById(R.id.From);
        fixedText3 = findViewById(R.id.To);
        Convert = findViewById(R.id.Convert);
        Num1 = findViewById(R.id.Num1);
        spinner = findViewById(R.id.spinner);
        first = findViewById(R.id.First);
        second = findViewById(R.id.Result);

        Num1.setOnKeyListener(this);
    }

    private void setSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, convertType);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private double USDToYUAN(double usd) {
        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format(usd * 6.74));
    }

    private double YUANToUSD(double yuan) {

        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format(yuan / 6.74));
    }

    private double USDToCAD(double usd) {
        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format(usd * 1.26));
    }

    private double CADToUSD(double cad) {
        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format(cad / 1.26));
    }

    private double USDToEUR(double usd) {
        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format(usd * 0.85));
    }

    private double EURToUSD(double eur) {
        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format(eur / 0.85));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 1) {

            pos = 1;
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.VISIBLE);
            fixedText2.setText("US Dollar");
            fixedText3.setText("Chinese YUAN");
            Num1.setText("");
            Convert.setText("");

        } else if (position == 2) {
            pos = 2;
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.VISIBLE);
            fixedText2.setText("Chinese Yuan");
            fixedText3.setText("US Dollar");
            Num1.setText("");
            Convert.setText("");

        } else if (position == 3) {
            pos = 3;
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.VISIBLE);
            fixedText2.setText("US Dollar");
            fixedText3.setText("Canadian Dollar");
            Num1.setText("");
            Convert.setText("");

        } else if (position == 4) {
            pos = 4;
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.VISIBLE);
            fixedText2.setText("Canadian Dollar");
            fixedText3.setText("US Dollar");
            Num1.setText("");
            Convert.setText("");
        } else if (position == 5) {
            pos = 5;
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.VISIBLE);
            fixedText2.setText("US Dollar");
            fixedText3.setText("European Euro");
            Num1.setText("");
            Convert.setText("");

        } else if (position == 6) {
            pos = 6;
            first.setVisibility(View.VISIBLE);
            second.setVisibility(View.VISIBLE);
            fixedText2.setText("European Euro");
            fixedText3.setText("US Dollar");
            Num1.setText("");
            Convert.setText("");
        } else {
            first.setVisibility(View.GONE);
            second.setVisibility(View.GONE);
            Toast.makeText(this, "Select Value", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

            if (pos == 1) {

                if (!Num1.getText().toString().equalsIgnoreCase("")) {
                    double usd = Double.parseDouble(Num1.getText().toString());
                    yuan = String.valueOf(USDToYUAN(usd));
                }

                Convert.setText(yuan);
                return true;
            } else if (pos == 2) {

                if (!Num1.getText().toString().equalsIgnoreCase("")) {
                    double yuan = Double.parseDouble(Num1.getText().toString());
                    usd = String.valueOf(YUANToUSD(yuan));
                }

                Convert.setText(usd);
                return true;
            } else if (pos == 3) {

                if (!Num1.getText().toString().equalsIgnoreCase("")) {
                    double usd = Double.parseDouble(Num1.getText().toString());
                    cad = String.valueOf(USDToCAD(usd));
                }
                Convert.setText(cad);
                return true;
            } else if (pos == 4) {

                if (!Num1.getText().toString().equalsIgnoreCase("")) {
                    double cad = Double.parseDouble(Num1.getText().toString());
                    usd = String.valueOf(CADToUSD(cad));
                }
                Convert.setText(usd);
                return true;
            } else if (pos == 5) {

                if (!Num1.getText().toString().equalsIgnoreCase("")) {
                    double usd = Double.parseDouble(Num1.getText().toString());
                    eur = String.valueOf(USDToEUR(usd));
                }
                Convert.setText(eur);
                return true;
            } else if (pos == 6) {

                if (!Num1.getText().toString().equalsIgnoreCase("")) {
                    double eur = Double.parseDouble(Num1.getText().toString());
                    usd = String.valueOf(EURToUSD(eur));
                }
                Convert.setText(usd);
                return true;
            }

        }
        return false;
    }
}
