package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerAnimal: Spinner
    private lateinit var buttonGetInfo: Button
    private lateinit var buttonShowFact: Button
    private lateinit var textViewAnimalInfo: TextView

    private val animals = arrayOf(
        "Lion",
        "Elephant",
        "Giraffe",
        "Monkey"
    )

    private val animalInfos = arrayOf(
        "The lion is a carnivorous mammal and the king of the jungle. It is known for its majestic mane and powerful roar. Lions are social animals and live in prides, which are typically made up of several females, their cubs, and one or more males.",
        "The elephant is a large, intelligent, and social animal with a long trunk. It has a highly developed brain and is considered one of the smartest animals on Earth. Elephants have a strong sense of family and social bonds, and they live in large matriarchal herds.",
        "The giraffe is a tall, even-toed ungulate with a distinctive coat pattern. It has a long neck and legs, and can reach heights of over 18 feet tall. Giraffes are herbivores and feed on leaves, fruits, and flowers from trees and shrubs.",
        "The monkey is a primate that lives in trees and is known for its agility. There are over 260 species of monkeys, ranging in size from the 6-inch pygmy marmoset to the 3-foot mandrill. Monkeys are social animals and live in troops, which are typically led by a dominant male."
    )

    private val animalFacts = arrayOf(
        "Lions are known for their loud roars, which can be heard up to five miles away.",
        "Elephants have a highly developed sense of smell and can detect water from far away.",
        "Giraffes have the highest blood pressure of any animal, which helps them pump blood up to their brains against gravity.",
        "Monkeys are highly intelligent and have been observed using tools in the wild."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAnimal = findViewById(R.id.spinner_animal)
        buttonGetInfo = findViewById(R.id.button_get_info)
        buttonShowFact = findViewById(R.id.button_show_fact)
        textViewAnimalInfo = findViewById(R.id.textview_animal_info)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, animals)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAnimal.adapter = adapter

        spinnerAnimal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val animalInfo = animalInfos[position]
                textViewAnimalInfo.text = animalInfo
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        buttonGetInfo.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val position = spinnerAnimal.selectedItemPosition
                val animalInfo = animalInfos[position]
                textViewAnimalInfo.text = animalInfo
            }
        })

        buttonShowFact.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val position = spinnerAnimal.selectedItemPosition
                val animalFact = animalFacts[position]
                textViewAnimalInfo.text = animalFact
            }
        })
    }
}
