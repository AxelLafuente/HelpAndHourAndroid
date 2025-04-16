import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DiamondDivider(
    modifier: Modifier = Modifier,
    color: Color = androidx.compose.ui.graphics.Color.White,
    strokeWidth: Dp = 2.dp,
    diamondSize: Dp = 10.dp,
    horizontalPadding: Dp = 16.dp
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(diamondSize * 2)
    ) {
        val diamond = diamondSize.toPx()
        val padding = horizontalPadding.toPx()
        val centerY = size.height / 2

        // Linha


        // Losango esquerdo
        drawPath(
            path = Path().apply {
                moveTo(padding, centerY)
                lineTo(padding + diamond / 2, centerY - diamond / 2)
                lineTo(padding + diamond, centerY)
                lineTo(padding + diamond / 2, centerY + diamond / 2)
                close()
            },
            color = color
        )

        // Losango direito
        drawPath(
            path = Path().apply {
                val end = size.width - padding
                moveTo(end, centerY)
                lineTo(end - diamond / 2, centerY - diamond / 2)
                lineTo(end - diamond, centerY)
                lineTo(end - diamond / 2, centerY + diamond / 2)
                close()
            },
            color = color
        )

        drawLine(
            color = color,
            start = Offset(x = padding + diamond, y = centerY),
            end = Offset(x = size.width - padding - diamond, y = centerY),
            strokeWidth = strokeWidth.toPx()
        )
    }
}