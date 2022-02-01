package com.example.exam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.Adapter.RecyclerAdapter
import com.example.exam.Model.Member

class MainActivity : AppCompatActivity() {

    var context: Context? = null
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.setLayoutManager(GridLayoutManager(context, 1))
        val members: ArrayList<Member> = java.util.ArrayList<Member>()

        for (i in 0..10) {

            members.add(Member(R.drawable.img, "Hamburger"))
            members.add(Member(R.drawable.img_1, "Hot Dog"))
            members.add(Member(R.drawable.img_2, "Stake"))
            members.add(Member(R.drawable.img_3, "Pizza"))
            members.add(Member(R.drawable.img_4, "Salad"))
        }

        refreshAdapter(members)
    }

    fun refreshAdapter(members: ArrayList<Member>?) {
        val adapter = RecyclerAdapter(context!!, members!!)
        recyclerView!!.adapter = adapter
    }
}