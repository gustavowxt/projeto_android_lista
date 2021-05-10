package com.mobway.minhaprimeiralista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobway.minhaprimeiralista.model.Pessoa

class MainActivity : AppCompatActivity(), ItemClickListener {

    var recyclerView: RecyclerView? = null
    lateinit var meuArrayDeAnimais: ArrayList<Pessoa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarElementos()
        carregarArray()


        /**
         * Necessário passar um adapter para o RecyclerView trabalhar
         * Adapter é o responsável por manipulação do layout x dados
         */
        AdapterRecyclerView(this, meuArrayDeAnimais, this).let {
            recyclerView?.adapter = it
        }

        /**
         * Forma mais fácil de fazer o on click
         *
         * (Não esta sendo usado no momento)
         */
        val adapter = AdapterFacilRecyclerView(this, meuArrayDeAnimais) {
            Toast.makeText(this, it.nome, Toast.LENGTH_SHORT).show()
        }



        /**
         * Necessário passar um LayoutManager para o RecyclerView trabalhar
         * LayoutManager é o responsável por dar uma orientação ao scroll e forma que o
         * RecyclerView irá trabalhar (e.x LinearLayoutManager, GridLayoutManager)
         */
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Carrega o elemento RecyclerView da tela para o Kotlin
     */
    fun carregarElementos() {
        recyclerView = findViewById(R.id.rv_produtos)
    }

    /**
     * Carrega o nosso array
     */
    fun carregarArray() {
        meuArrayDeAnimais = ArrayList()
        meuArrayDeAnimais.add(Pessoa("Arthur", 34, R.drawable.ic_android_black_24dp))
        meuArrayDeAnimais.add(Pessoa("Pedro", 2, R.drawable.ic_baseline_flight_24))
        meuArrayDeAnimais.add(Pessoa("Joaquim", 3, R.drawable.ic_baseline_accessibility_24))
    }

    override fun onClickItem(view: View?, index: Int) {
        val intent = Intent(this, DetalhesActivity::class.java)
        intent.putExtra("parametro_nome", meuArrayDeAnimais[index].nome)
        intent.putExtra("parametro_objeto", meuArrayDeAnimais[index])
        startActivity(intent)
    }


}