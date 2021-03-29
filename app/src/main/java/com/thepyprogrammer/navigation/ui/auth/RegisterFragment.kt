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
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_register, container, false)

        val fullname = root.findViewById<TextInputEditText>(R.id.fullNameInput)
        val nric = root.findViewById<TextInputEditText>(R.id.nricInput)
        val password = root.findViewById<TextInputEditText>(R.id.passwordInput)
        val dateSelector = root.findViewById<Button>(R.id.dateSelector)
        val register = root.findViewById<Button>(R.id.register)
        val loading = root.findViewById<ProgressBar>(R.id.loading)
        val nricLayout = root.findViewById<TextInputLayout>(R.id.nricInputLayout)


        /**View Model**/
        viewModel = activity?.let { ViewModelProvider(it).get(AuthViewModel::class.java) }!!

        val nameObserver = Observer<String> { newName ->
            fullname.setText(newName)
        }

        val nricObserver = Observer<String> { newNric ->
            nric.setText(newNric)
        }

        val passwordObserver = Observer<String> { newPassword ->
            password.setText(newPassword)
        }

        viewModel.pName.observe(requireActivity(), nameObserver)
        viewModel.password.observe(requireActivity(), passwordObserver)

//
//        fullname.afterTextChanged {
//            viewModel.pName.value = it
//        }
//
//        nric.afterTextChanged {
//            viewModel.NRIC.value = it
//        }
//
//        password.afterTextChanged {
//            viewModel.password.value = it
//        }

        register.setOnClickListener {
            loading.visibility = View.VISIBLE
            viewModel.pName.value = fullNameInput.text.toString().trim()
            viewModel.password.value = passwordInput.text.toString()
        }
        return root
    }
}