package com.markoapps.testserviceproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.markoapps.testserviceproject.R
import com.markoapps.testserviceproject.model.AppModel
import kotlinx.android.synthetic.main.fragment_app_details.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AppDetailsFragment : Fragment() {

    val args: AppDetailsFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val app = args.appDetails
        refreshUi(app)

    }

    private fun refreshUi(app: AppModel) {
        packageName.text = app.packageName
        title.text = app.title
        rating.text = app.rating.toString()
        developer.text = app.developer
        what_is_new.text = app.whatIsNew
        Glide
                .with(this)
                .load(app.icon)
                .centerCrop()
                .into(icon);
    }
}