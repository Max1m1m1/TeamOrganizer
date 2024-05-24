package com.example.ozan.teamorganizer

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.ozan.teamorganizer.coachpages.AdjustPlayers
import com.example.ozan.teamorganizer.coachpages.MessagesActivity
import com.example.ozan.teamorganizer.coachpages.PlaybookActivity

class CoachPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coach_page)

        val buttonPlayers: Button = findViewById(R.id.playerbutton)
        val buttonPlaybook: Button = findViewById(R.id.playbookbutton)
        val buttonMessages: Button = findViewById(R.id.messagesbutton)
        val backbutton:ImageButton=findViewById(R.id.backbutton)

        backbutton.setOnClickListener{
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }

         buttonPlayers.setOnClickListener {
             val intent = Intent(this, AdjustPlayers::class.java)
             startActivity(intent)
         }

        buttonPlaybook.setOnClickListener {
            // Open the activity for Playbook
            val intent = Intent(this, PlaybookActivity::class.java)
            startActivity(intent)
        }

        buttonMessages.setOnClickListener {
            // Open the activity for Messages
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
        }
    }
}
