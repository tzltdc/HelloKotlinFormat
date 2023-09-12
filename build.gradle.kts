// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.ncorti.ktfmt.gradle") version "0.13.0"
}

ktfmt {
    // Google style - 2 space indentation
    googleStyle()
}