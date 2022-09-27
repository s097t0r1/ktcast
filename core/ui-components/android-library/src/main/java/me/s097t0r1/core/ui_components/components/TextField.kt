package me.s097t0r1.core.ui_components.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.s097t0r1.core.ui_components.theme.KtCastTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun KtCastOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 16.dp
    ),
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = KtCastTheme.colors.textPrimaryColor,
        disabledTextColor = KtCastTheme.colors.textSecondaryColor,
        cursorColor = KtCastTheme.colors.textPrimaryColor,
        errorCursorColor = KtCastTheme.colors.textPrimaryColor,
        focusedBorderColor = KtCastTheme.colors.fieldActiveColor,
        unfocusedBorderColor = KtCastTheme.colors.fieldBasicColor,
        disabledBorderColor = KtCastTheme.colors.fieldDisabledColor,
        errorBorderColor = KtCastTheme.colors.fieldErrorColor,
        leadingIconColor = KtCastTheme.colors.textSecondaryColor,
        disabledLeadingIconColor = KtCastTheme.colors.textSecondaryColor,
        errorLeadingIconColor = KtCastTheme.colors.iconNegativeColor,
        trailingIconColor = KtCastTheme.colors.textSecondaryColor,
        disabledTrailingIconColor = KtCastTheme.colors.textSecondaryColor,
        errorTrailingIconColor = KtCastTheme.colors.iconNegativeColor,
        focusedLabelColor = KtCastTheme.colors.fieldActiveColor,
        unfocusedLabelColor = KtCastTheme.colors.fieldBasicColor,
        disabledLabelColor = KtCastTheme.colors.fieldDisabledColor,
        errorLabelColor = KtCastTheme.colors.fieldErrorColor,
        placeholderColor = KtCastTheme.colors.fieldBasicColor,
        disabledPlaceholderColor = KtCastTheme.colors.fieldDisabledColor
    ),
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = if (label != null) {
            modifier.padding(top = 8.dp)
        } else {
            modifier
        }
            .background(colors.backgroundColor(enabled).value, shape)
            .defaultMinSize(
                minWidth = TextFieldDefaults.MinWidth,
                minHeight = TextFieldDefaults.MinHeight
            ),
        visualTransformation = visualTransformation,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle.copy(color = KtCastTheme.colors.textPrimaryColor),
        cursorBrush = SolidColor(colors.cursorColor(isError).value),
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
    ) { innerTextField ->
        TextFieldDefaults.OutlinedTextFieldDecorationBox(
            value = value,
            innerTextField = innerTextField,
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            contentPadding = PaddingValues(vertical = 21.dp),
            isError = isError,
            label = label,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            colors = colors,
            border = {
                TextFieldDefaults.BorderBox(
                    enabled,
                    isError,
                    interactionSource,
                    colors,
                    shape
                )
            }
        )
    }
}

@Preview
@Composable
fun OutlineTextFieldPreview() {
    KtCastTheme {

        val (value, onValueChanged) = remember { mutableStateOf("") }

        KtCastOutlinedTextField(
            value = "Hello world!",
            onValueChange = onValueChanged,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            },
            placeholder = { Text("Email") }
        )
    }
}