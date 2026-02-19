package com.example.comxyzbmiapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BMIDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "BMIDatabase", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE bmi_records (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                age INTEGER,
                gender TEXT,
                weight REAL,
                height REAL,
                bmi REAL,
                status TEXT
            )
        """.trimIndent()

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS bmi_records")
        onCreate(db)
    }

    // INSERT FUNCTION
    fun insertBMIRecord(
        name: String,
        age: Int,
        gender: String,
        weight: Double,
        height: Double,
        bmi: Double,
        status: String
    ): Boolean {

        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("age", age)
            put("gender", gender)
            put("weight", weight)
            put("height", height)
            put("bmi", bmi)
            put("status", status)
        }

        val result = db.insert("bmi_records", null, values)
        return result != -1L
    }

    // READ FUNCTION (Optional – for history screen)
    fun getAllRecords(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM bmi_records ORDER BY id DESC", null)
    }
}
