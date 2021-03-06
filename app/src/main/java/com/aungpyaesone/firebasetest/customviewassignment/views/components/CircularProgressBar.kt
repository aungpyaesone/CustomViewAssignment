package com.aungpyaesone.firebasetest.customviewassignment.views.components

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.core.content.withStyledAttributes
import com.aungpyaesone.firebasetest.customviewassignment.R
import java.math.BigDecimal

class CircularProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

//    private val backgroundWidth = 10f
//    private val progressWidth = 12f
////    private var mSweepAngle = 0f
////    private var mDrawText = true
////
////
//    var mSweetAngle = 0f
//    private val backgroundPaint = Paint().apply {
//         color = Color.LTGRAY
//        style = Paint.Style.STROKE
//        strokeWidth = backgroundWidth
//        isAntiAlias = true
//    }
////
//    private val progressPaint = Paint().apply {
//        color = Color.RED
//        style = Paint.Style.STROKE
//        strokeWidth = progressWidth
//        isAntiAlias = true
//    }
////
//    private val mPaint = Paint()
//    var progress = 0f
//    set(value) {
//        field = value
//        invalidate()
//    }
//
//    private val oval = RectF()
//    private var centerX: Float = 0f
//    private var centerY: Float = 0f
//    private var radius: Float = 0f
/////
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        centerX = w.toFloat() / 2
//        centerY = h.toFloat() / 2
//        radius = w.toFloat() / 2 - progressWidth
//        oval.set(centerX - radius,
//            centerY - radius,
//            centerX + radius,
//            centerY + radius)
//        super.onSizeChanged(w, h, oldw, oldh)
//    }
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        drawText(canvas)
//        canvas.drawCircle(centerX,centerY,radius,backgroundPaint)
//        canvas.drawArc(oval,270f,mSweetAngle * 360f,false,progressPaint)
//    }
//
//    private fun drawText(canvas: Canvas) {
//        mPaint.textSize = Math.min(width, height) / 5f
//        mPaint.textAlign = Paint.Align.CENTER
//        mPaint.strokeWidth = 0f
//        mPaint.color = Color.RED
//
//        // Center text
//        val xPos = canvas.width / 2
//        val yPos =
//            (canvas.height / 2 - (mPaint.descent() + mPaint.ascent()) / 2).toInt()
//        canvas.drawText(
//            calcProgress(progress).toString()+"%",
//            xPos.toFloat(),
//            yPos.toFloat(),
//            mPaint
//        )
//    }
////
//    private fun calcProgress(progress:Float): Int{
//        return (progress * 100).toInt()
//       // return (sweepAngle * mMaxProgress / mMaxSweepAngle).toInt()
//
//////
////    fun setProgress(progress: Int){
////        val animator =
////            ValueAnimator.ofFloat(0f, calcSweepAngleFromProgress(progress))
////        animator.interpolator = DecelerateInterpolator()
////        animator.duration = 400.toLong()
////        animator.addUpdateListener { valueAnimator ->
////            mSweepAngle = valueAnimator.animatedValue as Float
////            invalidate()
////        }
////        animator.start()
////       // invalidate()
////    }
//


    private var mViewWidth = 0
    private var mViewHeight = 0
    private val mStartAngle =
        -90f // Always start from top (default is: "3 o'clock on a watch.")
    private var mSweepAngle = 0f // How long to sweep from mStartAngle
    private val mMaxSweepAngle = 360f // Max degrees to sweep = full circle
    private var mStrokeWidth = 10 // Width of outline
    private val mAnimationDuration = 400 // Animation duration for progress change
    private val mMaxProgress = 100 // Max progress to use
    private var mDrawText = true // Set to true if progress text should be drawn
    private var mRoundedCorners =
        true // Set to true if rounded corners should be applied to outline ends
    private var mProgressColor = Color.BLACK // Outline color
    private var mTextColor = Color.BLACK // Progress text color
    private val mPaint: Paint

    val backgroundPaint = Paint().apply {
        color = Color.LTGRAY
        style = Paint.Style.STROKE
        strokeWidth = 10f
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        initMeasurments()
        drawOutlineArc(canvas)
        if (mDrawText) {
            drawText(canvas)
        }
    }

    private fun initMeasurments() {
        mViewWidth = width
        mViewHeight = height
    }


    private fun drawOutlineArc(canvas: Canvas) {
        val diameter = Math.min(mViewWidth, mViewHeight)
        val pad = mStrokeWidth / 2.0.toFloat()
        val outerOval = RectF(pad, pad, diameter - pad, diameter - pad)
        val innerOval = RectF(pad,pad,diameter-pad,diameter-pad)
        mPaint.color = mProgressColor
        mPaint.strokeWidth = mStrokeWidth.toFloat()
        mPaint.isAntiAlias = true
        mPaint.strokeCap = if (mRoundedCorners) Paint.Cap.ROUND else Paint.Cap.BUTT
        mPaint.style = Paint.Style.STROKE
        canvas.drawArc(innerOval,mStartAngle,360f,false,backgroundPaint)
        canvas.drawArc(outerOval, mStartAngle, mSweepAngle, false, mPaint)
    }

    private fun drawText(canvas: Canvas) {
        mPaint.textSize = Math.min(mViewWidth, mViewHeight) / 5f
        mPaint.textAlign = Paint.Align.CENTER
        mPaint.strokeWidth = 0f
        mPaint.color = mTextColor

        // Center text
        val xPos = canvas.width / 2
        val yPos =
            (canvas.height / 2 - (mPaint.descent() + mPaint.ascent()) / 2).toInt()
        canvas.drawText(
            calcProgressFromSweepAngle(mSweepAngle).toString() + "%",
            xPos.toFloat(),
            yPos.toFloat(),
            mPaint
        )
    }

    private fun calcSweepAngleFromProgress(progress: Int): Float {
        return mMaxSweepAngle / mMaxProgress * progress
       // return 360f/100 * progress
    }

    private fun calcProgressFromSweepAngle(sweepAngle: Float): Int {
        return (sweepAngle * mMaxProgress / mMaxSweepAngle).toInt()
    }

    /**
     * Set progress of the circular progress bar.
     * @param progress progress between 0 and 100.
     */
    fun setProgress(progress: Int) {
        val animator =
            ValueAnimator.ofFloat(mSweepAngle, calcSweepAngleFromProgress(progress))
        animator.interpolator = DecelerateInterpolator()
        animator.duration = mAnimationDuration.toLong()
        animator.addUpdateListener { valueAnimator ->
            mSweepAngle = valueAnimator.animatedValue as Float
            invalidate()
        }
        animator.start()
    }

    fun setProgressColor(color: Int) {
        mProgressColor = color
        invalidate()
    }

    fun setProgressWidth(width: Int) {
        mStrokeWidth = width
        invalidate()
    }

    fun setTextColor(color: Int) {
        mTextColor = color
        invalidate()
    }

    fun showProgressText(show: Boolean) {
        mDrawText = show
        invalidate()
    }

    /**
     * Toggle this if you don't want rounded corners on progress bar.
     * Default is true.
     * @param roundedCorners true if you want rounded corners of false otherwise.
     */
    fun useRoundedCorners(roundedCorners: Boolean) {
        mRoundedCorners = roundedCorners
        invalidate()
    }

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    }
}