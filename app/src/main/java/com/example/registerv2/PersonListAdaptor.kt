package com.example.registerv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonListAdaptor internal constructor(
    context: Context
): RecyclerView.Adapter<PersonListAdaptor.PersonViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var people = emptyList<Person>()

    inner class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val personItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val current = people[position]
        val name = current.id.toString() + " " + current.firstName + " " + current.surname
        holder.personItemView.text = name
    }

    internal fun setPeople(people: List<Person>) {
        this.people = people
        notifyDataSetChanged()
    }

    override fun getItemCount() = people.size

}