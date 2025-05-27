package com.phrase.example

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.phrase.android.sdk.PhraseTypedArray.getStringWithPhrase
import kotlin.math.roundToInt
import kotlin.properties.Delegates

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 40f
        textAlign = Paint.Align.LEFT
    }
    private val bgPaint = Paint().apply {
        color = Color.CYAN
    }

    @Suppress("MemberVisibilityCanBePrivate")
    var text: CharSequence? by Delegates.observable(null) { _, _, _ -> invalidate() }

    init {
        runCatching {
            context.withStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0) {
                text = getStringWithPhrase(R.styleable.CustomView_android_text)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val textMeasure = textPaint.measureText(text.toString())

        setMeasuredDimension(
            MeasureSpec.makeMeasureSpec(
                textMeasure.roundToInt() + paddingStart + paddingEnd,
                MeasureSpec.EXACTLY
            ),
            MeasureSpec.makeMeasureSpec(
                textPaint.textSize.roundToInt() + paddingTop + paddingBottom,
                MeasureSpec.EXACTLY
            ),
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        with(canvas) {
            drawRect(
                0f,
                0f,
                this@CustomView.width.toFloat(),
                this@CustomView.height.toFloat(),
                bgPaint
            )

            text?.run {
                drawText(
                    this,
                    0,
                    length,
                    paddingStart.toFloat(),
                    paddingTop.toFloat() + textPaint.textSize,
                    textPaint
                )
            }
        }
    }
}