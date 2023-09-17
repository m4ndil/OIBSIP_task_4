package com.animalQuiz

object PropertyConstants {
    // Constants for intent extras
    const val uname = "user_name"
    const val totalQues = "total_questions"
    const val correctAns = "correct_answers"

    fun animalQuestions(): ArrayList<PropertyQuestion> {
        val questionsList = ArrayList<PropertyQuestion>()

        // Question 1
        val firstQuestion = PropertyQuestion(
            1, "What is the largest land animal?",
            R.drawable.elephant,
            listOf("Lion", "Elephant", "Ant", "Hippopotamus"),
            rightAnswer = 2
        )
        questionsList.add(firstQuestion)

        // Question 2
        val secondQuestion = PropertyQuestion(
            2, "Which bird is known for its colorful plumage and is often kept as a pet?",
            R.drawable.parrot,
            listOf("Penguin", "Eagle", "Parrot", "Ostrich"),
            rightAnswer = 3
        )
        questionsList.add(secondQuestion)

        // Question 3
        val thirdQuestion = PropertyQuestion(
            3, "What is the fastest land animal?",
            R.drawable.cheetah,
            listOf("Cheetah", "Gazelle", "Ostrich", "Leopard"),
            rightAnswer = 1
        )
        questionsList.add(thirdQuestion)

        // Question 4
        val fourthQuestion = PropertyQuestion(
            4, "Which reptile is known for changing the color of its skin to blend in with its surroundings?",
            R.drawable.chameleon,
            listOf("Turtle", "Crocodile", "Chameleon", "Iguana"),
            rightAnswer = 3
        )
        questionsList.add(fourthQuestion)

        // Question 5
        val fifthQuestion = PropertyQuestion(
            5, "What is the largest species of shark?",
            R.drawable.wshark,
            listOf("Great White Shark", "Hammerhead Shark", "Tiger Shark", "Whale Shark"),
            rightAnswer = 4
        )
        questionsList.add(fifthQuestion)

        return questionsList
    }
}
