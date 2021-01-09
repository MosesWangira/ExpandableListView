package com.example.expandablelistview

import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.expandablelistview.ExpandableListData.data
import com.example.expandablelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var expandableListView: ExpandableListView
    lateinit var adapter: ExpandableListAdapter
    lateinit var titleList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        expandableListView = binding.expendableList

        val listData = data
        titleList = ArrayList(listData.keys)
        adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)

        expandableListView.apply {
            adapter = adapter
            setOnGroupExpandListener { groupPosition ->
                toast((titleList as ArrayList<String>)[groupPosition] + " List Expanded.")
            }
            setOnGroupCollapseListener { groupPosition ->
                toast((titleList as ArrayList<String>)[groupPosition] + " List Collapsed.")
            }
            setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
                toast("Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(
                        titleList as
                                ArrayList<String>
                        )
                        [groupPosition]]!![childPosition])
                false
            }
        }

//        val listData = data
//        titleList = ArrayList(listData.keys)
//        adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
//        expandableListView.setAdapter(adapter)
//        expandableListView.setOnGroupExpandListener { groupPosition ->
//            Toast.makeText(
//                applicationContext,
//                (titleList as ArrayList<String>)[groupPosition] + " List Expanded.",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        expandableListView.setOnGroupCollapseListener { groupPosition ->
//            Toast.makeText(
//                applicationContext,
//                (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        expandableListView.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
//            Toast.makeText(
//                applicationContext,
//                "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(
//                        titleList as
//                                ArrayList<String>
//                        )
//                        [groupPosition]]!!.get(
//                    childPosition
//                ),
//                Toast.LENGTH_SHORT
//            ).show()
//            false
//        }
    }

    private fun toast(toastMessage: String){
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }
}