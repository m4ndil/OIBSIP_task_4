package com.animalQuiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        beginBtn.setOnClickListener {
            val userName = usernameET.text.toString().trim()

            if (userName.isEmpty()) {
                // Display an error message if the username is empty.
                displayToast("Enter a username :)")
            } else {
                beginQuiz(userName)
            }
        }
    }

    private fun beginQuiz(userName: String) {
        val i = Intent(this@MainActivity, LogicQuestion::class.java)
        // Pass the username through intent using the constant variable.
        i.putExtra(PropertyConstants.uname, userName)
        startActivity(i)
        finish()
    }

    private fun displayToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}
