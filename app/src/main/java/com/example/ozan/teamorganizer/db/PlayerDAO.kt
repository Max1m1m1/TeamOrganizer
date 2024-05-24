package com.example.ozan.teamorganizer.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ozan.teamorganizer.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDAO {

    // The conflict strategy defines what happens,if there is an existing entry.
    // The default action is ABORT.
    //@Insert(onConflict = OnConflictStrategy.IGNORE) //if there is a conflict it will be ignored, if there is a new player with the same data it will jut ignored
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(player: Player) // suspend is written because it will be used with coroutine

    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)

    @Query("DELETE FROM ${Constants.TABLENAME}")
    fun deleteAllPlayers()

    /*
    LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware,
    meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    This awareness ensures LiveData only updates app component observers that are in an active lifecycle state
    */
    @Query("SELECT * FROM ${Constants.TABLENAME} ORDER BY id ASC")
    fun getAllPlayers(): LiveData<List<Player>>

    @Query("SELECT * FROM ${Constants.TABLENAME} WHERE id =:id")
    fun getPlayerById(id:Int):Player

    @Query("SELECT * FROM ${Constants.TABLENAME} WHERE name LIKE :searchKey OR number LIKE :searchKey")
    fun getPlayersBySearchKey(searchKey:String): Flow<List<Player>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    fun insertAllPlayers(player: ArrayList<Player>){
        player.forEach{
            insertPlayer(it)
        }
    }

}