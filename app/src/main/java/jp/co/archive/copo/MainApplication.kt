package jp.co.archive.copo

import android.app.Application
import jp.co.archive.copo.di.viewModelModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(viewModelModule)
        }
    }
}