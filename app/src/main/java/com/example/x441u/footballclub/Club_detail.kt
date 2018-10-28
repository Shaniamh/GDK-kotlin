package com.example.x441u.footballclub

import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

/**
 * Created by X441U on 10/27/2018.
 */
class Club_detail : AppCompatActivity() {

    var name = ""
    var img  = 0
    var desc = ""
    lateinit var textName: TextView
    lateinit var imageClub: ImageView
    lateinit var textDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            imageClub = imageView(R.drawable.img_barca)
                    .lparams(width = 310, height = 310) {
                        margin  = dip(13)
                        padding = dip(20)
                    }

            textName          = textView(){
                text          = "Barcelona FC"
                typeface      = Typeface.DEFAULT_BOLD
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                textSize      = 20f
            }.lparams{
                topMargin = dip (6)
                width  = wrapContent
                height = wrapContent
            }

            textDesc     = textView(){
                text     = "Description"
                textSize = 15f
            }.lparams{
                width  = wrapContent
                height = wrapContent
                topMargin = dip(6)
            }
        }

        val intent    = intent
        name          = intent.getStringExtra("name")
        img           = intent.getIntExtra("image", 0)
        desc          = intent.getStringExtra("desc")
        textName.text = name
        textDesc.text = desc
        Glide.with(applicationContext)
                .load(img)
                .into(imageClub)
    }
}