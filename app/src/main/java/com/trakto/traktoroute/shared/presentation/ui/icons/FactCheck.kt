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
public val FactCheck: ImageVector
    get() {
        if (_FactCheck != null) {
            return _FactCheck!!
        }
        _FactCheck =
            ImageVector.Builder(
                name = "fact_check",
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
                        moveTo(4f, 21f)
                        quadTo(3.18f, 21f, 2.59f, 20.41f)
                        reflectiveQuadTo(2f, 19f)
                        verticalLineTo(5f)
                        quadTo(2f, 4.17f, 2.59f, 3.59f)
                        reflectiveQuadTo(4f, 3f)
                        horizontalLineTo(20f)
                        quadToRelative(0.83f, 0f, 1.41f, 0.59f)
                        reflectiveQuadTo(22f, 5f)
                        verticalLineTo(19f)
                        quadToRelative(0f, 0.82f, -0.59f, 1.41f)
                        reflectiveQuadTo(20f, 21f)
                        horizontalLineTo(4f)
                        close()
                        moveTo(4f, 19f)
                        horizontalLineTo(20f)
                        verticalLineTo(5f)
                        horizontalLineTo(4f)
                        verticalLineTo(19f)
                        close()
                        moveTo(5f, 17f)
                        horizontalLineToRelative(5f)
                        verticalLineTo(15f)
                        horizontalLineTo(5f)
                        verticalLineToRelative(2f)
                        close()
                        moveToRelative(9.55f, -2f)
                        lineTo(19.5f, 10.05f)
                        lineTo(18.08f, 8.63f)
                        lineToRelative(-3.52f, 3.55f)
                        lineTo(13.13f, 10.75f)
                        lineToRelative(-1.4f, 1.42f)
                        lineTo(14.55f, 15f)
                        close()
                        moveTo(5f, 13f)
                        horizontalLineToRelative(5f)
                        verticalLineTo(11f)
                        horizontalLineTo(5f)
                        verticalLineToRelative(2f)
                        close()
                        moveTo(5f, 9f)
                        horizontalLineToRelative(5f)
                        verticalLineTo(7f)
                        horizontalLineTo(5f)
                        verticalLineTo(9f)
                        close()
                        moveTo(4f, 19f)
                        verticalLineTo(5f)
                        verticalLineTo(19f)
                        close()
                    }
                }
                .build()
        return _FactCheck!!
    }

private var _FactCheck: ImageVector? = null