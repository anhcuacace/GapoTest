package com.tunanh.gapotest.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GapoViewModel(application: Application) : ViewModel() {

    class GapoViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GapoViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GapoViewModel(application) as T
            }

            throw IllegalArgumentException("Unable construct viewModel")
        }

    }
}