package com.example.ozan.teamorganizer.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ozan.teamorganizer.util.Constants

@Entity(tableName = Constants.TABLENAME)
data class Player(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name:String,
    val position:String,
    val number:Int,
    val height:Double,
    val weight:Int
)
{
    override fun toString(): String {
        return " Player:" +
                "Name:" + name + '\'' +
                "Position:" + position + '\'' +
                "Number:" + number + '\'' +
                "Height" + height + '\'' +
                "Weight" + weight + '\''
    }

}
