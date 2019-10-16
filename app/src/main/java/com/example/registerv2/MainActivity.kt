package com.example.registerv2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adaptor = PersonListAdaptor(this)
        recyclerView.adapter = adaptor

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.reverseLayout = true

        recyclerView.layoutManager = linearLayoutManager

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)

        personViewModel.deleteAll()

        personViewModel.allPeople.observe(this, Observer { people ->
            people?.let {
                adaptor.setPeople(it)
            }
        })

        val saveButtonView = findViewById<Button>(R.id.button_save)
        val editPersonView = findViewById<EditText>(R.id.edit_person)

        saveButtonView.setOnClickListener {
            if (TextUtils.isEmpty(editPersonView.text)) {
                Toast.makeText(
                    applicationContext,
                    "No name entered",
                    Toast.LENGTH_SHORT //End Here
                ).show()
            } else {
                personViewModel.insert(
                    Person(
                        id = null,
                        firstName = editPersonView.text.toString(),
                        surname = "workingworkds"
                    )
                )

                Toast.makeText(
                    applicationContext,
                    "Inserted person",
                    Toast.LENGTH_SHORT //End Here
                ).show()

                adaptor.notifyDataSetChanged()
                recyclerView.scrollToPosition(adaptor.getItemCount())
            }
        }

    }

}
