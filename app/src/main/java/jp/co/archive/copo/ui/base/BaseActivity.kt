package jp.co.archive.copo.ui.base

import android.annotation.SuppressLint
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> =
        lazy { DataBindingUtil.setContentView<T>(this, resId) }

}