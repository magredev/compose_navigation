package com.magre.compose.navigation.example.ui.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        _homeState.value = HomeState(value = "Hello!")
    }

    fun onButtonClick() {
        _homeState.update { currentState ->
            currentState.copy(value = "Bye!")

        }
    }
}

data class HomeState(
    val value: String = ""
)
