# Kotlin_YoutubeAPI
Youtube 오픈 API 를 통해 동영상을 보여주는 예제

SHA1 생성법

## Terminal -> ./gradlew signingReport 치면 나옴!!

~~~kotlin

// lib -> 추가! 후 Add a Library 클릭!!
implementation files('libs/YouTubeAndroidPlayerApi.jar')

~~~

### activity_main.xml

~~~kotlin 

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.google.android.youtube.player.YouTubePlayerView
        android:layout_width="match_parent"
        android:layout_height="500dp"
        android:id="@+id/ytv_player"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        >

    </com.google.android.youtube.player.YouTubePlayerView>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="클릭!"
        android:id="@+id/btn_click"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        />

</androidx.constraintlayout.widget.ConstraintLayout>

~~~

### MainActivity.kt

~~~kotlin

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

~~~