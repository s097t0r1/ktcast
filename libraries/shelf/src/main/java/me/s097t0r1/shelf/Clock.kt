package me.s097t0r1.shelf

import java.util.Date

open class Clock {
    open fun now(): Long = (Date().time / 1000)
}