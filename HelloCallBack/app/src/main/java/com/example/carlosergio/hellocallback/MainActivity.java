package com.example.carlosergio.hellocallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textv;
    private static final String DATA  = "states";
    private static final String TAG ="Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textv = (TextView) findViewById(R.id.textview);
        if (savedInstanceState!=null){
            String texto = savedInstanceState.getString(DATA);
            textv.setText(texto);
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        textv.append("Onstart()\n");
        Log.i(TAG, "onStart()");

    }
    @Override
    public void onRestart(){
        super.onRestart();
        textv.append("onRestart()\n");
        Log.i(TAG, "onRestart()");

    }
    @Override
    public void onPause(){
        super.onPause();
        textv.append("onPause()\n");
        Log.i(TAG, "onPause()");

    }
    @Override
    public void onResume(){
        super.onResume();
        textv.append("OnResume()\n");
        Log.i(TAG, "onResume()");

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        textv.append("onDestroy()\n");
        Log.i(TAG, "onDestroy()");

    }@Override
    public void onStop(){
        super.onStop();
        textv.append("onStop()\n");
        Log.i(TAG, "onStop()");

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        textv.append("onSaveInstanceState()\n");
        //textv.append("onStop()\n");
        //textv.append("onDestroy()\n");
        savedInstanceState.putString(DATA, textv.getText().toString());
        //textv.setText("");
        Log.i(TAG, "onSaveInstanceState()");
    }
    /*@Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        textv.append("onRestoreInstanceState()\n");
        //String texto = savedInstanceState.getString(DATA);
        //textv.append(texto);
        Log.i(TAG, "onRestoreInstanceState()");
    }*/

}
