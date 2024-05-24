package com.example.ozan.teamorganizer


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ozan.teamorganizer.fragments.MessagesFragment
import com.example.yourapp.PlaybookFragment

class PlayerPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_page)

        var backbutton: ImageButton
        backbutton=findViewById(R.id.backbutton)
        val playbookbutton:Button
        playbookbutton=findViewById(R.id.playbookbutton)
        val messagesbutton:Button
        messagesbutton=findViewById(R.id.messagesbutton
        )
        playbookbutton.setOnClickListener {
            replaceFragment(PlaybookFragment())
        }

        messagesbutton.setOnClickListener {
            replaceFragment(MessagesFragment())
        }

        backbutton.setOnClickListener{
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}