package jp.co.archive.copo.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jp.co.archive.R
import jp.co.archive.copo.ui.login.LoginActivity
import jp.co.archive.copo.ui.main.MainActivity
import jp.co.archive.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel : SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        val viewModelFactory = ViewModelProvider.AndroidViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
        viewModel.user.observe(this, Observer {
            val intent = if (it.isAuthenticated) {
                MainActivity.newInstance(this)
            } else {
                LoginActivity.newInstance(this)
            }
            startActivity(intent)
            finish()
        })
        viewModel.checkAuthenticated()
    }
}