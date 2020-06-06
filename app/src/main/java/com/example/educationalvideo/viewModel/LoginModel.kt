package com.example.educationalvideo.viewModel

/**
 * @author cui
 * @data 2020/5/26
 * Description:
 */
class LoginModel (userName: String,userPassword: String){
    var userName:String=userName
    var userPassword:String=userPassword
    override fun toString(): String {
        return "LoginModel(userName='$userName', userPassword='$userPassword')"
    }

}