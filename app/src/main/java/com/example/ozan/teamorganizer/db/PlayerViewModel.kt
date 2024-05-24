package com.example.ozan.teamorganizer.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PlayerViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Player>>
    private val repository:PlayerRepository

    init {
        val playerDAO = PlayerRoomDatabase.getDatabase(application).playerDao()
        repository=PlayerRepository(playerDAO)
        readAllData = repository.readAlldata
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPlayer(player)
        }
    }

    fun addPlayers(players: List<Player>) {
        viewModelScope.launch(Dispatchers.IO) {
            players.forEach {
                repository.insertPlayer(it)
            }
        }
    }

    fun deletePlayer(player: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePlayer(player)
        }
    }

    fun deleteAllPlayer() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPlayers()
        }
    }

    fun updatePlayer(player: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePlayer(player)
        }
    }

    fun searchPlayer(searchkey: String): LiveData<List<Player>> {
        return repository.getPlayersBySearchKey(searchkey).asLiveData()
    }
}