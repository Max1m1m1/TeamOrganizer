package com.example.ozan.teamorganizer.coachpages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ozan.teamorganizer.CoachPage
import com.example.ozan.teamorganizer.R
import com.example.ozan.teamorganizer.adapter.RecyclerViewPlayers
import com.example.ozan.teamorganizer.db.Player
import com.example.ozan.teamorganizer.db.PlayerViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AdjustPlayers : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewPlayers
    private lateinit var playerViewModel: PlayerViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjust_players)
        var buttonback:FloatingActionButton=findViewById(R.id.backbutton)
        buttonback.setOnClickListener{
            val intent = Intent(this,CoachPage::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerPlayer)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewPlayers(this)
        recyclerView.adapter = recyclerViewAdapter

        playerViewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)

        prepareData()
        getData()
    }

    fun getData() {
        playerViewModel.readAllData.observe(this, Observer { players ->
            recyclerViewAdapter.setData(players)
        })
    }

    fun prepareData() {
        var players = ArrayList<Player>()
        players.add(Player(1, "Ozan Güngör", "RB", 31, 1.7, 75))
        players.add(Player(2, "Omer Bugra Gorgunoglu", "LB", 88, 1.88, 80))
        players.add(Player(3, "Tuna Çınkır", "LB", 12, 1.75, 82))
        players.add(Player(4,"Ata Tümtürk","TE",22,1.97,100))
        players.add(Player(5,"Nuri Berk Çiçekdemir","OL",52,1.85,110))
        players.add(Player(6,"Salih Emre Özkan","QB",1,1.82,72))

        playerViewModel.addPlayers(players)
    }
}





