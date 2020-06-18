package jp.co.archive.copo.di

import jp.co.archive.copo.data.repository.AuthRepository
import jp.co.archive.copo.ui.login.LoginViewModel
import jp.co.archive.copo.ui.main.MainViewModel
import jp.co.archive.copo.ui.signup.SignUpViewModel
import jp.co.archive.copo.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        MainViewModel(get())
    }
    viewModel {
        SignUpViewModel(get())
    }
    viewModel {
        SplashViewModel(get())
    }
}

val module = module {
    single {
        AuthRepository()
    }
}