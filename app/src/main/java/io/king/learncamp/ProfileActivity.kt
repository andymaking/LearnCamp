package io.king.learncamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import io.king.learncamp.databinding.ActivityMainBinding
import io.king.learncamp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private val binding: ActivityProfileBinding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val imageView2 = binding.imageView2
        val jobNew = binding.job2
        val namesNew = binding.names2
        val storyOne = binding.story

        val bundle : Bundle? = intent.extras

        val story = bundle!!.getString("story")
        val imagers = bundle.getInt("imagesView2")
        val jobs = bundle.getString("job2")
        val names = bundle.getString("name2")


        jobNew.text = jobs
        namesNew.text = names
        storyOne.text = story
        imageView2.setImageResource(imagers)

    }
}