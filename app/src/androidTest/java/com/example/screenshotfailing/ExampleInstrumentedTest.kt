package com.example.screenshotfailing

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.karumi.shot.ScreenshotTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleInstrumentedTest: ScreenshotTest {
    @Test
    fun test() {
        val fragmentScenario = launchFragmentInContainer(themeResId = R.style.AppTheme) {
            return@launchFragmentInContainer BlankFragment()
        }
        fragmentScenario.moveToState(Lifecycle.State.RESUMED)
        fragmentScenario.onFragment {
            compareScreenshot(it)
        }
    }
}