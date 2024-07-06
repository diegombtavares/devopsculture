package com.example.devopsculture

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(private val context: Context, private val dataSource: Array<String>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_with_icon, parent, false)

        val textView = rowView.findViewById<TextView>(R.id.text)
        val imageView = rowView.findViewById<ImageView>(R.id.icon)

        val item = getItem(position) as String
        textView.text = item

        when (item) {
            "Permissões" -> imageView.setImageResource(R.drawable.permissoes)
            "Ajuda" -> imageView.setImageResource(R.drawable.ajuda)
            "Termos e serviços" -> imageView.setImageResource(R.drawable.termos)
            "sobre" -> imageView.setImageResource(R.drawable.info)
            "Gerenciar contas" -> imageView.setImageResource(R.drawable.contas)
            else -> imageView.setImageResource(R.drawable.ic_launcher_foreground)
        }

        return rowView
    }
}
