package me.s097t0r1.ktcast.libraries.mapper

sealed interface Mappable

interface DTO : Mappable

interface DomainModel : Mappable