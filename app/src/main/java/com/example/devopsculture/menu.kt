package com.example.devopsculture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setSupportActionBar(findViewById(R.id.toolbar))

    }

    fun toastterraform(view: View) {
        Toast.makeText(this, "Terraform", Toast.LENGTH_SHORT).show()
    }

    fun oracleCard(view: View) {
        val intent = Intent(this, oracle::class.java)
        startActivity(intent)
    }

    fun grafanaCard(view: View) {
        val intent = Intent(this, tela_grafana::class.java)
        startActivity(intent)
    }

    fun ansibleCard(view: View) {
        val intent = Intent(this, ansible::class.java)
        startActivity(intent)
    }

    fun dockerCard(view: View) {
        val intent = Intent(this, docker::class.java)
        startActivity(intent)
    }

    fun githubCard(view: View) {
        val intent = Intent(this, github::class.java)
        startActivity(intent)
    }

    fun rundeckCard(view: View) {
        val intent = Intent(this, rundeck::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.bars -> {
                val intent = Intent(this, settings::class.java)
                startActivity(intent)
                return true
            }
            R.id.notification -> {
                Toast.makeText(this, "NOTIFICAÇÃO ATIVADA!", Toast.LENGTH_LONG).show()
            }
            R.id.botaoAcao2 -> {
                exibirModal()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun exibirModal() {
        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
        builder.setTitle("Configurações do perfil")
        builder.setMessage("Olá! Aqui você pode personalizar suas configurações de perfil conforme suas preferências.")

        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.perfil)

        val closeButton = Button(this)
        closeButton.text = "Fechar"

        val dialog = builder.create()

        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        val buttonLayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        buttonLayoutParams.gravity = Gravity.END or Gravity.BOTTOM
        closeButton.layoutParams = buttonLayoutParams

        val contentLayout = LinearLayout(this)
        contentLayout.orientation = LinearLayout.VERTICAL
        contentLayout.addView(imageView)
        contentLayout.addView(closeButton)

        dialog.setView(contentLayout)

        dialog.show()
    }



}