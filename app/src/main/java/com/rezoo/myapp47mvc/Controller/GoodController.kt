package com.rezoo.myapp47mvc.Controller

import android.content.Context
import android.widget.Toast
import com.rezoo.myapp47mvc.Model.Goods
import com.rezoo.myapp47mvc.Model.Igoods
import com.rezoo.myapp47mvc.View.IgoodView

class GoodController(private val igoodview:IgoodView,private val context: Context):IgoodsController {
    override fun showinformation() {
        val goods=Goods( context )
        val info=goods.getinformation()
        igoodview.showinfo(info)
    }

    override fun insertData(Id:Int,Name:String,Available:String,BuyPrice:String,SellPrice:String) {
        val goods=Goods(context)
        val data=goods.insertinformation(Id,Name,Available,BuyPrice,SellPrice)
        if (data<0){
            igoodview.showinfo("insert unsuccessful")
        }else{
            igoodview.showinfo("insert successful")
        }
    }
}