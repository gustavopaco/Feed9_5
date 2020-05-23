package br.com.cotemig.feed9_5.services

import br.com.cotemig.feed9_5.models.Feed
import retrofit2.Call
import retrofit2.http.GET

interface FeedService {

    @GET ("feed/")
    fun getFeed() : Call<List<Feed>>

}