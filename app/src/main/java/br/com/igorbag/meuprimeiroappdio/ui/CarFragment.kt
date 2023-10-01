package br.com.igorbag.meuprimeiroappdio.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.meuprimeiroappdio.CalcularAutonomiaActivity
import br.com.igorbag.meuprimeiroappdio.R
import br.com.igorbag.meuprimeiroappdio.adapter.CarAdapter
import br.com.igorbag.meuprimeiroappdio.data.CarFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class CarFragment : Fragment() {

    lateinit var fabCalcular: FloatingActionButton
    lateinit var listaCarros: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Debugando", "Dentro do onCreateView CarFragment")
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Debugando", "Dentro do onCreateView CarFragment")

        setupView(view)
        setupList()
        setupListeners()
    }

    fun setupView(view: View) {
        view.apply {
            fabCalcular = findViewById(R.id.fab_calcular)
            listaCarros = findViewById(R.id.rv_lista_carros)
        }
    }

    fun setupList() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }

    fun setupListeners() {
        Log.d("Debugando", "setupListeners esta sendo chamado")
        //fabCalcular.setOnClickListener {
            MyTask().execute("http://igorbag.github.io/cars-api/cars.json")
            //startActivity(Intent(context, CalcularAutonomiaActivity::class.java))
       // }
    }

    inner class MyTask: AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            Log.d("Debugando", "onPreExecute esta sendo chamado")
        }

        override fun onProgressUpdate(vararg values: String?) {
            try {
                Log.d("Debugando", "onProgressUpdate esta sendo chamado")
                val jsonArray = JSONTokener(values[0]).nextValue() as JSONArray

                for(i in 0 until jsonArray.length()) {
                    val id = jsonArray.getJSONObject(i).getString("id");
                    Log.d("Debugando ", id.toString())
                }

            } catch (e: Exception) {

            }
        }
        override fun doInBackground(vararg url: String?): String {
            var urlConnection : HttpURLConnection? = null
            Log.d("Debugando", "doInBackground esta sendo chamado")
            try {

                val urlBase = URL(url[0])

                Log.d("Debugando", "doInBackground esta sendo chamado 1")

                urlConnection = urlBase.openConnection() as HttpURLConnection

                Log.d("Debugando", "doInBackground esta sendo chamado 2")

                urlConnection.connectTimeout = 60000

                Log.d("Debugando", "doInBackground esta sendo chamado 3")

                urlConnection.connectTimeout = 60000

                Log.d("Debugando", "doInBackground esta sendo chamado 4")

                var inString = urlConnection.inputStream.bufferedReader().use {

                    Log.d("Debugando", "doInBackground esta sendo chamado 5")

                    it.readText().toString()

                }

                Log.d("Debugando", inString)

                publishProgress(inString)
            } catch (e: Exception) {
                Log.e("Debugando", "Erro ao realiazar processamento" + e.message)
            } finally {
                urlConnection?.let {
                    urlConnection.disconnect()
                }
            }

            return ""
        }
    }
}