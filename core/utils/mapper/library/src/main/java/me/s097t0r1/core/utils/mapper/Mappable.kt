package me.s097t0r1.core.utils.mapper

sealed interface Mappable

interface DTO : Mappable

interface DomainModel : Mappable