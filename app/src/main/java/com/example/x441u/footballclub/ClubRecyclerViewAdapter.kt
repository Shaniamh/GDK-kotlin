package com.example.x441u.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*

/**
 * Created by X441U on 10/27/2018.
 */
class ClubRecyclerViewAdapter (private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<ClubRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ClubLayout().createView(AnkoContext.create(parent.context, parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val clubImage: ImageView = itemView.find(R.id.club_img)
        private val clubName: TextView   = itemView.find(R.id.club_nm)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            clubName.text = items.name
            Glide
                    .with(itemView)
                    .load(items.image)
                    .into(clubImage)
            containerView.setOnClickListener { listener(items) }
        }

    }
}

