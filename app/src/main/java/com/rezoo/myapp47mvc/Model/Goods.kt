package com.rezoo.myapp47mvc.Model

import android.content.Context
import com.rezoo.myapp47mvc.DataBase.MyDBAdapter

class Goods(private val context: Context):Igoods {
    private val name:String
        get() {
            return name
        }
    private val availble:String
        get() {
            return availble
        }
    private val buyprice:String
        get() {
           return buyprice
        }
    private val sellprice:String
        get() {
            return sellprice
        }

    override fun getinformation(): String {
        val myDBAdapter=MyDBAdapter(context)
        return myDBAdapter.Getdataa()
    }

    override fun insertinformation(
        Id: Int,
        Name: String,
        Available: String,
        BuyPrice: String,
        SellPrice: String
    ): Long {
        val myDBAdapter=MyDBAdapter(context)
        return myDBAdapter.insertdata(Id,Name,Available,BuyPrice,SellPrice)
    }
}