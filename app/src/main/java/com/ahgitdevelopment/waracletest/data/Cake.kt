package com.ahgitdevelopment.waracletest.data

data class Cake(val title: String, val desc: String, val image: String) {

    companion object {

        /**
         * This method transforms network data layer into business data layer. It is important to keep
         * this separation to avoid future problem in business layer due to modifications in network data.
         */
        fun parseSchemeToBusinessData(cakeSchemeList: ArrayList<CakeScheme>): ArrayList<Cake> {
            val cakeList = ArrayList<Cake>()

            for (cakeScheme in cakeSchemeList) {
                cakeList.add(
                    Cake(
                        title = cakeScheme.title,
                        desc = cakeScheme.desc,
                        image = cakeScheme.image
                    )
                )
            }
            return cakeList
        }
    }
}