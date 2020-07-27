# TodoList-android
Incredibly Mediocre Android App - TodoList

# About this project
It's an Android "to-do list" application built for my course assignment - Mobile App Development course.( Spring term 2020 )
Mainly record the to-do items, including the title, brief description and the time of the to-do. The interface is really simple and focused from work to play.

# Features
* Add, remove and update ToDo lists.
* Add details to each task.
* Use SQLite to store data.
* Use RecyclerView to display a scrolling list of to-do items from database.

# Reference
🔗: https://github.com/anggarisky/DoesApp
Refer to a project doesapp on GitHub. 
The project also uses RecyclerView to display. 
However, due to some reasons, we can't use firebase, a more efficient real-time database, so we don't need to write back-end code to make complex tasks simple. 
SQLite is used here, which is also feasible.

# What I learned
Through this course assignment, I have a deeper understanding of Android development, and found the power of Android widgets, and also further understand the Android life cycle.  
Before, I didn't pay attention to the life cycle. When I write an activity and return to the previous activity, 
I can easily rewrite the onresume method according to the Android life cycle instead using other way to solve this.   
About the RecyclerView widget, which let me have a new understanding of the adapter, 
which serves as a bridge between data and UI, connecting the  data with the front-end UI, which is a carrier for displaying data.    
A lot of times, when checking the error log, 
there is a problem of null pointer.    
To sum up, the possible errors lie in that the ID defined in the XML file does not match correctly (sometimes multiple names disturb the eyes),
or the code (object, instance, etc.) is not initialized, 
and the corresponding practice does not set monitoring.      
This null pointer error is very common, but compilation Error reporting templates are similar. 
Through a project on this course practice is the most effective, 
but also the most fruitful, 
let me learn a lot, pay attention to the unimportant sides and details.    
Although this app is not perfect, but the most basic functions have been achieved, 
and the gain is the most important. 

 
