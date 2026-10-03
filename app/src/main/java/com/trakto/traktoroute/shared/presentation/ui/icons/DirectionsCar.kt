package com.trakto.traktoroute.shared.presentation.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


@Suppress("CheckReturnValue")
public val DirectionsCar: ImageVector
    get() {
        if (_DirectionsCar != null) {
            return _DirectionsCar!!
        }
        _DirectionsCar =
            ImageVector.Builder(
                name = "directions_car",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.Companion.NonZero,
                    ) {
                        moveTo(6f, 19f)
                        verticalLineToRelative(1f)
                        quadToRelative(0f, 0.43f, -0.29f, 0.71f)
                        reflectiveQuadTo(5f, 21f)
                        horizontalLineTo(4f)
                        quadTo(3.58f, 21f, 3.29f, 20.71f)
                        quadTo(3f, 20.43f, 3f, 20f)
                        verticalLineTo(12f)
                        lineTo(5.1f, 6f)
                        quadTo(5.25f, 5.55f, 5.64f, 5.27f)
                        reflectiveQuadTo(6.5f, 5f)
                        horizontalLineToRelative(11f)
                        quadToRelative(0.48f, 0f, 0.86f, 0.27f)
                        reflectiveQuadTo(18.9f, 6f)
                        lineTo(21f, 12f)
                        verticalLineToRelative(8f)
                        quadToRelative(0f, 0.43f, -0.29f, 0.71f)
                        reflectiveQuadTo(20f, 21f)
                        horizontalLineTo(19f)
                        quadToRelative(-0.43f, 0f, -0.71f, -0.29f)
                        quadTo(18f, 20.43f, 18f, 20f)
                        verticalLineTo(19f)
                        horizontalLineTo(6f)
                        close()
                        moveTo(5.8f, 10f)
                        horizontalLineTo(18.2f)
                        lineTo(17.15f, 7f)
                        horizontalLineTo(6.85f)
                        lineTo(5.8f, 10f)
                        close()
                        moveTo(5f, 12f)
                        verticalLineToRelative(5f)
                        verticalLineTo(12f)
                        close()
                        moveToRelative(2.5f, 4f)
                        quadToRelative(0.63f, 0f, 1.06f, -0.44f)
                        reflectiveQuadTo(9f, 14.5f)
                        reflectiveQuadTo(8.56f, 13.44f)
                        reflectiveQuadTo(7.5f, 13f)
                        reflectiveQuadTo(6.44f, 13.44f)
                        reflectiveQuadTo(6f, 14.5f)
                        reflectiveQuadToRelative(0.44f, 1.06f)
                        reflectiveQuadTo(7.5f, 16f)
                        close()
                        moveToRelative(9f, 0f)
                        quadToRelative(0.63f, 0f, 1.06f, -0.44f)
                        reflectiveQuadTo(18f, 14.5f)
                        reflectiveQuadTo(17.56f, 13.44f)
                        reflectiveQuadTo(16.5f, 13f)
                        reflectiveQuadToRelative(-1.06f, 0.44f)
                        reflectiveQuadTo(15f, 14.5f)
                        reflectiveQuadToRelative(0.44f, 1.06f)
                        reflectiveQuadTo(16.5f, 16f)
                        close()
                        moveTo(5f, 17f)
                        horizontalLineTo(19f)
                        verticalLineTo(12f)
                        horizontalLineTo(5f)
                        verticalLineToRelative(5f)
                        close()
                    }
                }
                .build()
        return _DirectionsCar!!
    }

private var _DirectionsCar: ImageVector? = null