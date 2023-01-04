package me.s097t0r1.ktcast.feature.profile.impl.presentation.fill_your_profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import me.s097t0r1.core.ui_components.components.KtCastOutlinedTextField
import me.s097t0r1.core.ui_components.theme.KtCastTheme
import me.s097t0r1.ktcast.feature.profile.impl.R

@Composable
internal fun FillYourProfileScreen(
    state: FillYourProfileUIState,
    onEditClick: () -> Unit,
    onFullNameChange: (String) -> Unit,
    onNicknameChange: (String) -> Unit,
    onBirthdayChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        AvatarBlock(imagePath = "", onEditClick = onEditClick, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(24.dp))
        InputInformationBlock(
            profileFields = state.fieldsState,
            onFullNameChange = onFullNameChange,
            onNicknameChange = onNicknameChange,
            onEmailChange = onEmailChange,
            onBirthdayChange = onBirthdayChange
        )
    }
}

@Composable
internal fun InputInformationBlock(
    profileFields: ProfileFields,
    onFullNameChange: (String) -> Unit,
    onNicknameChange: (String) -> Unit,
    onBirthdayChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        KtCastOutlinedTextField(
            value = profileFields.fullNameField.value,
            onValueChange = onFullNameChange,
            isError = profileFields.fullNameField.isError,
            errorText = profileFields.fullNameField.errorMsg,
            placeholder = {
                Text(text = stringResource(id = R.string.profile_feat_full_name_placeholder))
            }
        )
        KtCastOutlinedTextField(
            value = profileFields.nicknameField.value,
            onValueChange = onNicknameChange,
            isError = profileFields.nicknameField.isError,
            errorText = profileFields.nicknameField.errorMsg,
            placeholder = {
                Text(text = stringResource(id = R.string.profile_feat_nickname_placeholder))
            }
        )
        KtCastOutlinedTextField(
            value = profileFields.birthDayField.value,
            onValueChange = onBirthdayChange,
            isError = profileFields.birthDayField.isError,
            errorText = profileFields.birthDayField.errorMsg,
            placeholder = {
                Text(text = stringResource(id = R.string.profile_feat_birthday_placeholder))
            }
        )
        KtCastOutlinedTextField(
            value = profileFields.emailField.value,
            onValueChange = onEmailChange,
            isError = profileFields.emailField.isError,
            errorText = profileFields.emailField.errorMsg,
            placeholder = {
                Text(text = stringResource(id = R.string.profile_feat_email_placeholder))
            }
        )
    }
}

@Composable
internal fun AvatarBlock(
    imagePath: String,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Image(
            painter = if(imagePath.isEmpty()) {
                painterResource(id = R.drawable.ic_profile_feat_avatar_placeholder)
            } else {
                rememberAsyncImagePainter(model = imagePath)
            },
            contentDescription = null
        )
        IconButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(4.dp, 4.dp),
            onClick = onEditClick
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile_feat_avatar_edit),
                tint = KtCastTheme.colors.primaryColor,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun FillYourProfilePreview() {
    FillYourProfileScreen(
        state = FillYourProfileUIState(),
        onEditClick = {},
        onFullNameChange = {},
        onNicknameChange = {},
        onBirthdayChange = {},
        onEmailChange = {},
    )
}

