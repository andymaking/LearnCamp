package io.king.learncamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.king.learncamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var profileList : ArrayList<Profile>
    lateinit var pictures : Array<Int>
    lateinit var names : Array<String>
    lateinit var jobs : Array<String>

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

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        profileList = arrayListOf<Profile>()
        getUserData()
    }
    private fun getUserData() {
        for (i in pictures.indices){
            val person = Profile(pictures[i],names[i], jobs[i])
            profileList.add(person)
        }

        recyclerView.adapter = MyAdapter(profileList)

    }

}