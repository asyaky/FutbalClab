package com.doovj.futbalclab

import android.graphics.Color
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
            linearLayout{
                padding = dip(16)

                imageView{
                    Glide.with(this).load(clab.gambarklab).into(this)
                    id = R.id.imageId

                    setOnClickListener {
                        snackbar("I love ${clab.namaklab}!")
                    }

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(120), dip(120))

                verticalLayout {
                    padding = dip(16)

                    textView{
                        id = R.id.nameId
                        text = clab.namaklab
                        textColor = Color.BLACK
                        textSize = 17f
                    }.lparams(matchParent, wrapContent) {
                        bottomMargin = dip(16)
                    }

                    textView{
                        id = R.id.descriptionId
                        text = clab.deskripsiklab
                        lines = 2
                    }.lparams(matchParent, wrapContent)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}