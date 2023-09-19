package br.com.igorbag.meuprimeiroappdio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.TextView
import br.com.igorbag.meuprimeiroappdio.presentation.CalcularAutonomiaActivity

class MainActivity : AppCompatActivity() {

    lateinit var preco: EditText
    lateinit var kmPercorrido: EditText
    lateinit var btnCalcular: Button
    lateinit var radioGroup: RadioGroup
    lateinit var checkBox1: CheckBox
    lateinit var checkBox2: CheckBox
    lateinit var resultado: TextView
    lateinit var lista: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListenner()
        setupList()
    }
    fun setupViews() {
        btnCalcular = findViewById(R.id.btn_calcular)
        lista = findViewById(R.id.lv_car)
    }

    fun setupList() {
        var dados = arrayOf("Cupckake", "Donut", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados)
        lista.adapter = adapter
    }
    fun setupListenner() {
        btnCalcular = findViewById<Button>(R.id.btn_calcular)
        Log.d("Botão", "antes")
        btnCalcular.setOnClickListener {
            Log.d("Botão", "depois")
            startActivity(Intent(this, CalcularAutonomiaActivity::class.java))
        }
    }
}