// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v

package com.example.sensorsassignment3;

public class SensorContract {

    private SensorContract() {
    }

    public static class SensorEntry {
        public static final String DB_NAME = "sensors_db";
        public static final String TABLE_NAME = "sensor_info";
        public static final String SENSOR_ID = "sensor_id";
        public static final String SENSOR_NAME = "sensor_name";
        public static final String SENSOR_VALUE = "sensor_value";
    }
}
