package com.example.ozan.teamorganizer.db


import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


/*
Used to access multiple data sources. It is used to seperate code and the architecture
 */
class PlayerRepository(private val PlayerDAO: PlayerDAO) {
    val readAlldata: LiveData<List<Player>> = PlayerDAO.getAllPlayers()

    fun insertPlayer(player: Player) {
        PlayerDAO.insertPlayer(player)
    }

    fun insertPlayers(players: ArrayList<Player>) {
        PlayerDAO.insertAllPlayers(players)
    }

    fun updatePlayer(player: Player) {
        PlayerDAO.updatePlayer(player)
    }

    fun deletePlayer(player: Player) {
        PlayerDAO.deletePlayer(player)
    }

    fun deleteAllPlayers() {
        PlayerDAO.deleteAllPlayers()
    }

    fun getAllPlayers(): LiveData<List<Player>> {
        return PlayerDAO.getAllPlayers()
    }

    fun getPlayerById(id: Int): Player {
        return PlayerDAO.getPlayerById(id)
    }

    fun getPlayersBySearchKey(searchKey: String): Flow<List<Player>> {
        return PlayerDAO.getPlayersBySearchKey(searchKey)
    }
}