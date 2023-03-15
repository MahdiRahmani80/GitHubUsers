package ir.rahmani.githubproject.di

import android.app.Application
import ir.rahmani.githubproject.data.ApiInterface
import ir.rahmani.githubproject.data.repository.Repository
import ir.rahmani.githubproject.nav.SharedViewModel
import ir.rahmani.githubproject.userInterface.detail.DetailViewModel
import ir.rahmani.githubproject.userInterface.main.MainViewModel
import ir.rahmani.githubproject.userInterface.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val myModules = module {

            single { SplashViewModel() }
            single { ApiInterface.create() }
            single { SharedViewModel() }
            single { DetailViewModel(get()) }
            single { Repository(api = get()) }
            single { MainViewModel(repo= get()) }
        }

        startKoin {
            printLogger()
            androidContext(this@App)
            modules(myModules)
        }
    }
}