package io.knowk.example.core.initializer

import android.content.Context
import androidx.startup.Initializer
import io.knowk.example.core.initializer.di.InitializerEntryPoint

class DependencyGraphInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
