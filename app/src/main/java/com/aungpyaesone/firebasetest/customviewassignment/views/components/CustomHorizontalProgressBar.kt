package com.aungpyaesone.firebasetest.customviewassignment.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.aungpyaesone.firebasetest.customviewassignment.R

class CustomHorizontalProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val mPath = Path()
    private val backgroundWidth = 10f
    private val progressWidth = 12f

    init {
        context.withStyledAttributes(attrs,R.styleable.CustomHorizontalProgressBar){
            progress = getInt(R.styleable.CustomHorizontalProgressBar_progress,1)*0.01f
        }
    }

    private var progress = 0f
    set(value) {
        field = value
        invalidate()
    }


    private val backgroundPaint = Paint().apply {
        color = Color.LTGRAY
        style = Paint.Style.FILL
        strokeWidth = backgroundWidth
        isAntiAlias = true
    }

    private val progressPaint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.FILL
        strokeWidth = progressWidth
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawProgress(canvas)
    }

    private fun drawProgress(canvas: Canvas?){

        canvas?.drawLine(0f,height.toFloat(),width.toFloat(),height.toFloat(),backgroundPaint)

        if(progress != 0f) {
            canvas?.drawLine(
                0f,
                height.toFloat(),
                width * progress,
                height.toFloat(),
                progressPaint
            )
        }

    }

    fun setProgress(progress:Int){
        var pro = (progress* 0.01f)
        this.progress = pro
    }


}