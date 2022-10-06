package me.s097t0r1.libraries.mapper

sealed interface Mappable

interface DTO : Mappable

interface DomainModel : Mappable