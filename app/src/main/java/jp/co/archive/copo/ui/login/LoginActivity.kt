package jp.co.archive.copo.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jp.co.archive.R
import jp.co.archive.copo.ui.main.MainActivity
import jp.co.archive.copo.ui.signup.SignUpActivity
import jp.co.archive.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this

        val viewModelFactory = ViewModelProvider.AndroidViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        binding.activity = this
        binding.viewModel = viewModel

        viewModel.user.observe(this, Observer {
            if (it.isAuthenticated) {
                startActivity(
                    MainActivity.newInstance(
                        this
                    )
                )
                finish()
            }
        })
        viewModel.errorMessage.observe(this, Observer {
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
