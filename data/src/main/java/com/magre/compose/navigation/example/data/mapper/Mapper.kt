package com.magre.compose.navigation.example.data.mapper

abstract class Mapper<U, M> : BaseMapper<U, M> {

    override fun map(unmappedList: List<U>): List<M> = unmappedList.map { map(it) }
}
