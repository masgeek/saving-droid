package com.masgeek.savingdroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.mikhaellopez.circularprogressbar.CircularProgressBar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @BindView(R.id.circularProgressBar)
    lateinit var circularProgressBar: CircularProgressBar

    @BindView(R.id.txtProgress)
    lateinit var txtProgress: TextView

    @BindView(R.id.button)
    lateinit var button: Button


    val targetAmount: Float = 715000F
    var savedAmount: Float = 350000F
    var remainingAmount = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)


        button.setOnClickListener { view ->
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            remainingAmount = targetAmount - savedAmount
            val percentage = (savedAmount * 100) / targetAmount

            txtProgress.text = "${percentage.toInt()}%"

            circularProgressBar.apply { progress = percentage }
        }
    }
}
