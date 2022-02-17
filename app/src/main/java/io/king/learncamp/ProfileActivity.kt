package io.king.learncamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
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
        val imagers = bundle.getInt("imageView2")
        val jobs = bundle.getString("job2")
        val names = bundle.getString("name2")


        jobNew.text = jobs
        namesNew.text = names
        storyOne.text = story

        Glide.with(this)
            .load(imagers)
            .into(imageView2);
    }
}