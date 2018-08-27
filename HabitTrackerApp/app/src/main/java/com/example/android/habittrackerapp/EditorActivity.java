/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.habittrackerapp.data.HabitContract.HabitEntry;
import com.example.android.habittrackerapp.data.HabitDbHelper;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;

    private EditText mLocatiobEditText;

    private Spinner mTypeSpinner;

    private int mTypeHabit = HabitEntry.TYPE_OTHER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        mNameEditText = (EditText) findViewById(R.id.edit_pet_name);
        mLocatiobEditText = (EditText) findViewById(R.id.edit_pet_breed);
        mTypeSpinner = (Spinner) findViewById(R.id.spinner_gender);

        setupSpinner();
    }

    private void setupSpinner() {

        ArrayAdapter typeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_type, android.R.layout.simple_spinner_item);

        typeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mTypeSpinner.setAdapter(typeSpinnerAdapter);

        mTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.habit_football))) {
                        mTypeHabit = HabitEntry.TYPE_FOOTBALL;
                    } else if (selection.equals(getString(R.string.habit_basketball))) {
                        mTypeHabit = HabitEntry.TYPE_BASKETBALL;
                    } else if (selection.equals(getString(R.string.habit_baseball))) {
                        mTypeHabit = HabitEntry.TYPE_BASEBALL;
                    }else if (selection.equals(getString(R.string.habit_tennis))){
                        mTypeHabit =HabitEntry.TYPE_TENNIS;
                    }else if (selection.equals(getString(R.string.habit_running))){
                        mTypeHabit = HabitEntry.TYPE_RUNNING;
                    }else if (selection.equals(getString(R.string.habit_Painting))){
                        mTypeHabit = HabitEntry.TYPE_PAINTING;
                    }else if (selection.equals(getString(R.string.habit_singing))){
                        mTypeHabit = HabitEntry.TYPE_SINGING;
                    }else if (selection.equals(getString(R.string.habit_traveling))){
                        mTypeHabit = HabitEntry.TYPE_TRAVELING;
                    }else if (selection.equals(getString(R.string.habit_shopping))){
                        mTypeHabit = HabitEntry.TYPE_SHOPPING;
                    }else{
                        mTypeHabit = HabitEntry.TYPE_OTHER;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mTypeHabit = HabitEntry.TYPE_OTHER;
            }
        });
    }

    private void insertHabit(){

        String nameString = mNameEditText.getText().toString().trim();
        String locationString = mLocatiobEditText.getText().toString().trim();

        HabitDbHelper mDbHelper = new HabitDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, nameString);
        values.put(HabitEntry.COLUMN_HABIT_TYPE, mTypeHabit);
        values.put(HabitEntry.COLUMN_HABIT_LOCATION, locationString);

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        if (newRowId == -1){
            Toast.makeText(this, "Error with saving your Habit", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertHabit();
                finish();
                return true;
            case R.id.action_delete:
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}