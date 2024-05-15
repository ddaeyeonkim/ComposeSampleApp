package com.ddaeyeonkim.composesampleapp.ui.screen

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ddaeyeonkim.composesampleapp.R
import com.ddaeyeonkim.composesampleapp.ui.component.CommonTopAppBar
import com.ddaeyeonkim.composesampleapp.ui.theme.Purple40

@Composable
fun ResourcesScreen() {
    Scaffold(
        topBar = {
            CommonTopAppBar(title = "Resources")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // stringResource
            Text(text = stringResource(id = R.string.hello_world))

            // stringResource with positional formatting.
            Text(
                text = stringResource(R.string.congratulate, "New Year", 2024)
            )

            // String plurals
            Text(
                text = pluralStringResource(
                    R.plurals.runtime_format,
                    2,
                    2
                )
            )

            Divider(color = colorResource(R.color.purple_200))

            // dimensionResource
            val smallPadding = dimensionResource(R.dimen.padding_small)
            Text(
                text = "...",
                modifier = Modifier.padding(smallPadding)
            )

            // color
            Divider(color = colorResource(R.color.purple_200))

            // color state list
            Button(
                onClick = { /* Do something */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200),
                )
            ) {
                Text("Button", color = colorResource(id = R.color.button_text))
            }

            // https://developer.android.com/develop/ui/compose/animation/vectors
            // https://velog.io/@coooldoggy/Jetpack-Compose%EB%A1%9C-Pressed-State-%EB%A7%8C%EB%93%A4%EA%B8%B0
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            val color = if (isPressed) Color.Red else Color.White

            Button(
                interactionSource = interactionSource,
                colors = ButtonDefaults.buttonColors(containerColor = Purple40),
//                shape = RoundedCornerShape(8.dp),
                onClick = {}
            ) {
                Text("Press me", color = color)
            }

            Divider(color = colorResource(R.color.purple_200))

            // Vector assets and image resources

            // painterResource
            // bitmapDrawable, vectorDrawable 파싱 가능
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null // decorative element
            )
            AnimatedVectorImage()

            Divider(color = colorResource(R.color.purple_200))

            // Filled, Outlined, Rounded, TwoTone, Sharp
            Icon(Icons.Rounded.Menu, contentDescription = "Localized description")

            Divider(color = colorResource(R.color.purple_200))

            CraneTheme {
                Text("Hello, Crane!")
                Text(
                    "Hello, Crane!",
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimatedVectorImage() {
    val image =
        AnimatedImageVector.animatedVectorResource(R.drawable.ic_hourglass_animated)
    var atEnd by remember { mutableStateOf(false) }
    Icon(
        painter = rememberAnimatedVectorPainter(image, atEnd),
        contentDescription = null // decorative element
    )
    Button(onClick = { atEnd = !atEnd }) {
        Text("Toggle animation")
    }
}

// Define and load the fonts of the app
private val light = Font(R.font.raleway_light, FontWeight.W300)
private val regular = Font(R.font.raleway_regular, FontWeight.W400)
private val medium = Font(R.font.raleway_medium, FontWeight.W500)
private val semibold = Font(R.font.raleway_semibold, FontWeight.W600)

// Create a font family to use in TextStyles
private val craneFontFamily = FontFamily(light, regular, medium, semibold)

// Use the font family to define a custom typography
val craneTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = craneFontFamily
    ) /* ... */
)

// Pass the typography to a MaterialTheme that will create a theme using
// that typography in the part of the UI hierarchy where this theme is used
@Composable
fun CraneTheme(content: @Composable () -> Unit) {
    MaterialTheme(typography = craneTypography) {
        content()
    }
}
