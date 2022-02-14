package io.king.learncamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val profileList: ArrayList<Profile>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.content, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = profileList[position]
        holder.profilePicture.setImageResource(currentItem.pic)
        holder.profileName.text = currentItem.name
        holder.profileJob.text = currentItem.job
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val profilePicture : ImageView = itemView.findViewById(R.id.picture)
        val profileName : TextView = itemView.findViewById(R.id.names)
        val profileJob : TextView = itemView.findViewById(R.id.jobs)
    }
}