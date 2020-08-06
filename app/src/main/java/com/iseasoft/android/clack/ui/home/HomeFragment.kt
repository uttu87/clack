package com.iseasoft.android.clack.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.iseasoft.android.clack.DrawerLocker
import com.iseasoft.android.clack.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.mainChannelName)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    fun sendMessageButtonClicked(view: View) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DrawerLocker) {
            context.setDrawerEnabled(true)
        }
    }

    override fun onResume() {
        super.onResume()
        var activity = this.activity
        if (activity is DrawerLocker) {
            activity.setDrawerEnabled(true)
        }
    }
}