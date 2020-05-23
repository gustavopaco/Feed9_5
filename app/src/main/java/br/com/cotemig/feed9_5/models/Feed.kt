package br.com.cotemig.feed9_5.models

data class Feed(
    var date : String = "",
    var image : String = "",
    var avatar : String = "",
    var likes : List<String>,
    var gallery : List<Gallery>

)