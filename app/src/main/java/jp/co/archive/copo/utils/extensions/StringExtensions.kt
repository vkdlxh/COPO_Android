package jp.co.archive.copo.utils.extensions

fun String.isEmailValid(): Boolean {
    return this.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}