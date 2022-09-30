package com.rezoo.myapp47mvc.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBAdapter(context: Context) {
    var myDBHelper:MyDBHelper
    init {
        myDBHelper=MyDBHelper(context)
    }
    fun Getdata(email:String,password:String):String{
        val DB: SQLiteDatabase =myDBHelper.writableDatabase
        val select:String="select * from Login where Email='"+email+"' and Password='"+password+"'"
        val cursor: Cursor =DB.rawQuery(select,null)
        if (cursor.moveToNext()){
            return "true"
        }else{
            return "false"
        }

    }
    fun Getdataa():String{
        val DB:SQLiteDatabase=myDBHelper.writableDatabase
        val select:String="select * from Goods"
        val cursor:Cursor=DB.rawQuery(select,null)
        val buffer:StringBuffer=StringBuffer()
        while (cursor.moveToNext()){
            val Id :Int=cursor.getInt(0)
            val name :Int=cursor.getInt(1)
            val availble :Int=cursor.getInt(2)
            val buyprice :Int=cursor.getInt(3)
            val sellprice :Int=cursor.getInt(4)

            buffer.append(Id.toString()+name+" "+availble+" "+buyprice+" "+sellprice+" "+"\n"  )
        }
        return buffer.toString()
    }
    fun insertdata(id:Int,name:String,available:String,buyprice:String,sellprice:String):Long{
        val DB:SQLiteDatabase=myDBHelper.writableDatabase
        val value: ContentValues = ContentValues()
        value.put("Id",id)
        value.put("Name",name)
        value.put("Available",available)
        value.put("BuyPrice",buyprice)
        value.put("SellPrice",sellprice)
        val status=DB.insert("Goods",null,value)
        return status

    }








    class MyDBHelper(context: Context):
        SQLiteOpenHelper(context,"MyDataBase47MVC",null,1) {
        val context: Context
        init {
            this.context=context
        }

        override fun onCreate(DB: SQLiteDatabase?) {
            val createTable:String="create table Goods (Id Int primary key," +
                    "Name varchar(45),Available varchar(45),BuyPrice varchar(45),SellPrice varchar(45))"
            DB?.execSQL(createTable)
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("Not yet implemented")
        }

    }
}