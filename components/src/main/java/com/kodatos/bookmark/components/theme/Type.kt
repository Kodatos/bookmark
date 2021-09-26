package com.kodatos.bookmark.components.theme

import androidx.compose.material.Typography
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
        h1 = TextStyle(
                fontFamily = BebasNue,
                fontSize = 36.sp,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Normal
        ),
        h2 = TextStyle(
                fontFamily = OpenSans,
                fontSize = 24.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Bold
        ),
        h3 = TextStyle(
                fontFamily = OpenSans,
                fontSize = 24.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
        ),
        h4 = TextStyle(
                fontFamily = OpenSans,
                fontSize = 20.sp,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.SemiBold
        ),
        h6 = TextStyle(
                fontFamily = OpenSans,
                fontSize = 16.sp,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.SemiBold,
        ),
        subtitle1 = TextStyle(
                fontFamily = OpenSans,
                fontSize = 16.sp,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.Normal,
        ),
        subtitle2 = TextStyle(
                fontFamily = OpenSans,
                fontSize = 16.sp,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic
        ),
        body1 = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.Normal,
        ),
        body2 = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                fontWeight = FontWeight.Normal
        ),
        button = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                letterSpacing = 1.25.sp
        ),
)
