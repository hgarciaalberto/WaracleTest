# Cake App

I have spent a little more time due to the fact that I wanted to implement several features that are considered very important nowadays. Commits have been bare and plain so I would like to explain what I've done here in detail:

#### 1. Dependency Injection

A basic architecture using **Dagger** was the first step. Due to the application size and complexity, it wasn't needed to implement subcomponents but I kept different logic separated using modules.

#### 2. Network communication

Secondly, I've used **Retrofit** as well as **Coroutines** to retrieve data Cakes. In addition, I've separate data structure retrieved from network `CakeScheme` and data from business logic inside the app `Cake`. In bigger project, this separation is fundamental in order to avoid future problems.

#### 3. Design-Patter MVVM

To continue, I've implemented **MVVM (Model-View-ViewModel)** design pattern and I've also used a `ReciclerView` Adapter with `CardView` component to show the data instead of a basic `ListView`.
At this point I've use **DataBinding** not only to manage the UI components but also in `Viewholder` inside the **ReciclerView** too. This could be a bit tricky but it's very handy.
Furthermore, images have been displayed using **Glide** library and using also `@BindingAdapter("imageUrlAdapter")` to link the xml tag `app:imageUrlAdapter="@{modelCake.image}"`

#### 4. Several improvements

After finishing the hardest staffs, I focussed on small features like:

- Menu item in `MainActivity` to **refresh the cake list**
- Added `DialogFragment` to show item details. In order to use **animations**, I've done two of them: `fade in/out`  and `slide button/up` . Them show up randomly when clicking the items in the `RecyclerView`.
- Show a `Snackbar` with an error message when the list cannot be loaded. It also allows the user to refresh the list.
- **Remove duplicates** entries and **sort** them. In this case I use an **extension function** in charge of processing the list when it is retrieved: `fun <T> ArrayList<T>.processList(){...}` 

#### 5. Testing

I've create both test, `Unit Test` and `Instrumental Test`. I've achieve 100% of coverage in the `ViewModel` class which has the main logic. It only has the method to retrieve data from service.

#### 6. Libraries

- retrofit 
- coroutines 
- glide 
- mockito 
- espresso
- truth
