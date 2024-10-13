package com.example.mytaskapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mytaskapp.R
import com.example.mytaskapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TextViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListener()
        observe()
    }

    private fun observe() {
        with(viewModel) {
            lastText.observe(this@MainActivity) { textEntity ->
                binding.textView.text = getString(R.string.tv_hello_with_text, textEntity?.text)
            }
        }
    }

    private fun setListener() {
        with(binding) {
            button.setOnClickListener {
                val inputText = binding.editText.text.toString()
                viewModel.insertText(inputText)
            }
        }
    }
}
