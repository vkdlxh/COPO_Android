package jp.co.archive.copo.ui.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import jp.co.archive.R
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.copo.ui.login.LoginActivity
import jp.co.archive.copo.ui.main.MainActivity
import jp.co.archive.databinding.ActivitySplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    private val binding: ActivitySplashBinding by binding(R.layout.activity_splash)
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@SplashActivity
        }

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