package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * The activity (screen) for editing to-do items. It receives data from MainActivity and
 * returns result of the editing back.
 */
public class EditItemActivity extends AppCompatActivity {

    EditText etItem;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItem = findViewById(R.id.etItemText);
        btnUpdate = findViewById(R.id.btnUpdate);

        etItem.setText(getIntent().getStringExtra(MainActivity.ITEM_TEXT));
        int position = getIntent().getIntExtra(MainActivity.ITEM_POSITION, 0);
        // read the data passed from MainActivity by accessing it by Keys from MainActivity
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        position = getIntent().getIntExtra(MainActivity.KEY_ITEM_POSITION, 0);

        getSupportActionBar().setTitle("Edit item");

        // when user is done editing they click "update" button
        final int finalPosition = position;
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent() that will be container for results
                Intent intent = new Intent();
                intent.putExtra(MainActivity.ITEM_POSITION, finalPosition);
                intent.putExtra((MainActivity.ITEM_TEXT), etItem.getText().toString());

                // pass results of editing:
                // notice we are using same Keys from MainActivity, but new, updated Values
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, finalPosition);
                intent.putExtra((MainActivity.KEY_ITEM_TEXT), etItem.getText().toString());

                // set result and pass data back
                setResult(RESULT_OK, intent);

                // finish activity = close this screen and go back
                finish();
            }
        });
    }
}