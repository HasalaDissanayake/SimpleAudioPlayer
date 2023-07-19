package com.example.practical06

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var isPaused = false
    private lateinit var playPauseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.default_audio)
        mediaPlayer!!.start()

        playPauseButton = findViewById(R.id.playPauseButton);

        playPauseButton.setOnClickListener {

            if (mediaPlayer!!.isPlaying) {
                mediaPlayer!!.pause()
                isPaused = true
                playPauseButton.text = "Play"
            } else {
                mediaPlayer!!.start()
                isPaused = false
                playPauseButton.text = "Pause"
            }
        }
    }

    override fun onStart() {
        super.onStart()

        if (isPaused) {
            mediaPlayer!!.start()
            isPaused = false
        }
    }

    override fun onPause() {
        super.onPause()

        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
            isPaused = true
        }
    }

    override fun onStop() {
        super.onStop()

        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
}