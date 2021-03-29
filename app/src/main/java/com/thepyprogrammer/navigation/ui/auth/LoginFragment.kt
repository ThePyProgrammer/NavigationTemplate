package com.thepyprogrammer.navigation.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.thepyprogrammer.navigation.R


class LoginFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel
    lateinit var nric: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var login: Button
    private lateinit var loading: ProgressBar
    private lateinit var nricLayout: TextInputLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)


        nric = root.findViewById(R.id.nricInput)
        password = root.findViewById(R.id.passwordInput)
        login = root.findViewById(R.id.login)
        loading = root.findViewById(R.id.loading)


        /**View Model**/
        viewModel = activity?.let { ViewModelProvider(it).get(AuthViewModel::class.java) }!!


        val passwordObserver = Observer<String> { newPassword ->
            password.setText(newPassword)
        }

        viewModel.password.observe(requireActivity(), passwordObserver)

        login.setOnClickListener {
            viewModel.password.value = password.text.toString().trim()
            loading.visibility = View.VISIBLE
        }

        return root
    }

}