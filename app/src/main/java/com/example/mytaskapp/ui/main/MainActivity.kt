    package com.example.mytaskapp.ui.main

    import android.os.Bundle
    import android.util.Log
    import androidx.appcompat.app.AppCompatActivity
    import androidx.databinding.DataBindingUtil
    import androidx.navigation.fragment.NavHostFragment
    import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
    import androidx.navigation.fragment.findNavController
    import com.example.mytaskapp.R
    import com.example.mytaskapp.databinding.ActivityMainBinding
    import org.koin.androidx.viewmodel.ext.android.viewModel

    class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding
        private val viewModel: TextViewModel by viewModel()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.findNavController()


            binding.buttonShowList.setOnClickListener {
                navController.navigate(R.id.action_mainFragment_to_textListFragment)
            }

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
            binding.button.setOnClickListener {
                val inputText = binding.editText.text.toString()
                viewModel.insertText(inputText)
            }

            binding.buttonShowList.setOnClickListener {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.textListFragment)
            }
        }

    }
