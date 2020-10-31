package com.example.quizapp.test_util

object RegistrationUtil {
    private val userList= listOf("sajjad","mamad","ali","ehsan")
    fun validRegister(
        userName:String,password:String,confirmedPassword:String
    ):Boolean{
        if (userName.isEmpty()||password.isEmpty()){
            return false
        }
        if (userName in userList){
            return false
        }
        if (confirmedPassword != password){
            return false
        }
        if (password.length<2){
            return false
        }
        return true
    }



}