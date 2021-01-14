package com.example.pengenalanukm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ukm.*

class UkmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ukm)

        val data = CreateUkm()
        rv_list_main.layoutManager = LinearLayoutManager(this)
        rv_list_main.setHasFixedSize(true)
        rv_list_main.adapter = AdapterUkm(data, { onItem: DataUkm -> onItemClicked(onItem) })

    }
    private fun onItemClicked(onItem: DataUkm) {
        val showDetailActivityIntent = Intent(this, DetailUkm::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, onItem.imgFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_INTENT, onItem.nameFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, onItem.nameFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, onItem.descFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_SUBJECT, onItem.lokasiFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_INDEX, onItem.hargaFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_ORIGINATING_URI, onItem.webFac)
        startActivity(showDetailActivityIntent)
    }
}
