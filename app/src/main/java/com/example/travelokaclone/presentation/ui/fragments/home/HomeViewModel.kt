package com.example.travelokaclone.presentation.ui.fragments.home

import androidx.lifecycle.*
import com.example.travelokaclone.data.DataSource
import com.example.travelokaclone.model.Cities
import com.example.travelokaclone.model.Hotel
import com.example.travelokaclone.model.Promo
import com.example.travelokaclone.utils.TimerFlow
import com.example.travelokaclone.utils.longToTime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val dataSource = DataSource

    val listPromoLandscape: LiveData<List<Int>> = dataSource.listPromoLandscape.asLiveData()

    val listHotel: LiveData<List<Hotel>> = dataSource.listHotel.asLiveData()

    val listPromo: LiveData<List<Promo>> =dataSource.listPromo.asLiveData()

    private val _time: MutableStateFlow<String> = MutableStateFlow("00:00:00")
    val time: LiveData<String> = _time.asLiveData()

    val searchQuery = MutableLiveData<Cities>()
    val listHotelByCities: LiveData<List<Hotel>>

    init {
        searchQuery.value = Cities.BALI
        listHotelByCities = Transformations.switchMap(searchQuery) { q ->
            dataSource.listHotelByCities(q).asLiveData()
        }
        setTimeCountDown()
    }

    private fun setTimeCountDown() {
        viewModelScope.launch {
            TimerFlow.create(14400000L, 1000L).collect {
                _time.value = it.longToTime()
            }
        }
    }
}