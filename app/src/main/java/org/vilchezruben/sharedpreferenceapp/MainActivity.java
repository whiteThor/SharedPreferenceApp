package org.vilchezruben.sharedpreferenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "org.vilchezRuben.sharedPreferenceapp.preferences";
    private static final String KEY_EDITTEX = "KEY_EDITTEX";
    private EditText mEditText;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = sharedPreferences.edit();

        mEditText.setText(sharedPreferences.getString(KEY_EDITTEX, ""));


    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mEditor.putString(KEY_EDITTEX, mEditText.getText().toString());
        mEditor.apply();
    }
}
