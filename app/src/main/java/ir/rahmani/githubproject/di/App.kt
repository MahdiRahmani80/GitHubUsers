package ir.rahmani.githubproject.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val myModules = module {

        }

        startKoin {
            printLogger()
            androidContext(this@App)
            modules(myModules)
        }
    }
}