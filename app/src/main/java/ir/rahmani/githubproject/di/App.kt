package ir.rahmani.githubproject.di

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.rahmani.githubproject.data.ApiInterface
import ir.rahmani.githubproject.data.local.DataBase
import ir.rahmani.githubproject.data.repository.Repository
import ir.rahmani.githubproject.nav.SharedViewModel
import ir.rahmani.githubproject.userInterface.detail.DetailViewModel
import ir.rahmani.githubproject.userInterface.main.MainViewModel
import ir.rahmani.githubproject.userInterface.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val myModules = module {

            single {
                Room.databaseBuilder(androidApplication(), DataBase::class.java, "data_base")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            single {  }
            single { SplashViewModel() }
            single { ApiInterface.create() }
            single { provideUserDao(get()) }
            single { SharedViewModel() }
            single { DetailViewModel(get()) }
            single { Repository(api = get(), dao = get()) }
            single { MainViewModel(repo = get()) }
        }

        startKoin {
            printLogger()
            androidContext(this@App)
            modules(myModules)
        }
    }
}

fun provideUserDao(db:DataBase)= db.userDao()