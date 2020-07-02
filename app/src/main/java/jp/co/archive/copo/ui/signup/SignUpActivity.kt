package jp.co.archive.copo.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import jp.co.archive.R
import jp.co.archive.copo.ui.base.BaseActivity
import jp.co.archive.copo.ui.main.MainActivity
import jp.co.archive.databinding.ActivitySignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : BaseActivity() {

    private val binding: ActivitySignUpBinding by binding(R.layout.activity_sign_up)
    private val viewModel: SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@SignUpActivity
            viewModel = this@SignUpActivity.viewModel
        }

        viewModel.user.observe(this, Observer {
            if (it.isAuthenticated) {
                val intent = MainActivity.newInstance(this).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                }
                startActivity(intent)
            }
        })
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    companion object {
        fun newInstance(context: Context) = Intent(context, SignUpActivity::class.java)
    }
}