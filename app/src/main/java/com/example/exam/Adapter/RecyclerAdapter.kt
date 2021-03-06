package com.example.exam.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.Model.Member
import com.example.exam.R

class RecyclerAdapter(var context: Context, var members: ArrayList<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var isLoading:Boolean = false



    override fun getItemCount(): Int {
        return  members.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_phone, parent, false)
            return CustomViewHolder(view)
    }





    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member = members[position]

        if (holder is CustomViewHolder) {
            val profile = holder.profile
            val name = holder.name

            name.setText(member.name)
            profile.setImageResource(member.profile)

        }
    }



    class CustomViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var profile: ImageView
        var name: TextView

        init {
            profile = view.findViewById(R.id.iv_profile)
            name = view.findViewById(R.id.tv_name)
        }

    }
}