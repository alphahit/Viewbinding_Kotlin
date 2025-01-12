package com.prateek.viewbinding
//This declares the package where this file (MainActivity.kt) resides.
//The package name is a unique namespace for the code and typically reflects the app's domain name in reverse (e.g., com.prateek).

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
//Enables edge-to-edge rendering of the app's UI, extending content behind system bars (requires the androidx.activity library).
import androidx.appcompat.app.AppCompatActivity
//Provides backward-compatible features of the Activity class for older Android versions.
import com.prateek.viewbinding.databinding.ActivityMainBinding

// This is the binding class for the activity_main.xml layout file. This class is generated because View Binding is enabled.


class MainActivity : AppCompatActivity() {
//MainActivity is the entry point of the app, extending AppCompatActivity. The AppCompatActivity class ensures compatibility with older Android versions.


    private lateinit var binding: ActivityMainBinding
    //lateinit means the variable will be initialized later. It avoids null values and initialization in the constructor.
    //binding is an instance of ActivityMainBinding, which gives access to the views in activity_main.xml.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //onCreate: Called when the activity is created.



        binding = ActivityMainBinding.inflate(layoutInflater)
//        Inflates the activity_main.xml layout.
//        Creates an instance of ActivityMainBinding.


        setContentView(binding.root)
        //Sets the root view of activity_main.xml as the content view for this activity.

        enableEdgeToEdge()
        val myBank: Int = 1000


        val dollarValue = myBank * 0.012 // Implicitly uses Double
        binding.usdText.text = String.format("%.2f$", dollarValue) // Formats to 2 decimal places

        binding.inrText.text = "${myBank.toString()}₹"
    }
}


//View Binding is a feature that generates a binding class for each XML layout file. The binding class contains references to all the views with id attributes in the XML.

//How View Binding Works:
//When you enable View Binding in your project, Android generates a binding class for each layout file.
//For example, if your layout file is activity_main.xml, the generated binding class will be ActivityMainBinding.
//Advantages of View Binding:
//Type Safety: You get compile-time safety for accessing views. No more findViewById() calls.
//Less Boilerplate Code: Simplifies the process of accessing views by reducing repetitive code.
//Null Safety: Reduces runtime crashes due to null view references.

//View Binding: A feature that simplifies accessing views and eliminates the need for findViewById().
//Binding Class: Generated for each layout file (e.g., ActivityMainBinding for activity_main.xml).
//How It Works in Code:
//Inflate the binding class.
//Use the binding variable to access views directly (e.g., binding.textView.text).
//Advantages:
//Reduces boilerplate.
//Null and type safety.
//Cleaner code.