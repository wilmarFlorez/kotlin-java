package com.wilmarflorez.javaykotlin

import android.content.SharedPreferences

fun SharedPreferences.edit(func:SharedPreferences.Editor.()-> Unit ){
    val editor = edit()
    editor.func()
    editor.apply()
}