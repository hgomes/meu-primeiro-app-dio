package br.com.igorbag.meuprimeiroappdio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.meuprimeiroappdio.adapter.CarAdapter
import br.com.igorbag.meuprimeiroappdio.data.CarFactory

class MainActivity : AppCompatActivity() {
    lateinit var preco: EditText
    lateinit var kmPercorrido: EditText
    lateinit var btnCalcular: Button
    lateinit var radioGroup: RadioGroup
    lateinit var checkBox1: CheckBox
    lateinit var checkBox2: CheckBox
    lateinit var resultado: TextView
    lateinit var lista: RecyclerView
    lateinit var btnRedirect: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListenner()
        setupList()
    }
    fun setupViews() {
        //btnCalcular = findViewById(R.id.btn_calcular)
        btnCalcular = findViewById(R.id.btn_calcular)
        lista = findViewById(R.id.lv_car)
    }
    fun setupList() {

         val adapter = CarAdapter(CarFactory.list)
         lista.adapter = adapter
    }
    fun setupListenner() {
       btnCalcular.setOnClickListener {
          startActivity(Intent(this, CalcularAutonomiaActivity::class.java))
      }
    }
}