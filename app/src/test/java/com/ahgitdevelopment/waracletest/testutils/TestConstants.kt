package com.ahgitdevelopment.waracletest.testutils

import com.ahgitdevelopment.waracletest.data.Cake
import com.ahgitdevelopment.waracletest.data.CakeScheme

val COMPLETE_LIST = ArrayList<CakeScheme>().apply {
    add(CakeScheme(title = "title1", desc = "desc1", image = "image1"))
    add(CakeScheme(title = "title3", desc = "desc3", image = "image3"))
    add(CakeScheme(title = "title1", desc = "desc1", image = "image1"))
    add(CakeScheme(title = "title2", desc = "desc2", image = "image2"))
    add(CakeScheme(title = "title3", desc = "desc3", image = "image3"))
    add(CakeScheme(title = "title3", desc = "desc3", image = "image3"))
    add(CakeScheme(title = "title2", desc = "desc2", image = "image2"))
    add(CakeScheme(title = "title2", desc = "desc2", image = "image2"))
    add(CakeScheme(title = "title3", desc = "desc3", image = "image3"))
    add(CakeScheme(title = "title3", desc = "desc3", image = "image3"))
    add(CakeScheme(title = "title3", desc = "desc3", image = "image3"))
    add(CakeScheme(title = "title1", desc = "desc1", image = "image1"))
    add(CakeScheme(title = "title3", desc = "desc3", image = "image3"))
}

val LIST_WITHOUT_DUPLICATES = ArrayList<Cake>().apply {
    add(Cake(title = "title1", desc = "desc1", image = "image1"))
    add(Cake(title = "title3", desc = "desc3", image = "image3"))
    add(Cake(title = "title2", desc = "desc2", image = "image2"))
}

val LIST_WITHOUT_DUPLICATES_AND_SORTED = ArrayList<Cake>().apply {
    add(Cake(title = "title1", desc = "desc1", image = "image1"))
    add(Cake(title = "title2", desc = "desc2", image = "image2"))
    add(Cake(title = "title3", desc = "desc3", image = "image3"))
}