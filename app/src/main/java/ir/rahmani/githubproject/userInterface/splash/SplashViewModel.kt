package ir.rahmani.githubproject.userInterface.splash

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SplashViewModel:ViewModel() {

    fun delaySplashScreen(): Flow<Boolean> = flow<Boolean>{
        emit(false)
        delay(2500)
        emit(true)

    }

}