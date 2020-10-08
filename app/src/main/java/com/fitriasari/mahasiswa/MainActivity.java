package com.fitriasari.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    Button btnbuatdata,btnbacadata;
    EditText etnama;
    TextView tvhasildata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        btnbacadata = findViewById(R.id.btnbacadata);
        btnbuatdata = findViewById(R.id.btnbuatdata);
        etnama = findViewById(R.id.etnama);
        tvhasildata = findViewById(R.id.tvhasildata);
    }

    public void insertdata(View view) {
        String nama = etnama.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_NAME, nama);
        long id = db.insert(DatabaseHelper.TABLE_STUDENTS,null,values);

        Log.d("DATABASE", "Id data: " + id);
    }

    public void readData(View view) {
        ArrayList<String> data = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String Query = "SELECT * FROM " + DatabaseHelper.TABLE_STUDENTS;

        Cursor c = db.rawQuery(Query,null);
        while (c.moveToNext()){
            data.add(c.getString(c.getColumnIndex(DatabaseHelper.KEY_NAME)));
        }
        c.close();

        String hasil = "";
        for (int i = 0; i< data.size(); i++){
            hasil += data.get(i);
        }
        tvhasildata.setText(hasil);
    }

}