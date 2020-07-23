package com.aungpyaesone.firebasetest.customviewassignment.data.dummy

import com.aungpyaesone.firebasetest.customviewassignment.data.vos.TaskVO

fun getDummyTask():List<TaskVO>{
    val taskOne = TaskVO("Contact Page","In Progress","#Design",3,5,"N 163")
    val taskTwo = TaskVO("Calculator Page","Done","#Design",8,2,"N 158")
    val taskThree = TaskVO ("Technical Task","Review","Fronted",4,8,"N 157")

    return arrayListOf(taskOne,taskTwo,taskThree)
}