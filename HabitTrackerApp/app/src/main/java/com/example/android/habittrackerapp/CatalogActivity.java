package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.android.habittrackerapp.data.HabitDbHelper;

public class CatalogActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        mDbHelper = new HabitDbHelper(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {

        Cursor cursor = mDbHelper.readAllHabits();

        TextView displayView = (TextView)findViewById(R.id.text_view_pet);

        try {
            displayView.setText("The habits table contains " + cursor.getCount() + " habits.\n\n");
            displayView.append(HabitEntry._ID + " - " +
                    HabitEntry.COLUMN_HABIT_NAME + " - " +
                    HabitEntry.COLUMN_HABIT_LOCATION + " - " +
                    HabitEntry.COLUMN_HABIT_TYPE + "\n");

            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int locationColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_LOCATION);
            int typeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TYPE);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentLocation = cursor.getString(locationColumnIndex);
                int currentType = cursor.getInt(typeColumnIndex);
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentLocation + " - " +
                        currentType));
            }

        } finally {
            cursor.close();
        }
    }

    private void insertHabit() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Mike");
        values.put(HabitEntry.COLUMN_HABIT_LOCATION, "Japan");
        values.put(HabitEntry.COLUMN_HABIT_TYPE, HabitEntry.TYPE_OTHER);

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insert_dummy_data:
                insertHabit();
                displayDatabaseInfo();
                return true;
            case R.id.action_delete_all_entries:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
