package br.com.cotemig.feed9_5.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.feed9_5.R
import br.com.cotemig.feed9_5.models.Feed
import br.com.cotemig.feed9_5.services.RetrofitInitializer
import br.com.cotemig.feed9_5.ui.adapters.FeedAdapter
import kotlinx.android.synthetic.main.activity_feed.*
import retrofit2.Call
import retrofit2.Response

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        getFeed()

    }

    fun getFeed(){

        var s = RetrofitInitializer().serviceFeed()
        var call = s.getFeed()
        call.enqueue(object : retrofit2.Callback<List<Feed>>{

            override fun onResponse(call: Call<List<Feed>>?, response: Response<List<Feed>>?) {
                response?.let {
                    if (it.code() == 200){
                        listafeed.adapter = FeedAdapter(this@FeedActivity,it.body())

                        Toast.makeText(this@FeedActivity,"Ok",Toast.LENGTH_LONG).show()
                    }
                }


            }

            override fun onFailure(call: Call<List<Feed>>?, t: Throwable?) {
                Toast.makeText(this@FeedActivity,"Error",Toast.LENGTH_LONG).show()
            }


        })

    }

}
