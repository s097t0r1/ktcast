package me.s097t0r1.persistence.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class StubEntity(
    @PrimaryKey
    val id: Int
)