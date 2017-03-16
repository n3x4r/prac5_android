package com.example.carlosergio.rotation;

import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static double CANTIDAD_PRESTAMO = 100000;
    private final static long PERIODO_PRESTAMO = 360; // In months
    private TableLayout mPagosTabla;
    private EditText mInterestRateField;
    private float mTableSize;
    private ArrayList<InfoPago> mRowData = new ArrayList<InfoPago>();
    private static final String DATA = "info";

    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPagosTabla = (TableLayout)findViewById(R.id.payment_table);
        mInterestRateField = (EditText)findViewById(R.id.interest_rate_field);
        Resources resources = getResources();
        mTableSize = resources.getDimension(R.dimen.table_body_size);
        if (savedInstanceState != null) {
            mRowData = (ArrayList<InfoPago>) savedInstanceState.getSerializable(DATA);
            for (int i = 0; i < mRowData.size(); i++) {
                addRow(mRowData.get(i));
            }
        }
    }

    // Attached to the Button via the android:onClick attribute

    public void anadeFilaComparacion(View clickedButton) {
        double interestRate = 5.0;
        try {
            interestRate = Double.parseDouble(mInterestRateField.getText().toString());
        } catch(Exception e) {} // NullPointerException or NumberFormatException
        InfoPago info = new InfoPago(CANTIDAD_PRESTAMO, interestRate, PERIODO_PRESTAMO);
        mRowData.add(info);
        addRow(info);
        mInterestRateField.setText("");
    }

    private void addRow(InfoPago info) {
        TableRow row = new TableRow(this);
        row.addView(makeColumn(info.getFormattedAnnualInterestRateInPercent()));
        row.addView(makeColumn(info.getFormattedMonthlyPayment()));
        row.addView(makeColumn(info.getFormattedTotalPayments()));
        mPagosTabla.addView(row);
    }

    private TextView makeColumn(String text) {
        TextView col = new TextView(this);
        col.setGravity(Gravity.RIGHT);
        col.setTextSize(mTableSize);
        col.setText(text);
        return(col);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable(DATA, mRowData);
    }
}

