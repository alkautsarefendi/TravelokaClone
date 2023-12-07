package com.example.travelokaclone.presentation.ui.fragments.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.travelokaclone.data.DataSource
import com.example.travelokaclone.model.Menu

class MenuViewModel : ViewModel(){
    private val dataSource = DataSource
    val listMenuFirst: LiveData<List<Menu>> = dataSource.listMenuFirst.asLiveData()
    val listMenuSecond: LiveData<List<Menu>> = dataSource.listMenuSecond.asLiveData()
}