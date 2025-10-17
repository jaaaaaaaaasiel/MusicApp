package com.composables

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private val playCircleVector: ImageVector
    get() {
        return ImageVector.Builder(
            name = "PlayCircleVector",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF0F172A)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(21f, 12f)
                curveTo(21f, 16.9706f, 16.9706f, 21f, 12f, 21f)
                curveTo(7.02944f, 21f, 3f, 16.9706f, 3f, 12f)
                curveTo(3f, 7.02944f, 7.02944f, 3f, 12f, 3f)
                curveTo(16.9706f, 3f, 21f, 7.02944f, 21f, 12f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF0F172A)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15.9099f, 11.6722f)
                curveTo(16.1671f, 11.8151f, 16.1671f, 12.1849f, 15.9099f, 12.3278f)
                lineTo(10.3071f, 15.4405f)
                curveTo(10.0572f, 15.5794f, 9.75f, 15.3986f, 9.75f, 15.1127f)
                verticalLineTo(8.88732f)
                curveTo(9.75f, 8.60139f, 10.0572f, 8.42065f, 10.3071f, 8.55951f)
                lineTo(15.9099f, 11.6722f)
                close()
            }
        }.build()
    }

private val pauseCircleVector: ImageVector
    get() {
        return ImageVector.Builder(
            name = "PauseCircleVector",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF0F172A)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(14.25f, 9f)
                verticalLineTo(15f)
                moveTo(9.75f, 15f)
                verticalLineTo(9f)
                moveTo(21f, 12f)
                curveTo(21f, 16.9706f, 16.9706f, 21f, 12f, 21f)
                curveTo(7.02944f, 21f, 3f, 16.9706f, 3f, 12f)
                curveTo(3f, 7.02944f, 7.02944f, 3f, 12f, 3f)
                curveTo(16.9706f, 3f, 21f, 7.02944f, 21f, 12f)
                close()
            }
        }.build()
    }


@Composable
fun PlayCircle(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        imageVector = playCircleVector,
        contentDescription = "Play Icon",
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun PauseCircle(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        imageVector = pauseCircleVector,
        contentDescription = "Pause Icon",
        modifier = modifier,
        tint = tint
    )
}

