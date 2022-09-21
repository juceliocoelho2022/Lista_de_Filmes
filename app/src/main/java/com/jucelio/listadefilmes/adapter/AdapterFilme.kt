package com.jucelio.listadefilmes.adapter

import android.content.Context
import android.graphics.Color
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jucelio.listadefilmes.databinding.FilmeItemBinding
import com.jucelio.listadefilmes.model.Filme

class AdapterFilme
    (private val context: Context,
     private val listaFilmes: MutableList<Filme>):
    RecyclerView.Adapter<AdapterFilme.FilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
       val itemLista = FilmeItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return  FilmeViewHolder(itemLista)
       }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {

        holder.capaFilme.setImageResource(listaFilmes[position].capa!!)
        holder.tituloFilme.text = listaFilmes[position].titulo
        
        holder.itemView.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                holder.itemSelecionado.setBackgroundColor(Color.parseColor("#ffffff"))
            }else{
                holder.itemSelecionado.setBackgroundColor(Color.parseColor("#000000"))
            }

        }
        holder.itemView.setOnKeyListener { v, keyCode, event ->
            val tituloFilme = listaFilmes[position]

            if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
                holder.itemSelecionado.setBackgroundColor(Color.parseColor("#FFEB3B"))
                Toast.makeText(context,"Filme: $tituloFilme", Toast.LENGTH_SHORT).show()
            }
            return@setOnKeyListener false
        }
    }

    override fun getItemCount() = listaFilmes.size

    inner class FilmeViewHolder(binding:FilmeItemBinding): RecyclerView.ViewHolder(binding.root) {
        val capaFilme = binding.capaFilme
        val tituloFilme = binding.tituloFilme
        val itemSelecionado = binding.itemSelecionado
      }
    }