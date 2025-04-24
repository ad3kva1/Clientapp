// settings.gradle.kts (корень проекта)

import org.gradle.api.initialization.* // ← добавляем это



    plugins {
        id("com.android.application") version "8.2.0"
        id("org.jetbrains.kotlin.android") version "2.0.0"
        id("org.jetbrains.kotlin.kapt") version "2.0.0"
    }

