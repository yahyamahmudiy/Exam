package com.example.exam.Model

data class Member(var profile:Int,var name:String) {
    override fun toString(): String {
        return "Member(name='$name', profile=${profile.toString()})"
    }
}