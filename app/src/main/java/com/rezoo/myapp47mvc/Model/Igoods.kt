package com.rezoo.myapp47mvc.Model

interface Igoods {
    fun getinformation():String
    fun insertinformation(Id:Int,Name:String,Available:String,BuyPrice:String,SellPrice:String):Long
}