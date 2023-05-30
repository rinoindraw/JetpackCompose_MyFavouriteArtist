package com.rinoindraw.myfavouriteartistcompose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rinoindraw.myfavouriteartistcompose.data.ArtistRepository
import com.rinoindraw.myfavouriteartistcompose.model.Artist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyFavouriteArtistViewModel(private val repository: ArtistRepository) : ViewModel() {
    private val _groupedArtist = MutableStateFlow(
        repository.getArtist()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedArtist: StateFlow<Map<Char, List<Artist>>> get() = _groupedArtist

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedArtist.value = repository.searchArtist(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }

}

class ViewModelFactory(private val repository: ArtistRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyFavouriteArtistViewModel::class.java)) {
            return MyFavouriteArtistViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}