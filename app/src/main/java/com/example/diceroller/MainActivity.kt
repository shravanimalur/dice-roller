package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var result : TextView
    lateinit var luck : TextView
    var res : Int = 0
    var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            res = 0
            count = 0
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
        result = findViewById(R.id.result)
        luck = findViewById(R.id.luck)
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()
        sum(randomInt)

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun sum(n:Int) {
        count = count + 1
        res = res + n

        if(count==2){
            result.text="You can move "+res.toString()+" steps ahead...!!"
            if(res==2)
                luck.text = "Better luck next time"
            else if(res==12)
                luck.text = "Good Fortune"
            else
                luck.text = ""
        }
    }

}