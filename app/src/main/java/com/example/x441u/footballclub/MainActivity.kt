package com.example.x441u.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataClub()

            recyclerView {
                layoutManager = LinearLayoutManager(ctx)
                adapter = ClubRecyclerViewAdapter(ctx, items) {
                    startActivity<ClubDetail>(
                            "ClubName" to "${it.name}",
                            "ClubImage" to it.image,
                            "ClubDesc" to "${it.desc}")
                }
            }
    }

    private fun dataClub(){

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0), desc[i]))
        }
        image.recycle()
    }
}
