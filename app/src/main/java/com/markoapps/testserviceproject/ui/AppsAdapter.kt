package com.markoapps.testserviceproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.markoapps.testserviceproject.R
import com.markoapps.testserviceproject.model.AppModel

import kotlinx.android.synthetic.main.item_app_row.view.*
import kotlinx.android.synthetic.main.item_app_row.view.developer
import kotlinx.android.synthetic.main.item_app_row.view.rating


class AppsAdapter(val onClick: (app: AppModel)-> Unit) : ListAdapter<AppModel, AppsAdapter.ViewHolder>(AppDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_app_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(appModel: AppModel) {
            itemView.appName.text = appModel.title
            itemView.developer.text = appModel.developer
            itemView.rating.numStars = 5
            itemView.rating.rating = appModel.rating
            itemView.setOnClickListener {
                onClick.invoke(appModel)
            }

            Glide
                .with(itemView)
                .load(appModel.icon)
                .centerCrop()
                .into(itemView.icon);
        }
    }

    class AppDiffUtil: DiffUtil.ItemCallback<AppModel>() {
        override fun areItemsTheSame(oldItem: AppModel, newItem: AppModel): Boolean {
            return oldItem.packageName == newItem.packageName
        }

        override fun areContentsTheSame(oldItem: AppModel, newItem: AppModel): Boolean {
            return oldItem == newItem
        }
    }
}