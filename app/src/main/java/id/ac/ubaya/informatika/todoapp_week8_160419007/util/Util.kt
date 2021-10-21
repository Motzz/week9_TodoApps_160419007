package id.ac.ubaya.informatika.todoapp_week8_160419007.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import id.ac.ubaya.informatika.todoapp_week8_160419007.model.TodoDatabase

val DB_NAME="tododb"

fun buildDB(context: Context): TodoDatabase {
    val db = Room.databaseBuilder(context,TodoDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()

    return db
}

val MIGRATION_1_2=object :Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 NOT NULL")
    }

}