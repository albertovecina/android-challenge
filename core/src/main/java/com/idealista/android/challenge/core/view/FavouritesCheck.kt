package com.idealista.android.challenge.core.view

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.idealista.android.challenge.core.R


class FavouritesCheck @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var viewSize: Float
    private var originalHeartSize: Float
    private var currentHeartSize: Float

    private val animationDuration: Long = 250
    private var currentAnimationFraction: Float = 1f

    var isChecked: Boolean = false
        set(value) {
            field = value
            invalidate()
        }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.FavouritesCheck,
            0, 0
        ).apply {

            try {
                viewSize = getDimension(R.styleable.FavouritesCheck_android_layout_width, 0f)
                originalHeartSize = viewSize * 0.8f
                currentHeartSize = originalHeartSize
            } finally {
                recycle()
            }
        }

    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener {
            isChecked = !isChecked
            animateHeartClick()
            l?.onClick(it)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawHeart(canvas, currentHeartSize)
    }

    private fun animateHeartClick() {
        ValueAnimator().apply {
            setValues(
                PropertyValuesHolder.ofFloat(
                    "size",
                    originalHeartSize,
                    viewSize,
                    originalHeartSize
                )
            )
            duration = animationDuration
            addUpdateListener { animation ->
                currentAnimationFraction = animation.animatedFraction
                currentHeartSize = animation.getAnimatedValue("size") as Float
                invalidate()
            }
        }.start()
    }

    private fun drawHeart(canvas: Canvas, size: Float) {

        val margin = ((viewSize - size) / 2).toInt()

        val uncheckedHeartDrawable =
            ContextCompat.getDrawable(context, R.drawable.ic_heart_unchecked)?.apply {
                setBounds(margin, margin, size.toInt() + margin, size.toInt() + margin)
                setTint(Color.RED)
            }

        LayerDrawable(arrayOf(uncheckedHeartDrawable, getHeartBackgroundDrawable(size, margin)))
            .draw(canvas)

    }

    private fun getHeartBackgroundDrawable(size: Float, margin: Int): Drawable? =
        ContextCompat.getDrawable(context, R.drawable.ic_heart_checked)?.mutate()?.apply {

            val currentAlpha = if (isChecked)
                255 * currentAnimationFraction
            else
                255 - (255 * currentAnimationFraction)

            setBounds(margin, margin, size.toInt() + margin, size.toInt() + margin)
            alpha = (currentAlpha.toInt())
            setTint(Color.RED)
        }

}