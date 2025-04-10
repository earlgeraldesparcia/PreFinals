package com.personal.prefinals

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.personal.prefinals.data.Subject
import com.personal.prefinals.helper.SubjectRecyclerViewAdapter


class HomeScreenActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        val subjectList = listOf(
            Subject("MobDev","CSIT284","2nd Year","NGE101","6-9PM",),
            Subject("Weeww","CSIT284","2nd Year","NGE101","6-9PM",)
        );

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SubjectRecyclerViewAdapter(
            subjectList,
            onClick = {subjectList ->
                startActivity(
                    Intent(this, ClassActivityScreen::class.java)
                )
            }
        )
    }
}