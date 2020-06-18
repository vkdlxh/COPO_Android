package jp.co.archive.copo.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import jp.co.archive.R
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.copo.ui.main.MainActivity
import jp.co.archive.copo.ui.signup.SignUpActivity
import jp.co.archive.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val binding: ActivityLoginBinding by binding(R.layout.activity_login)
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@LoginActivity
            activity = this@LoginActivity
            viewModel = loginViewModel
        }

        loginViewModel.user.observe(this, Observer {
            if (it.isAuthenticated) {
                startActivity(
                    MainActivity.newInstance(
                        this
                    )
                )
                finish()
            }
        })
        loginViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    fun showSignUp() {
        startActivity(
            SignUpActivity.newInstance(
                this
            )
        )
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, LoginActivity::class.java)
    }
}
