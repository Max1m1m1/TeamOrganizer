package com.example.ozan.teamorganizer

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.ozan.teamorganizer.adapter.RecyclerViewPlayers
import com.example.ozan.teamorganizer.databinding.ActivityMainBinding
import com.example.ozan.teamorganizer.db.Player
import com.example.ozan.teamorganizer.db.PlayerViewModel
import com.example.ozan.teamorganizer.gesture.DoubleTapListener
import com.google.android.material.textfield.TextInputEditText
import java.util.Collections


class MainPage : AppCompatActivity() {

    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var adapter: RecyclerViewPlayers
    lateinit var binding: ActivityMainBinding

    lateinit var musicoffbutton: ImageButton
    lateinit var np: MediaPlayer
    lateinit var button: Button
    lateinit var id: TextInputEditText
    lateinit var passw: TextInputEditText
    lateinit var appimg: ImageView
    lateinit var bilkentlogo: ImageView
    var isPlaying = false


    @SuppressLint("ClickableViewAccessibility")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bilkentlogo = findViewById(R.id.bilkentlogo)
        appimg = findViewById(R.id.applogo)
        id = findViewById(R.id.idinput)
        passw = findViewById(R.id.password)
        button = findViewById(R.id.loginbutton)
        musicoffbutton = findViewById(R.id.musicoffbutton)
        np = MediaPlayer()

        button.setOnClickListener {

            val idInput = id.text.toString()
            val passwordInput = passw.text.toString()

            when {
                idInput == "admin" && passwordInput == "1111" -> {
                    val intent = Intent(this, CoachPage::class.java)
                    startActivity(intent)
                }

                idInput == "player" && passwordInput == "1234" -> {
                    val intent = Intent(this, PlayerPage::class.java)
                    startActivity(intent)
                }

                else -> {
                    showCustomDialog()
                }
            }

        }

        appimg.setOnTouchListener(DoubleTapListener {
            Toast.makeText(this, "Designed by Canva", Toast.LENGTH_SHORT).show()
        })
        bilkentlogo.setOnTouchListener(DoubleTapListener {
            Toast.makeText(this, "Judges Playbook First Design", Toast.LENGTH_LONG).show()
        })


        musicoffbutton.setOnClickListener {
            if (isPlaying) {
                stopMusic()
            } else {
                startMusic()
            }
        }
    }

    private fun startMusic() {
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.music)
        np.setDataSource(this, uri)

        np.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.start()
            musicoffbutton.setImageResource(R.drawable.audioff)
            isPlaying = true
        }
        np.setOnCompletionListener {
            stopMusic()
        }
        np.setOnErrorListener { mediaPlayer, what, extra ->
            stopMusic()
            true
        }
        np.prepareAsync()
    }

    private fun stopMusic() {
        if (np.isPlaying) {
            np.stop()
            np.reset()
            musicoffbutton.setImageResource(R.drawable.audion)
            isPlaying = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::np.isInitialized) {
            np.release()
        }
    }

    private fun showCustomDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_custom, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)

        val dialog = builder.create()
        dialogView.findViewById<Button>(R.id.dialogButton).setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    fun getData() {
        playerViewModel.readAllData.observe(this, Observer { players ->
            adapter.setData(players)
        })
    }

    fun prepareData() {
        var players = ArrayList<Player>()
        Collections.addAll(
            players,

            Player(1, "Ozan Güngör", "RB", 31, 1.7, 75),
            Player(2, "Omer Bugra Gorgunoglu", "LB", 88, 1.88, 80),
            Player(3, "Tuna Çınkır", "LB", 12, 1.75, 82)
        )

        playerViewModel.addPlayers(players)
    }


}

