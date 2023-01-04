package me.s097t0r1.ktcast.data.profile.impl.model.remote.mapper

import java.time.Instant
import java.time.ZoneId
import me.s097t0r1.ktcast.data.profile.api.model.Profile
import me.s097t0r1.ktcast.data.profile.impl.model.remote.RemoteProfile
import me.s097t0r1.ktcast.libraries.mapper.Mapper

class ProfileRToDMapper : Mapper<RemoteProfile, Profile> {

    private val zone = ZoneId.systemDefault()

    override fun map(input: RemoteProfile): Profile {
        return Profile(
            avatarUrl = input.avatarUrl,
            fullName = input.fullName,
            nickname = input.nickname,
            birthday = Instant.ofEpochMilli(input.birthday).atZone(zone).toLocalDate(),
            email = input.email
        )
    }
}

class ProfileDToRMapper : Mapper<Profile, RemoteProfile> {

    override fun map(input: Profile): RemoteProfile {
        return RemoteProfile(
            avatarUrl = input.avatarUrl,
            fullName = input.fullName,
            nickname = input.nickname,
            birthday = Instant.from(input.birthday).toEpochMilli(),
            email = input.email
        )
    }
}