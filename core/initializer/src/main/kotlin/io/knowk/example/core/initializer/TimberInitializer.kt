package io.knowk.example.core.initializer

import android.content.Context
import androidx.startup.Initializer
import io.knowk.example.core.initializer.di.InitializerEntryPoint
import javax.inject.Inject
import timber.log.Timber

class TimberInitializer : Initializer<Timber.Tree> {
    @Inject
    lateinit var timberTree: Timber.Tree

    override fun create(context: Context): Timber.Tree {
        // injecting dependencies from Hilt
        InitializerEntryPoint.resolve(context).inject(this)

        Timber.plant(timberTree)
        Timber.d("TimberInitializer is initialized.")

        return timberTree
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(DependencyGraphInitializer::class.java)
}
