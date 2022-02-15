package io.king.learncamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val profileList: ArrayList<Profile>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListner : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setItemClickListener(listener: onItemClickListener){
        mListner = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.content, parent, false)
        return MyViewHolder(itemView, mListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = profileList[position]
        holder.profilePicture.setImageResource(currentItem.pictures)
        holder.profileName.text = currentItem.names
        holder.profileJob.text = currentItem.jobs
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class  MyViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){

        val profilePicture : ImageView = itemView.findViewById(R.id.picture)
        val profileName : TextView = itemView.findViewById(R.id.names)
        val profileJob : TextView = itemView.findViewById(R.id.jobs)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
}