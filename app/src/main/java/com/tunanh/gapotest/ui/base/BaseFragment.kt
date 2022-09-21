package com.tunanh.gapotest.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tunanh.gapotest.viewmodel.GapoViewModel

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    protected lateinit var binding: T

    protected lateinit var viewModel: GapoViewModel

    @LayoutRes
    protected abstract fun layoutRes(): Int
    protected abstract fun initView()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            GapoViewModel.GapoViewModelFactory(this.activity!!.application)
        )[GapoViewModel::class.java]
        initView()
    }


}