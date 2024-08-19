package ir.rezvandeveloper.daneshjooyarv.dp.dao

import android.content.ContentValues
import android.database.Cursor
import android.util.Log
import ir.rezvandeveloper.daneshjooyar.dp.model.Pishraft
import ir.rezvandeveloper.daneshjooyar.dp.DBHelper
import java.lang.Exception

class PishraftDao(
    private val db: DBHelper
) {

    private val data = ArrayList<Pishraft>()
    private lateinit var cursor: Cursor
    private val contentValues = ContentValues()

    fun save(darsadePishraft: Pishraft): Boolean {

        val database = db.writableDatabase
        setContentValue(darsadePishraft)
        val result = database.insert(DBHelper.VIDEO_SAVE_TABLE, null, contentValues)
        database.close()
        return result > 0

    }

    fun edit(id: String, darsadePishraft: Pishraft): Boolean {

        val database = db.writableDatabase
        setContentValue(darsadePishraft)
        val result = database.update(
            DBHelper.VIDEO_SAVE_TABLE,
            contentValues,
            "${DBHelper.ID} = ?",
            arrayOf(id)
        )
        database.close()
        return result > 0

    }

    private fun setContentValue(darsadePishraft: Pishraft) {
        contentValues.clear()
        contentValues.put(DBHelper.NAME, darsadePishraft.name)
        contentValues.put(DBHelper.DARSADE_PISHRAFT, darsadePishraft.darsad_pishraft)
    }

    fun findAll(): List<Pishraft> {

        val database = db.readableDatabase
        val query = "SELECT * FROM ${DBHelper.VIDEO_SAVE_TABLE}"
        cursor = database.rawQuery(query, null)
        setData()
        cursor.close()
        database.close()
        return data

    }

    fun findByColumn(columnName: String, columnValue: String): List<Pishraft> {

        val database = db.readableDatabase
        val query = "SELECT * FROM ${DBHelper.VIDEO_SAVE_TABLE} WHERE $columnName = ?"
        cursor = database.rawQuery(query, arrayOf(columnValue))
        setData()
        cursor.close()
        database.close()
        return data

    }

    private fun setData() {

        data.clear()

        try {

            if (cursor.moveToFirst()) {

                do {
                    val id = cursor.getInt(getIndex(DBHelper.ID))
                    val name = cursor.getString(getIndex(DBHelper.NAME))
                    val darsadPishraft = cursor.getInt(getIndex(DBHelper.DARSADE_PISHRAFT))
                    data.add(Pishraft(id,name,darsadPishraft))
                } while (cursor.moveToNext())

            }

        } catch (e: Exception) {
            Log.e("NOT_FOUND_INDEX", e.message.toString())
        }

    }

    private fun getIndex(name: String) = cursor.getColumnIndex(name)

    fun delete(id: String): Boolean {

        val database = db.writableDatabase
        val result = database.delete(
            DBHelper.VIDEO_SAVE_TABLE,
            "${DBHelper.ID} = ?",
            arrayOf(id)
        )
        database.close()
        return result > 0

    }

}