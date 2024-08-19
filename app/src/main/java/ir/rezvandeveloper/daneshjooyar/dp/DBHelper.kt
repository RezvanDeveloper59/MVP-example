package ir.rezvandeveloper.daneshjooyar.dp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ir.rezvandeveloper.daneshjooyar.MadarekFragment

class DBHelper(
    context: Context
) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {

        private const val DB_NAME = "almentor.db"
        private const val DB_VERSION = 1

        const val VIDEO_SAVE_TABLE = "Video_Save"
        const val ID = "id"
        const val NAME = "name"
        const val DARSADE_PISHRAFT = "pishraft"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS $VIDEO_SAVE_TABLE (" +
                    "$ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$NAME VARCHAR(100)," +
                    "$DARSADE_PISHRAFT INTEGER)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}