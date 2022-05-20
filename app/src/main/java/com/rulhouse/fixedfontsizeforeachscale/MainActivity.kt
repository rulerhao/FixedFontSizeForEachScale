package com.rulhouse.fixedfontsizeforeachscale

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.rulhouse.fixedfontsizeforeachscale.ui.theme.FixedFontSizeForEachScaleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FixedFontSizeForEachScaleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                        ) {
                            val myText = "123456"
                            Text(
                                text = myText,
                                fontSize = dpToSp(dp = 36.dp)
                            )
                            AndroidView(
                                modifier = Modifier,
                                factory = { ctx ->
                                    TextView(ctx).apply {
                                        @SuppressLint("SetTextI18n")
                                        text = myText
                                        textSize = FontMethods.getSameSizeForEachFontSize(120f, context)
                                    }
                                },
                                update = {
                                    @SuppressLint("SetTextI18n")
                                    it.text = myText
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}