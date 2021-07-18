package com.ahgitdevelopment.waracletest.data

data class Cake(val title: String, val desc: String, val image: String)


// TODO: That is not the best way to do that but I wanted to use extension function as part of the exercise
@Suppress("UNCHECKED_CAST")
fun <T> ArrayList<T>.processList() {

    // Remove duplicate item in list
    val aux = distinctBy { cakeScheme -> (cakeScheme as CakeScheme).title }

    this.run {
        // Update list
        clear()
        addAll(aux)

        //Sort list
        sortBy { cakeScheme -> (cakeScheme as CakeScheme).title }
    }
}

/**
 * This method transforms network data layer into business data layer. It is important to keep
 * this separation to avoid future problem in business layer due to modifications in network data.
 */
fun CakeScheme.toBusinessData() = Cake(
    title = this.title,
    desc = this.desc,
    image = this.image
)

