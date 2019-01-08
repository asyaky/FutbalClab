package com.doovj.futbalclab

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor

class MainActivity : AppCompatActivity() {

    private var clabs: MutableList<Clab> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ambilData()

        tvKlab_Bola.apply {
            text = getString(R.string.clubbola)
            textColor = Color.BLACK
            textSize = 16f
            textAlignment = View.TEXT_ALIGNMENT_CENTER
        }

        daftar_club.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = ClabRecyclerViewAdapter(clabs) {
                startActivity<DetailActivity>(DetailActivity.CLABEXTRA to it)
            }
        }
    }

    private fun ambilData(){
        val nami = resources.getStringArray(R.array.club_name)
        val gambar = resources.obtainTypedArray(R.array.club_image)
        val deskripsion = resources.getStringArray(R.array.club_description)
        clabs.clear()
        for (i in nami.indices) {
            clabs.add(Clab(nami[i], gambar.getResourceId(i, 0), deskripsion[i]))
        }

        gambar.recycle()
    }
}