package ir.rahmani.githubproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.rahmani.githubproject.model.User

@Database(entities = [User::class], version = 1)
abstract class DataBase:RoomDatabase() {
    abstract fun userDao():Dao
}