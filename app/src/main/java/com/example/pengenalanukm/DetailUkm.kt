package com.example.pengenalanukm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_ukm.*

class DetailUkm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.detail_ukm)

        var intentThatStartedThisActivity = intent

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {

            showContent(intentThatStartedThisActivity)
        }
    }

    private fun showContent(intentThatStartedThisActivity: Intent) {
        var nameF = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_INTENT)
        var deskF = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TITLE)
        var deskS = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
        var deskL = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_SUBJECT)
        var deskH = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_INDEX)
        var imgF = intentThatStartedThisActivity.getIntExtra(Intent.EXTRA_TEXT, 0)
        var webF = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_ORIGINATING_URI)

        tv_name_detail.text = nameF
        tv_desc_detail.text = deskF
        tv_short_detail.text = deskS
        tv_lokasi_detail.text = deskL
        tv_harga_detail.text = deskH
        image_detail.contentDescription = nameF
        image_detail.setImageResource(imgF)

        if (webF == "") {
            tv_link_web.text = ""
            tv_lokasi_detail.text = ""
        } else {
            tv_link_web.text = webF
        }
        tv_link_web.setOnClickListener {
            //Jalankan function klikWeb dengan parameter partWeb
            clickWeb(webF.toString())
        }
    }
    private fun clickWeb(url: String) {
        val showWebActivity = Intent(this, WebUkm::class.java)
        //Kiriman Intent
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)
        // Menjalankan Activity FakultasWeb dengan Intent
        startActivity(showWebActivity)
    }
}