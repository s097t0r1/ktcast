package me.s097t0r1.ktcast.data.profile.impl.model.local.mapper

import java.time.Instant
import java.time.ZoneId
import me.s097t0r1.ktcast.data.profile.api.model.Profile
import me.s097t0r1.ktcast.data.profile.impl.model.local.LocalProfile
import me.s097t0r1.ktcast.libraries.mapper.Mapper

class ProfileLToDMapper : Mapper<LocalProfile, Profile> {

    private val zone = ZoneId.systemDefault()

    override fun map(input: LocalProfile): Profile {
        return Profile(
            avatarUrl = input.avatarUrl,
            fullName = input.fullName,
            nickname = input.nickname,
            birthday = Instant.ofEpochMilli(input.birthday).atZone(zone).toLocalDate(),
            email = input.email
        )
    }
}

class ProfileDToLMapper : Mapper<Profile, LocalProfile> {

    override fun map(input: Profile): LocalProfile {
        return LocalProfile(
            avatarUrl = input.avatarUrl,
            fullName = input.fullName,
            nickname = input.nickname,
            birthday = Instant.from(input.birthday).toEpochMilli(),
            email = input.email
        )
    }
}
