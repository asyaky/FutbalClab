package com.doovj.futbalclab

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class DetailActivity : AppCompatActivity() {
    companion object {
        val CLABEXTRA = "extra_clab"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val i = intent
        val clab = i.getParcelableExtra<Clab>(CLABEXTRA)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Club Bola"

        actionBar.setDisplayHomeAsUpEnabled(true)

        DetailActivityUI(clab).setContentView(this)
    }

    class DetailActivityUI(var clab: Clab) : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout{
                padding = dip(16)

                textView{
                    id = FutbalClabUI.nameId
                    padding = dip(16)
                    text = clab.namaklab
                    typeface = Typeface.DEFAULT_BOLD
                    gravity = Gravity.CENTER_HORIZONTAL
                    textSize = 16f
                }.lparams(matchParent, wrapContent)

                imageView{
                    Glide.with(this).load(clab.gambarklab).into(this)
                    id = FutbalClabUI.imageId

                    setOnClickListener {
                        snackbar("I love ${clab.namaklab}!")
                    }

                    this@verticalLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(150), dip(150))

                textView{
                    id = FutbalClabUI.descriptionId
                    text = clab.deskripsiklab
                    padding = dip(16)
                    gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(matchParent, wrapContent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}