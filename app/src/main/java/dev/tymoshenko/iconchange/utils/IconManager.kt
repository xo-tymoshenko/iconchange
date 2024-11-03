package dev.tymoshenko.iconchange.utils

import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager

fun Activity.enableMainActivity() {
    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            "$packageName.MainActivity"
        ),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )
}

fun Activity.disableConfigActivity() {
    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            "$packageName.config.ConfigActivity"
        ),
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP
    )
}

fun Activity.changeIconToLight() {
    val (oldPackage, newPackage) =
        "$packageName.MainActivityDark" to "$packageName.MainActivity"

    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            newPackage
        ),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )

    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            oldPackage
        ),
        PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
        PackageManager.DONT_KILL_APP
    )
}

fun Activity.changeIconToDark() {
    val (oldPackage, newPackage) =
        "$packageName.MainActivity" to "$packageName.MainActivityDark"

    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            newPackage
        ),
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )

    packageManager.setComponentEnabledSetting(
        ComponentName(
            this,
            oldPackage
        ),
        PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
        PackageManager.DONT_KILL_APP
    )
}