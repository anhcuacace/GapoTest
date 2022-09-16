package com.tunanh.gapotest.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.tunanh.gapotest.viewmodel.GapoViewModel

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    protected val gapoViewModel: GapoViewModel by lazy {
        ViewModelProvider(
            this,
            GapoViewModel.GapoViewModelFactory(this.application)
        )[GapoViewModel::class.java]
    }
    protected lateinit var binding: T

    @LayoutRes
    abstract fun layoutRes(): Int
    abstract fun initEvents()
    abstract fun initControls()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes())
        binding.lifecycleOwner = this
        initControls()
        initEvents()
    }
}