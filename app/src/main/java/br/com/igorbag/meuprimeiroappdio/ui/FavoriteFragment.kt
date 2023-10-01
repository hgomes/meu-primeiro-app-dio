package br.com.igorbag.meuprimeiroappdio.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.igorbag.meuprimeiroappdio.R

class FavoriteFragment :  Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("Debugando", "ONCREATEVIEW FAVORITO")

        return inflater.inflate(R.layout.favorite_fragment,container,false)
    }
}