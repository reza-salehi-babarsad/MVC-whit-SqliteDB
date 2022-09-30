package com.rezoo.myapp47mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.rezoo.myapp47mvc.Controller.GoodController
import com.rezoo.myapp47mvc.DataBase.MyDBAdapter
import com.rezoo.myapp47mvc.View.IgoodView

class MainActivity : AppCompatActivity(),IgoodView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn:Button=findViewById(R.id.button)
        var editTextid:EditText=findViewById(R.id.editTextTextid)
        var editTextname:EditText=findViewById(R.id.editTextname)
        var editTexavailable:EditText=findViewById(R.id.editavailable)
        var editTextbuyprice:EditText=findViewById(R.id.editbuyprice)
        var editTextsellprice:EditText=findViewById(R.id.editTextTextsellprice)
        var btninsert:Button=findViewById(R.id.buttoninsert)
        val goodController=GoodController(this,this)
        btn.setOnClickListener {
            goodController.showinformation()


        }
        btninsert.setOnClickListener {
            goodController.insertData(editTextid.text.toString().toInt(),editTextname.text.toString(),editTexavailable.text.toString(),editTextbuyprice.text.toString(),editTextsellprice.text.toString())
        }
    }

    override fun showinfo(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}