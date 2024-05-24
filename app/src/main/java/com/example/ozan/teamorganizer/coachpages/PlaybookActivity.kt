package com.example.ozan.teamorganizer.coachpages

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.ozan.teamorganizer.CoachPage
import com.example.ozan.teamorganizer.MainPage
import com.example.ozan.teamorganizer.R
import com.example.yourapp.PlaybookFragment

class PlaybookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playbook)

        val backbutton: ImageButton = findViewById(R.id.backbutton)

        backbutton.setOnClickListener {

            val intent = Intent(this, CoachPage::class.java)
            startActivity(intent)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PlaybookFragment())
            .commit()
    }
}
