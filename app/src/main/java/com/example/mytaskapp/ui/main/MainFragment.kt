package com.example.mytaskapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mytaskapp.R
import com.example.mytaskapp.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: TextViewModel by viewModel()
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        observe()
    }

    private fun setListener() {
        with(binding) {
            button.setOnClickListener {
                val inputText = binding.editText.text.toString()
                viewModel.insertText(inputText)
                editText.setText("")
            }
            buttonShowList.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_textListFragment)
            }
        }
    }
    private fun observe() {
        with(viewModel) {
            lastText.observe(viewLifecycleOwner) { textEntity ->
                binding.textView.text = getString(R.string.tv_hello_with_text, textEntity?.text)
            }
        }
    }
}

