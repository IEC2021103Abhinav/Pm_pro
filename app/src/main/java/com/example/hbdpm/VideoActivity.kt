package com.example.hbdpm

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.hbdpm.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
    private var myVideoView: VideoView?=null
    private var myMediaController:MediaController?=null
    private lateinit var binding: ActivityVideoBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myVideoView=binding.videoV
        setupVideo()


    }
    private fun setupVideo(){
        if(myMediaController==null)
        {
            myMediaController= MediaController(this)
            myMediaController!!.setAnchorView(this.myVideoView)

        }
        myVideoView!!.setMediaController(myMediaController)
        myVideoView!!.setVideoURI(
            Uri.parse("android.resource://"+packageName+"/"+R.raw.madam1)

        )
        myVideoView!!.requestFocus()
        myVideoView!!.pause()
        myVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext,"Video khatm Hogya Madam",Toast.LENGTH_LONG).show()
        }
        myVideoView!!.setOnErrorListener{mp,what,extra->
            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            false
        }
    }
}