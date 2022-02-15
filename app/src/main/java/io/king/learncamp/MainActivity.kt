package io.king.learncamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.king.learncamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var profileList : ArrayList<Profile>
    lateinit var pictures : Array<Int>
    private lateinit var names : Array<String>
    private lateinit var jobs : Array<String>
    lateinit var story : Array<String>

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        pictures = arrayOf(
            R.drawable.halima,
            R.drawable.race,
            R.drawable.yellow,
            R.drawable.sass,
            R.drawable.godfree,
            R.drawable.white,
            R.drawable.halima,
            R.drawable.race,
            R.drawable.yellow,
            R.drawable.sass,
            R.drawable.godfree,
            R.drawable.white,
        )

        names = arrayOf(
            "Halima Williams",
            "Tanya Saint-Patrick",
            "Joyce Daniel",
            "Margaret Benson",
            "Godfred Johnson",
            "Tasha Combs",
            "Halima Williams",
            "Tanya Saint-Patrick",
            "Joyce Daniel",
            "Margaret Benson",
            "Godfred Johnson",
            "Tasha Combs",
        )

        jobs = arrayOf(
            "Banker",
            "Doctor",
            "Lawyer",
            "Engineer",
            "Developer",
            "Cinematographer",
            "Banker",
            "Doctor",
            "Lawyer",
            "Engineer",
            "Developer",
            "Cinematographer",
        )

        story = arrayOf(
            getString(R.string.bankers),
            getString(R.string.doctor),
            getString(R.string.lawyer),
            getString(R.string.engineer),
            getString(R.string.developer),
            getString(R.string.cinematographer),
            getString(R.string.bankers),
            getString(R.string.doctor),
            getString(R.string.lawyer),
            getString(R.string.engineer),
            getString(R.string.developer),
            getString(R.string.cinematographer),
        )

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        profileList = arrayListOf<Profile>()
        getUserData()
    }
    private fun getUserData() {
        for (i in pictures.indices){
            val person = Profile(pictures[i],names[i], jobs[i], story[i])
            profileList.add(person)
        }

        var adapter = MyAdapter(profileList)
        recyclerView.adapter = adapter

        adapter.setItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                intent.putExtra("name2", profileList[position].names)
                intent.putExtra("job2", profileList[position].jobs)
                intent.putExtra("imageView2", profileList[position].pictures)
                intent.putExtra("story", profileList[position].story)

                startActivity(intent)

            }

        })

    }

}