package com.example.devopsculture

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val configuracoes = arrayOf("Permissões", "Ajuda", "Termos e serviços", "sobre", "Gerenciar contas")
        val lista = findViewById<ListView>(R.id.listView)
        val adapter = CustomAdapter(this, configuracoes)
        lista.adapter = adapter
    }

    fun voltarMenu(view: View) {
        val intent = Intent(this, menu::class.java)
        startActivity(intent)
    }
}
