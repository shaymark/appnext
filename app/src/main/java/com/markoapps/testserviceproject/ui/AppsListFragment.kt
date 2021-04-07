package com.markoapps.testserviceproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.markoapps.testserviceproject.R
import com.markoapps.testserviceproject.di.Provider
import com.markoapps.testserviceproject.viewmodels.AppsViewModel
import kotlinx.android.synthetic.main.fragment_app_list.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AppsListFragment : Fragment() {

    val appsAdapter: AppsAdapter = AppsAdapter {
        val action = AppsListFragmentDirections.actionAppsListFragmentToAppDetailsFragment(it)
        findNavController().navigate(action)
    }

    val viewModel: AppsViewModel by viewModels { Provider.servicesViewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = appsAdapter
        }

        viewModel.appsLiveData.observe(viewLifecycleOwner) {
            appsAdapter.submitList(it)
        }

    }
}