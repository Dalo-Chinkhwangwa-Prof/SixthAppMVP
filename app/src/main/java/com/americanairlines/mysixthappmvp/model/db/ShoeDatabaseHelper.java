package com.americanairlines.mysixthappmvp.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.americanairlines.mysixthappmvp.R;
import com.americanairlines.mysixthappmvp.model.Shoe;

import java.util.ArrayList;
import java.util.List;

public class ShoeDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shoe_db";
    public static int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "shoe_table";
    public static final String COLUMN_SHOE_MODEL = "shoe_model";
    public static final String COLUMN_SHOE_ID = "shoe_id";
    public static final String COLUMN_SHOE_SIZE = "shoe_size";
    public static final String COLUMN_SHOE_PRICE = "shoe_price";

    private Resources resources;

    public ShoeDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        resources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_SHOE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SHOE_MODEL + " TEXT, "
                + COLUMN_SHOE_PRICE + " TEXT, "
                + COLUMN_SHOE_SIZE + " INTEGER)";

        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String update = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(update);
        onCreate(sqLiteDatabase);
        DATABASE_VERSION = i1;
    }

    public List<Shoe> getAllShoesFromDatabase(){

        Cursor shoeCursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE_NAME, null, null);

        List<Shoe> shoes = new ArrayList<>();

        shoeCursor.move(-1);

        while(shoeCursor.moveToNext()){

            String shoeModel = shoeCursor.getString(shoeCursor.getColumnIndex(COLUMN_SHOE_MODEL));
            String shoePrice = shoeCursor.getString(shoeCursor.getColumnIndex(COLUMN_SHOE_PRICE));
            int shoeSize = shoeCursor.getInt(shoeCursor.getColumnIndex(COLUMN_SHOE_SIZE));
            int shoeId = shoeCursor.getInt(shoeCursor.getColumnIndex(COLUMN_SHOE_ID));

            Shoe shoe = new Shoe(shoeSize, shoeModel, Double.parseDouble(shoePrice), shoeId);
            shoes.add(shoe);
        }

        return shoes;
    }

    public void insertNewShoeIntoDatabase(Shoe shoe) {
        String s = "INSER....";
        ContentValues shoeValue = new ContentValues();

        shoeValue.put(COLUMN_SHOE_MODEL, shoe.getShoeModel());
        shoeValue.put(COLUMN_SHOE_PRICE, shoe.getShoePrice()+"");
        shoeValue.put(COLUMN_SHOE_SIZE, shoe.getShoeSize());

        getWritableDatabase().insert(TABLE_NAME, null, shoeValue);
    }

    public void deleteShoeFromDatabase(Shoe shoe) {
//        String deleteSql = "DELETE FROM "+TABLE_NAME + " "+COLUMN_SHOE_ID + " = " + shoe.getShoeID();
        // <string name="delete_command">DELETE FROM %s WHERE %s = %d</string>
        String deleteSql = resources.getString(R.string.delete_command, TABLE_NAME, COLUMN_SHOE_ID, shoe.getShoeID());
        getWritableDatabase().execSQL(deleteSql);
    }



}






































