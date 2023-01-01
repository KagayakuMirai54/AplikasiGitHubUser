package com.example.aplikasigithubuser

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListUserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)
        return ListViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val name = listUser[position].name
        val photo = listUser[position].avatar
        val company = listUser[position].company
        Log.d("ListUserAdapter", "CHECK PHOTO URL: $photo")
        Glide.with(holder.itemView.context)
            .load(photo)
            .circleCrop()
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvCompany.text = company
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[position])
        }
    }

    override fun getItemCount(): Int = listUser.size
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_list_user)
        var tvName: TextView = itemView.findViewById(R.id.tv_nama_listuser)
        var tvCompany : TextView = itemView.findViewById(R.id.tv_list_company)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}


