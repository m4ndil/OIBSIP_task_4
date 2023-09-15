package com.animalQuiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class EndLogic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Get user name from intent and set it to the TextView.
        val userName = intent.getStringExtra(PropertyConstants.uname)
        unameTV.text = userName

        // Get total questions and correct answers from intent and display the score.
        val totalQues = intent.getIntExtra(PropertyConstants.totalQues, 0)
        val rightAns = intent.getIntExtra(PropertyConstants.correctAns, 0)
        resultTV.text = "Score: $rightAns/$totalQues."

        // Add a click listener to the finish button to return to the main activity.
        redoBtn.setOnClickListener {
            startActivity(Intent(this@EndLogic, MainActivity::class.java))
        }
    }
}
