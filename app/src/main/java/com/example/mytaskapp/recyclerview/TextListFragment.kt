package com.example.mytaskapp.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaskapp.R
import com.example.mytaskapp.ui.main.TextViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TextListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: TextViewModel by viewModel()
    private lateinit var adapter: TextAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = TextAdapter()
        recyclerView.adapter = adapter

        observeTextList()
    }

    private fun observeTextList() {
        viewModel.textList.observe(viewLifecycleOwner, Observer { texts ->
            adapter.submitList(texts)
        })
    }
}
