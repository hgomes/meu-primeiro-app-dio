package br.com.igorbag.meuprimeiroappdio.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.igorbag.meuprimeiroappdio.R

class CalcularAutonomiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Cheguei aqui", "Com louvor")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular)
        Log.d("Chamando", "chamado")
    }
}