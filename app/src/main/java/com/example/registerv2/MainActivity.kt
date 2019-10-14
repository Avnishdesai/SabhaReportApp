package com.example.registerv2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adaptor = PersonListAdaptor(this)
        recyclerView.adapter = adaptor
        recyclerView.layoutManager = LinearLayoutManager(this)

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)

        personViewModel.deleteAll()

        val person = Person(9, "workingtest", "Old WOrd")
        personViewModel.insert(person)

        personViewModel.allPeople.observe(this, Observer { people ->
            people?.let {
                adaptor.setPeople(it)
            }
        })

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewPersonActivity::class.java)
            startActivityForResult(intent, newPersonActivityRequestCode)
        }

        val refreshButtonView = findViewById<Button>(R.id.refreshButton)

        refreshButtonView?.setOnClickListener{
            personViewModel.allPeople.observe(this, Observer { people ->
                people?.let {
                    adaptor.setPeople(it)
                }
            })
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newPersonActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.let {
                val person = Person(9, "addingword", "workingworkds")
                personViewModel.insert(person)
                Toast.makeText(
                    applicationContext,
                    "New Word Added",
                    Toast.LENGTH_LONG //End Here
                ).show()
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG //End Here
            ).show()

        }
    }

    companion object{
        const val newPersonActivityRequestCode = 1
    }
}
