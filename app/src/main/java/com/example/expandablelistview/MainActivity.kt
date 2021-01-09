package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.expandablelistview.ExpandableListData.data

class MainActivity : AppCompatActivity() {
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expandableListView = findViewById(R.id.expendableList)
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)
            expandableListView!!.setOnGroupExpandListener { groupPosition ->
                Toast.makeText(
                        applicationContext,
                        (titleList as ArrayList<String>)[groupPosition] + " List Expanded.",
                        Toast.LENGTH_SHORT
                ).show()
            }
            expandableListView!!.setOnGroupCollapseListener { groupPosition ->
                Toast.makeText(
                        applicationContext,
                        (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.",
                        Toast.LENGTH_SHORT
                ).show()
            }
            expandableListView!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
                Toast.makeText(
                        applicationContext,
                        "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(
                                titleList as
                                        ArrayList<String>
                                )
                                [groupPosition]]!!.get(
                                childPosition
                        ),
                        Toast.LENGTH_SHORT
                ).show()
                false
            }
        }
    }
}