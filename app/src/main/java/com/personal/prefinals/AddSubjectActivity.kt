package com.personal.prefinals

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddSubjectActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_subject)

        val subjectName = findViewById<EditText>(R.id.ASet_subjectName)
        val subjectCode = findViewById<EditText>(R.id.ASet_subjectCode)
        val gradeLevel = findViewById<EditText>(R.id.ASet_gradeLevel)
        val roomNumber = findViewById<EditText>(R.id.ASet_roomNumber)
        val time = findViewById<EditText>(R.id.ASet_time)
        val btnAdd = findViewById<Button>(R.id.ASbtn_add)


    }
}