package com.tgx.monet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import com.tgx.monet.BuildConfig.APPLICATION_ID
import java.io.File

class AboutFragment: Fragment(R.layout.fragment_about) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
        returnTransition = MaterialFadeThrough()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonGithub: Button = view.findViewById(R.id.button_github)
        val buttonSource: Button = view.findViewById(R.id.button_source)
        val buttonTg: Button = view.findViewById(R.id.button_tg)
        val descriptionTitle : TextView = view.findViewById(R.id.description_title)

        descriptionTitle.text = getString(R.string.about_card_title, BuildConfig.VERSION_NAME)

        buttonGithub.setOnClickListener {
            openLink("https://github.com/nickpl13/Telegram-X-Monet")
        }

        buttonTg.setOnClickListener {
            openLink("https://t.me/tgxmonet")
        }

        buttonSource.setOnClickListener {
            openLink("https://github.com/c3r5b8/Telegram-Monet")
        }
    }

    private fun openLink(link: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(link)
        startActivity(i)
    }
}