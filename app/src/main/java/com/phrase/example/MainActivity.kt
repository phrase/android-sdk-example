package com.phrase.example

import android.os.Bundle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import com.phrase.android.sdk.Phrase

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ComposeView>(R.id.compose_view).setContent {
            Phrase {
                MaterialTheme {
                    Text(
                        text = stringResource(R.string.hello_world),
                        style = MaterialTheme.typography.h3
                    )
                }
            }
        }
    }
}