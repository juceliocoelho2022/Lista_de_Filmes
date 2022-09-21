package com.jucelio.listadefilmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.jucelio.listadefilmes.adapter.AdapterFilme
import com.jucelio.listadefilmes.databinding.ActivityListasFilmesBinding
import com.jucelio.listadefilmes.model.Filme

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityListasFilmesBinding
    private lateinit var adapterFilme: AdapterFilme
    private val listasFilmes: MutableList<Filme> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListasFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

       supportActionBar!!.hide ()

        val recyclerViewFilmes = binding.recyclerViewFilmes
        recyclerViewFilmes.layoutManager = GridLayoutManager(this,4)
        recyclerViewFilmes.setHasFixedSize(true)
        adapterFilme = AdapterFilme(this,listasFilmes)
        recyclerViewFilmes.adapter = adapterFilme
        getFilmes()

    }

    private fun getFilmes(){
        val filme1 = Filme(R.drawable.filme1,"Tor Amor e Trovão")
        listasFilmes.add(filme1)

        val filme2 = Filme(R.drawable.filme2,"Sonic O Filme")
        listasFilmes.add(filme2)

        val filme3 = Filme(R.drawable.filme3,"Coringa")
        listasFilmes.add(filme3)

        val filme4 = Filme(R.drawable.filme4,"Meu Malvado Favorito 3")
        listasFilmes.add(filme4)

        val filme5 = Filme(R.drawable.filme5,"Homem-Aranha Sem Volta Para Casa")
        listasFilmes.add(filme5)

        val filme6 = Filme(R.drawable.filme6,"O Contador")
        listasFilmes.add(filme6)

        val filme7 = Filme(R.drawable.filme7,"Velozes E Furiosos 8")
        listasFilmes.add(filme7)

        val filme8 = Filme(R.drawable.filme8,"Pixels O Filme")
        listasFilmes.add(filme8)
    }
}