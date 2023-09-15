package com.animalQuiz

data class PropertyQuestion(
    val questionNum: Int,
    val questionTitle: String,
    val imageHint: Int,
    val optionsChoice: List<String>,
    val rightAnswer: Int
) {

    val optionOne: String
        get() = optionsChoice[0]

    val optionTwo: String
        get() = optionsChoice[1]

    val optionThree: String
        get() = optionsChoice[2]

    val optionFour: String
        get() = optionsChoice[3]
}
