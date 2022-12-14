package com.mufiid.core.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B: ViewBinding> : Fragment() {
    private var _binding: B? = null

    protected lateinit var binding: B

    abstract fun inflateBinding(): B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding()
        binding = _binding!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateBinding(savedInstanceState)
        onSubscribeObservable()
    }

    abstract fun onCreateBinding(savedInstanceState: Bundle?)

    abstract fun onSubscribeObservable()
}