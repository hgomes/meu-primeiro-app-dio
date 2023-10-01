package br.com.igorbag.meuprimeiroappdio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.meuprimeiroappdio.R
import br.com.igorbag.meuprimeiroappdio.presentation.Car

class CarAdapter(private val cars : List<Car>): RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.preco.text = cars[position].preco
        holder.potencia.text = cars[position].potencia
        holder.bateria.text = cars[position].bateria
        holder.recarga.text = cars[position].recarga

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val preco : TextView
        val potencia : TextView
        val bateria: TextView
        val recarga: TextView

        init {
            view.apply {
                preco = findViewById(R.id.tv_preco_valor)
                potencia = findViewById(R.id.tv_potencia_valor)
                bateria = findViewById(R.id.tv_bateria_valor)
                recarga= findViewById(R.id.tv_recarga_valor)
            }
        }
    }
}