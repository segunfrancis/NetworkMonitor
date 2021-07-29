package com.segunfrancis.networkmonitorsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.segunfrancis.networkmonitor.NetworkStatus
import com.segunfrancis.networkmonitor.NetworkStatusHelper

class MainActivity : AppCompatActivity() {

    private val networkStatus: NetworkStatusHelper by lazy { NetworkStatusHelper(this) }
    private val networkText: TextView by lazy { findViewById(R.id.network_text) }
    private val networkView: View by lazy { findViewById(R.id.network_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkStatus.observe(this) { status ->
            when(status) {
                NetworkStatus.Available -> {
                    networkText.text = getString(R.string.text_network_available)
                    networkView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                NetworkStatus.Unavailable -> {
                    networkText.text = getString(R.string.text_network_unavailable)
                    networkView.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                }
            }
        }
    }
}
