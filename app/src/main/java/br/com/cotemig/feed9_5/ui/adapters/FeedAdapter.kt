package br.com.cotemig.feed9_5.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.feed9_5.R
import br.com.cotemig.feed9_5.models.Feed
import com.bumptech.glide.Glide

class FeedAdapter (var context: Context, var list : List<Feed>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_feed,null)

        var avatar = view.findViewById<ImageView>(R.id.avatar)
        var image = view.findViewById<ImageView>(R.id.image)

        var date = view.findViewById<TextView>(R.id.date)
        date.text = list[position].date


        var likes =  view.findViewById<TextView>(R.id.likes)
        for (i in list[position].likes){
            likes.text = likes.text.toString().plus("\n").plus(i)
        }




        Glide.with(context).load(list[position].avatar).into(avatar)
        Glide.with(context).load(list[position].image).into(image)


        return view
    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getCount(): Int {
        return list.size
    }
}