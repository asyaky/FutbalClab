package com.doovj.futbalclab

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class FutbalClabUI : AnkoComponent<ViewGroup> {

    companion object {
        val nameId = 0
        val imageId = 1
        val descriptionId = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout{
            lparams(dip(160), wrapContent)
            padding = dip(16)

            imageView {
                id = imageId
            }.lparams(dip(80), dip(80)) {
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView {
                id = nameId
                textColor = Color.BLACK
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams(wrapContent, wrapContent) {
                topMargin = dip(6)
                gravity = Gravity.CENTER_HORIZONTAL
            }

        }
    }
}