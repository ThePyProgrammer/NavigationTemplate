package com.thepyprogrammer.navigation.model.view.listener

import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import com.thepyprogrammer.navigation.model.configurations.round


abstract class OnShakeListener(activity: Activity) : SensorEventListener {
    // For shake motion detection.
    private var sensorMgr: SensorManager? = null
    private var lastUpdate: Long = -1
    private var x: Float = 0f
    private var y: Float = 0f
    private var z: Float = 0f
    private var last_x: Float = 0f
    private var last_y: Float = 0f
    private var last_z: Float = 0f

    init {
        sensorMgr = activity.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        val accelSupported = sensorMgr!!.registerListener(
            this,
            sensorMgr?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }


    override fun onSensorChanged(se: SensorEvent) {
        val curTime = System.currentTimeMillis()
        // only allow one update every 1s.
        if (curTime - lastUpdate > 1000) {
            val diffTime: Long = curTime - lastUpdate
            lastUpdate = curTime
            val x = se.values[0]
            val y = se.values[1]
            val z = se.values[2]
            if (x.round(4) > 10.0000) {
                Log.d("sensor", "X Right axis: $x")
                onShakeRight()
            } else if (x.round(4) < -10.0000) {
                Log.d("sensor", "X Left axis: $x")
                onShakeLeft()
            }

            last_x = x
            last_y = y
            last_z = z
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    abstract fun onShakeLeft()
    abstract fun onShakeRight()
}