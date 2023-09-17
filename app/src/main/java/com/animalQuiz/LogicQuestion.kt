package com.animalQuiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class LogicQuestion : AppCompatActivity(), View.OnClickListener {

    private var questionNumber: Int = 1
    private var questionsList: ArrayList<PropertyQuestion>? = null

    private var choosedOption: Int = 0
    private var totalCorrectAns: Int = 0

    // User name variable obtained from intent
    private var userNameStore: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        // Hide status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Get the user name using intent
        userNameStore = intent.getStringExtra(PropertyConstants.uname)

        // Initialize the question list
        questionsList = PropertyConstants.animalQuestions()

        //calling function to display first question, options and btn
        displayQuestions()

        // Set click listeners for options and next button to count correct answer and proceed to next
        o1TV.setOnClickListener(this)
        o2TV.setOnClickListener(this)
        o3TV.setOnClickListener(this)
        o4TV.setOnClickListener(this)
        nxtBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //cases
        when (v?.id) {

            R.id.o1TV -> {
                //call function with argument 1
                choosenOption(o1TV, 1)
            }

            R.id.o2TV -> {
                choosenOption(o2TV, 2)
            }

            R.id.o3TV -> {
                choosenOption(o3TV, 3)
            }

            R.id.o4TV -> {
                choosenOption(o4TV, 4)
            }

            R.id.nxtBtn -> {

                if (choosedOption == 0) {
                    // User hasn't selected any option, move to the next question
                    questionNumber++

                    when {
                        questionNumber <= questionsList!!.size -> {
                            displayQuestions()
                        }
                        else -> {
                            // All questions answered, move to result screen
                            val i = Intent(this@LogicQuestion, EndLogic::class.java)
                            i.putExtra(PropertyConstants.uname, userNameStore)
                            i.putExtra(PropertyConstants.correctAns, totalCorrectAns)
                            i.putExtra(PropertyConstants.totalQues, questionsList!!.size)
                            startActivity(i)
                            finish()
                        }
                    }
                } else {
                    // User has selected an option
                    val question = questionsList?.get(questionNumber - 1)

                    // Check if the answer is correct
                    if (question!!.rightAnswer != choosedOption) {
                        rightWrong(choosedOption, R.drawable.red_option)
                    } else {
                        totalCorrectAns++
                    }

                    // Highlight the correct answer
                    rightWrong(question.rightAnswer, R.drawable.green_option)

                    if (questionNumber == questionsList!!.size) {
                        nxtBtn.text = "CONFIRM"
                    } else {
                        nxtBtn.text = "NEXT"
                    }

                    choosedOption = 0
                }
            }
        }
    }

    private fun displayQuestions() {
        // Set the question and options for the current position
        val question = questionsList!!.get(questionNumber - 1)

        defaultApperance()

        if (questionNumber == questionsList!!.size) {
            nxtBtn.text = "FINISH"
        } else {
            nxtBtn.text = "SUBMIT"
        }

        UIbar.progress = questionNumber
        leftQuesTV.text = "$questionNumber" + "/" + UIbar.getMax()

        quesTV.text = question.questionTitle
        hintImage.setImageResource(question.imageHint)
        o1TV.text = question.optionOne
        o2TV.text = question.optionTwo
        o3TV.text = question.optionThree
        o4TV.text = question.optionFour
    }

    private fun choosenOption(tv: TextView, selectedOptionNum: Int) {
        // Highlight the selected option
        defaultApperance()

        choosedOption = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this@LogicQuestion, R.drawable.select_option)
    }

    private fun defaultApperance() {
        // Reset the options to default view
        val allOptions = ArrayList<TextView>()
        allOptions.add(0, o1TV)
        allOptions.add(1, o2TV)
        allOptions.add(2, o3TV)
        allOptions.add(3, o4TV)

        for (option in allOptions) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this@LogicQuestion, R.drawable.default_design)
        }
    }

    private fun rightWrong(answer: Int, drawableView: Int) {
        // Highlight the answer view
        when (answer) {

            1 -> {
                o1TV.background = ContextCompat.getDrawable(this@LogicQuestion, drawableView)
            }
            2 -> {
                o2TV.background = ContextCompat.getDrawable(this@LogicQuestion, drawableView)
            }
            3 -> {
                o3TV.background = ContextCompat.getDrawable(this@LogicQuestion, drawableView)
            }
            4 -> {
                o4TV.background = ContextCompat.getDrawable(this@LogicQuestion, drawableView)
            }
        }
    }
}
