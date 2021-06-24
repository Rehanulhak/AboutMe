package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Rehan Ul Haq")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        //findViewById<Button>(R.id.button).setOnClickListener {
        //    addNickname(it)
        //}
        binding.button.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = edittextNickname.text.toString()
            invalidateAll()
            edittextNickname.visibility = View.GONE
            button.visibility = View.GONE
            nickText.visibility = View.GONE
            nicknameTextView.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}