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

class GeneratorFragment: Fragment(R.layout.fragment_generator) {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enterTransition = MaterialFadeThrough()
    returnTransition = MaterialFadeThrough()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val buttonDark: Button = view.findViewById(R.id.setup_dark_button)
    val buttonLight: Button = view.findViewById(R.id.setup_light_button)

    buttonDark.setOnClickListener {
      val darkMonetFile = "monet_dark.tgx-theme"
      val darkThemeImport = requireContext().assets.open(darkMonetFile).bufferedReader().readText()
      val themeString = changeText(darkThemeImport)
      val fileName = "Dark Theme.tgx-theme"
      File(requireContext().cacheDir, fileName).writeText(text = themeString)
      val themeName: String = resources.getString(R.string.dark_theme)
      shareTheme(themeName, fileName)
    }

    buttonLight.setOnClickListener {
      val lightMonetFile = "monet_light.tgx-theme"
      val lightThemeImport = requireContext().assets.open(lightMonetFile).bufferedReader().readText()
      val themeString = changeText(lightThemeImport)
      val fileName = "Light Theme.tgx-theme"
      File(requireContext().cacheDir, fileName).writeText(text = themeString)
      val themeName: String = resources.getString(R.string.light_theme)
      shareTheme(themeName, fileName)
    }
  }

  private fun changeText(file: String): String {
    val applicationContext = requireContext()
    val monetList = mapOf(
      "a1_0x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_0)),
      "a1_200x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_200)),
      "a1_300x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_300)),
      "a1_400x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_400)),
      "a1_500x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_500)),
      "a1_600x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_600)),
      "a1_700x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_700)),
      "a1_800x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_800)),
      "a1_900x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_900)),
      "a1_1000x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_1000)),
      "a1_100x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_100)),
      "a1_10x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_10)),
      "a1_50x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent1_50)),
      "a2_0x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_0)),
      "a2_200x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_200)),
      "a2_300x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_300)),
      "a2_400x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_400)),
      "a2_500x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_500)),
      "a2_600x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_600)),
      "a2_700x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_700)),
      "a2_800x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_800)),
      "a2_900x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_900)),
      "a2_1000x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_1000)),
      "a2_100x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_100)),
      "a2_10x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_10)),
      "a2_50x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent2_50)),
      "a3_0x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_0)),
      "a3_200x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_200)),
      "a3_300x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_300)),
      "a3_400x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_400)),
      "a3_500x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_500)),
      "a3_600x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_600)),
      "a3_700x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_700)),
      "a3_800x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_800)),
      "a3_900x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_900)),
      "a3_1000x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_1000)),
      "a3_100x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_100)),
      "a3_10x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_10)),
      "a3_50x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_accent3_50)),
      "n1_0x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_0)),
      "n1_200x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_200)),
      "n1_300x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_300)),
      "n1_400x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_400)),
      "n1_500x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_500)),
      "n1_600x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_600)),
      "n1_700x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_700)),
      "n1_800x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_800)),
      "n1_900x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_900)),
      "n1_1000x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_1000)),
      "n1_100x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_100)),
      "n1_10x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_10)),
      "n1_50x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral1_50)),
      "n2_0x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_0)),
      "n2_200x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_200)),
      "n2_300x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_300)),
      "n2_400x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_400)),
      "n2_500x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_500)),
      "n2_600x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_600)),
      "n2_700x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_700)),
      "n2_800x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_800)),
      "n2_900x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_900)),
      "n2_1000x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_1000)),
      "n2_100x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_100)),
      "n2_10x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_10)),
      "n2_50x" to Integer.toHexString(ContextCompat.getColor(applicationContext, R.color.system_neutral2_50)),
    )
    var themeText = file.replace("\$", "")
    monetList.forEach {
      themeText = themeText.replace(it.key, it.value.toString().substring(2))
    }
    return themeText
  }

  private fun shareTheme(theme: String, file_name: String) {
    val applicationContext = requireContext()
    val file = File(applicationContext.cacheDir, file_name)
    val uri = FileProvider.getUriForFile(
      applicationContext,
      "$APPLICATION_ID.provider",
      file
    )
    val intent = Intent(Intent.ACTION_SEND)
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    intent.type = "*/tgx-theme"
    intent.putExtra(Intent.EXTRA_STREAM, uri)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(Intent.createChooser(intent, theme))
  }
}