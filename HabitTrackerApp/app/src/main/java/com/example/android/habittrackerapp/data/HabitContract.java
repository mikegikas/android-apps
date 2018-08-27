/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract() {
        //An empty private constructor makes sure that the class is not going to be initialised.
    }

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String COLUMN_HABIT_NAME = "name";

        public final static String COLUMN_HABIT_TYPE = "type";

        public final static String COLUMN_HABIT_LOCATION = "location";

        public static final int TYPE_FOOTBALL = 0;
        public static final int TYPE_BASKETBALL = 1;
        public static final int TYPE_BASEBALL = 2;
        public static final int TYPE_TENNIS = 3;
        public static final int TYPE_RUNNING = 4;
        public static final int TYPE_PAINTING = 5;
        public static final int TYPE_SINGING = 6;
        public static final int TYPE_TRAVELING = 7;
        public static final int TYPE_SHOPPING = 8;
        public static final int TYPE_OTHER = 9;
    }
}


