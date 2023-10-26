package com.magre.compose.navigation.example.data.mapper

interface BaseMapper<U, M> {

    fun map(unmappedList: List<U>): List<M> = unmappedList.map { map(it) }

    fun map(unmapped: U): M
}
