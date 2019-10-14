package com.example.registerv2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewPersonActivity : AppCompatActivity() {

    private lateinit var editPersonView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)
        editPersonView = findViewById(R.id.edit_person)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editPersonView.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val person = editPersonView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, person)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
