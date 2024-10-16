package com.example.mytaskapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mytaskapp.R
import com.example.mytaskapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TextViewModel by viewModel()
    private lateinit var navControllerMain: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        navControllerMain = Navigation.findNavController(this, R.id.nav_host_fragment)

//            binding.buttonShowList.setOnClickListener {
//                navController.navigate(R.id.action_mainFragment_to_textListFragment)
//            }

//        observe()
    }

//    private fun observe() {
//        with(viewModel) {
//            lastText.observe(this@MainActivity) { textEntity ->
//                binding.textView.text = getString(R.string.tv_hello_with_text, textEntity?.text)
//            }
//        }
//    }
//
//    private fun setListener() {
//        binding.button.setOnClickListener {
//            val inputText = binding.editText.text.toString()
//            viewModel.insertText(inputText)
//        }
//
//        binding.buttonShowList.setOnClickListener {
//            val navHostFragment =
//                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//            val navController = navHostFragment.navController
//            navController.navigate(R.id.textListFragment)
//        }
//    }

}
