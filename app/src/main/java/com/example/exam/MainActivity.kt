package com.example.exam

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.Adapter.RecyclerAdapter
import com.example.exam.Model.Member

class MainActivity : AppCompatActivity() {

    var context: Context? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter:RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }



    fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.setLayoutManager(GridLayoutManager(context, 1))

        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @SuppressLint("NotifyDataSetChanged")
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val gridLayoutManager = recyclerView.getLayoutManager() as GridLayoutManager
                val totalItem = gridLayoutManager.itemCount
                val lastVisible = gridLayoutManager.findLastVisibleItemPosition()
                val endHasBeenReached = lastVisible + 5 >= totalItem
                if (totalItem > 0 && endHasBeenReached) {
                    Toast.makeText(context, "Loading more ... ", Toast.LENGTH_SHORT).show()
                    loadMoreFoods()
                    recyclerViewAdapter?.notifyDataSetChanged();
                }
            }
        })

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


    private fun loadMoreFoods(){
        val members: ArrayList<Member> = java.util.ArrayList<Member>()

        members.add(Member(R.drawable.img, "Hamburger"))
        members.add(Member(R.drawable.img_1, "Hot Dog"))
        members.add(Member(R.drawable.img_2, "Stake"))
        members.add(Member(R.drawable.img_3, "Pizza"))
        members.add(Member(R.drawable.img_4, "Salad"))


    }
    fun refreshAdapter(members: ArrayList<Member>?) {
        val adapter = RecyclerAdapter(context!!, members!!)
        recyclerView!!.adapter = adapter
    }
}