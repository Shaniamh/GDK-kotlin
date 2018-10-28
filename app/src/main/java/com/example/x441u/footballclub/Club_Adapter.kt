package com.example.x441u.footballclub

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ScrollingTabContainerView
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import com.example.x441u.footballclub.R.id.club_img
import com.example.x441u.footballclub.R.id.club_nm
import org.jetbrains.anko.*
import java.text.FieldPosition
import java.util.*

/**
 * Created by X441U on 10/27/2018.
 */
class Club_Adapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<Club_Adapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(clubLayout().createView(AnkoContext.create(parent.context, parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class clubLayout : AnkoComponent<ViewGroup> {

        override fun createView(ui: AnkoContext<ViewGroup>)= with(ui) {
            verticalLayout{
                lparams(width = matchParent, height = wrapContent)
                padding     = dip (15)
                orientation = LinearLayout.HORIZONTAL

                imageView(){
                    id = club_img
                }.lparams{
                    height = dip(50)
                    width  = dip(50)
                }

                textView{
                    id       = club_nm
                    textSize = 15f
                }.lparams{
                    margin  = dip(10)
                }
            }
        }

    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

        private val clubImage: ImageView = containerView.find(club_img)
        private val clubName: TextView = containerView.find(club_nm)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            clubName.text = items.name
            Glide
                    .with(containerView)
                    .load(items.image)
                    .into(clubImage)
            containerView.setOnClickListener { listener(items) }
        }

    }

}