package jp.co.archive.copo.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val isPending = AtomicBoolean(false)

    /*
     * 1. 値が変更されるとisPendingをtrueに変更しObserverを呼び出す
     */
    @MainThread
    override fun setValue(value: T?) {
        isPending.set(true)
        super.setValue(value)
    }

    /*
     * 2. isPendingがtrueか確認し、内部に登録されたObserverはisPendingがtrueかを確認し
     * trueの場合falseに変更してから変更されたというアナウンスをする
     */
    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, Observer {
            if (isPending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        })
    }

    /*
     * TがVoidの場合、楽によびだせるメソッド
     */
    @MainThread
    fun call() {
        value = null
    }
}