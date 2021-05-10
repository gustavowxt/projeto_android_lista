package com.mobway.minhaprimeiralista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mobway.minhaprimeiralista.model.Pessoa

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val nossoNomeEnviadoPorParametro = intent.getStringExtra("parametro_nome")
        val nossoObjetoPessoa : Pessoa = intent.getSerializableExtra("parametro_objeto") as Pessoa

        val textViewTitle = findViewById<TextView>(R.id.textView_titulo)

        textViewTitle.text = "${nossoObjetoPessoa.nome} - ${nossoObjetoPessoa.idade}"
    }
}