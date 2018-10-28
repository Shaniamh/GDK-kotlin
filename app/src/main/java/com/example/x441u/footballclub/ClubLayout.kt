package com.example.x441u.footballclub

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

/**
 * Created by X441U on 10/27/2018.
 */
class ClubLayout : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            padding     = dip(15)
            orientation = LinearLayout.HORIZONTAL

            imageView() {
                id = R.id.club_img
            }.lparams {
                height = dip(50)
                width  = dip(50)
            }

            textView {
                id        = R.id.club_nm
                textSize  = 15f
                textColor = R.color.colorBlack
            }.lparams {
                margin  = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }
        }
    }

}