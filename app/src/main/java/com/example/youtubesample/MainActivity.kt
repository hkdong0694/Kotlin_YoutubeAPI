package com.example.youtubesample

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {

    private var yListener: YouTubePlayer.OnInitializedListener?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_click.setOnClickListener {
            ytv_player.initialize("develop", object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess( provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean ) {
                    if (!wasRestored) {
                        player.cueVideo("F-KjYNmsi0U")
                    }
                }
                override fun onInitializationFailure( provider: YouTubePlayer.Provider?, result: YouTubeInitializationResult? ) {

                }
            })
        }
    }
}