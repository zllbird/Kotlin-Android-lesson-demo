package com.httpdemo.zhulonglong.koitindemo.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.widget.media.AndroidMediaController
import com.httpdemo.zhulonglong.koitindemo.widget.media.IjkVideoView

import kotlinx.android.synthetic.main.activity_player.*
import org.jetbrains.anko.find
import tv.danmaku.ijk.media.player.IjkMediaPlayer

/**
 * 播放器
 * Created by zhulonglong on 2017/2/9.
 */
class PlayerActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        val mVideoPath = "http://lesdo-video.b0.upaiyun.com/test_short_mp4_video.mp4"
        val mMediaController = AndroidMediaController(this,false)
        setSupportActionBar(toolbar)
        mMediaController.setSupportActionBar(supportActionBar)
        drawer_layout.setScrimColor(Color.TRANSPARENT)

        //init player
        IjkMediaPlayer.loadLibrariesOnce(null)
        IjkMediaPlayer.native_profileBegin("libijkplayer.so")

        video_view.setMediaController(mMediaController)
        video_view.setHudView(hud_view)
        video_view.setVideoPath(mVideoPath)
        video_view.start()
    }

    override fun onStop() {
        super.onStop()
        video_view.stopPlayback()
        video_view.release(true)
        video_view.stopBackgroundPlay()
    }

}
