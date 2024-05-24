package com.example.ozan.teamorganizer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ozan.teamorganizer.util.Constants

/*
If you change anything on the database like adding a field to table, changing type of a filed,
deleting a filed, changing the name of the field
exportSchema: to have a version of history of your schema in your code base,
it is not required so assigned as false
 */
@Database(
    entities = [Player::class],
    version = 2,
    exportSchema = false
)
abstract class PlayerRoomDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDAO

    companion object{
        @Volatile  //it makes that instance to visible to other threads
        private var INSTANCE:PlayerRoomDatabase?=null

        fun getDatabase(context: Context):PlayerRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance !=null){
                return  tempInstance
            }
            synchronized(this){
                val  instance = Room.databaseBuilder(context.applicationContext,
                    PlayerRoomDatabase::class.java, Constants.DATABASENAME).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}