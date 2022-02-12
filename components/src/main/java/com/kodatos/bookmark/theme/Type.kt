package com.kodatos.bookmark.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kodatos.bookmark.components.R

val BebasNue = FontFamily(
        Font(R.font.bebasneue_regular)
)

val OpenSans = FontFamily(
        Font(R.font.opensans_regular, FontWeight.Normal),
        Font(R.font.opensans_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.opensans_semibold, FontWeight.SemiBold),
        Font(R.font.opensans_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.opensans_bold, FontWeight.Bold),
)

val BookmarkTypography = Typography(

        displayLarge = TextStyle(
                fontFamily = BebasNue,
                fontSize = 48.sp,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Normal
        ),
        displaySmall = TextStyle(
                fontFamily = BebasNue,
                fontSize = 28.sp,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.Normal,
        ),
        headlineLarge = TextStyle(
                fontFamily = OpenSans,
                fontSize = 32.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Bold
        ),
        headlineMedium = TextStyle(
            fontFamily = OpenSans,
            fontSize = 28.sp,
            letterSpacing = 0.15.sp,
            fontWeight = FontWeight.SemiBold,
        ),
        titleLarge = TextStyle(
                fontFamily = OpenSans,
                fontSize = 24.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
        ),
        titleMedium = TextStyle(
                fontFamily = OpenSans,
                fontSize = 20.sp,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.SemiBold
        ),
        titleSmall = TextStyle(
                fontFamily = OpenSans,
                fontSize = 16.sp,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.SemiBold,
        ),
        bodyMedium = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.Normal,
        ),
        bodySmall = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                fontWeight = FontWeight.Normal
        ),
        labelSmall = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                letterSpacing = 1.25.sp
        ),
)
