package com.idealista.android.challenge.list.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.core.view.FavouritesCheck
import com.idealista.android.challenge.list.R
import com.squareup.picasso.Picasso

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    interface AdListener {

        fun onAdClicked(ad: AdModel)

        fun onAdFavouriteButtonClicked(
            position: Int,
            adId: String,
            isFavourite: Boolean
        )

    }

    private var ads: MutableList<AdModel> = ArrayList()
    private lateinit var listener: AdListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_ad, parent, false)
        return ListViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = ads.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        with(ads[position]) {
            if (thumbnail.isNotEmpty()) Picasso.with(holder.image.context).load(thumbnail)
                .into(holder.image)
            holder.parent.setOnClickListener { listener.onAdClicked(this) }
            holder.title.text = title
            holder.price.text = price
            holder.favourite.isChecked = isFavourite
            holder.favourite.setOnClickListener {
                isFavourite = holder.favourite.isChecked
                listener.onAdFavouriteButtonClicked(
                    holder.adapterPosition,
                    id,
                    holder.favourite.isChecked)
            }
        }
    }

    fun set(listModel: ListModel) {
        val diffResult = DiffUtil.calculateDiff(ListDiffCallBack(ads, listModel.ads))
        ads.clear()
        ads.addAll(listModel.ads)
        diffResult.dispatchUpdatesTo(this)
    }

    fun listener(listener: AdListener) {
        this.listener = listener
    }

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.ivAd)
        var title: TextView = view.findViewById(R.id.tvTitle)
        var price: TextView = view.findViewById(R.id.tvPrice)
        var favourite: FavouritesCheck = view.findViewById(R.id.cvFavourite)
        var parent: View = view.findViewById(R.id.parent)
    }

    class ListDiffCallBack(
        private val oldList: List<AdModel>,
        private val newList: List<AdModel>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id


        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

}