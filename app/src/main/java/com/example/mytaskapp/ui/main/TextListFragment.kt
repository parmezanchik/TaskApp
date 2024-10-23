package com.example.mytaskapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytaskapp.databinding.FragmentTextListBinding
import com.example.mytaskapp.recyclerview.TextAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TextListFragment : Fragment() {
    private lateinit var binding: FragmentTextListBinding
    private val viewModel: TextViewModel by viewModel()
    private lateinit var adapter: TextAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTextListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeTextList()
    }

    private fun setupRecyclerView() {
        adapter = TextAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun observeTextList() {
        viewModel.textList.observe(viewLifecycleOwner) { texts ->
            adapter.submitList(texts)
        }
    }
}

