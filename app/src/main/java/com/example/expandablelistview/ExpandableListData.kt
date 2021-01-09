package com.example.expandablelistview

import java.util.*
internal object ExpandableListData {
    val data: HashMap<String, List<String>>
        get() {
            val expandableListDetail =
                HashMap<String, List<String>>()
            val myFavSeries: MutableList<String> =
                ArrayList()
            myFavSeries.add("CSI Cyber")
            myFavSeries.add("Black List")
            myFavSeries.add("Silicon Valley")

            val myFavHobbies: MutableList<String> = ArrayList()
            myFavHobbies.add("Table Tennis")
            myFavHobbies.add("FIFA")
            myFavHobbies.add("Chess")

            val myFavSongs: MutableList<String> = ArrayList()
            myFavSongs.add("Juice Wrld - Robbery")
            myFavSongs.add("Juice Wrld - Wishing well")
            myFavSongs.add("Juice Wrld - Fast")

            expandableListDetail["SERIES"] = myFavSeries
            expandableListDetail["HOBBIES"] = myFavHobbies
            expandableListDetail["SONGS"] = myFavSongs
            return expandableListDetail
        }
}