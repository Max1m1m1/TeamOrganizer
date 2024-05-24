package com.example.ozan.teamorganizer.gesture


import android.os.Handler
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class DoubleTapListener(
    private val onDoubleTap: () -> Unit
) : View.OnTouchListener {

    private var gestureDetector: GestureDetector

    init {
        gestureDetector = GestureDetector(DoubleTapGestureListener())
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event ?: return false)
    }


    private inner class DoubleTapGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDoubleTap(e: MotionEvent): Boolean {
            onDoubleTap()
            return true
        }
    }
}
