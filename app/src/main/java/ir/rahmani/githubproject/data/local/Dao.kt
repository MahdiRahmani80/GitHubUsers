package ir.rahmani.githubproject.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.rahmani.githubproject.model.User

@androidx.room.Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllFav():List<User>

    @Query("SELECT EXISTS(SELECT * FROM user WHERE id=:id)")
    fun isInFavUserExist(id: Int):Boolean

    @Delete
    fun delFavUser(user: User)

}