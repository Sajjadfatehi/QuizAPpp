package com.example.quizapp.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ItemCoronaListBinding
import com.example.quizapp.news.data.modelfromservice.AllCountry
import com.example.quizapp.news.data.modelfromservice.AllCountryItem
import com.example.quizapp.news.ui.ClickListener

class CoronaListAdapter(var allCountryItem :List<AllCountryItem>,val clickListener: ClickListener) :RecyclerView.Adapter<CoronaListAdapter.CoronaListViewHolder>() {

    inner class CoronaListViewHolder(var binding:ItemCoronaListBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.itemCardView.setOnClickListener {
                clickListener.onCardClick(allCountryItem[layoutPosition])
            }
        }
//
//        init {
//
//            binding.itemIconMenuTagPotProf.setOnClickListener {
//                clickListener.onClick(differ.currentList[layoutPosition], layoutPosition)
//            }
//            binding.cardItem.setOnClickListener {
//                clickListener.onCardClick(differ.currentList[layoutPosition], layoutPosition)
//            }
//            binding.itemImagePostProf.setOnClickListener {
//                clickListener.onImageClick(differ.currentList[layoutPosition].userEntity)
//            }
//            binding.likePost.setOnClickListener {
//                clickListener.onLikeClick()
//            }
//            binding.favoriteIc.setOnClickListener {
//                clickListener.onBookMarkClick(differ.currentList[layoutPosition].articleDataEntity.slug,
//                    differ.currentList[layoutPosition].articleDataEntity.favorited,layoutPosition)
//            }
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaListViewHolder {

        val inflater =LayoutInflater.from(parent.context)
        val itemBinding=ItemCoronaListBinding.inflate(inflater,parent,false)
        return CoronaListViewHolder(itemBinding)
    }

    override fun getItemCount()=allCountryItem.size

    override fun onBindViewHolder(holder: CoronaListViewHolder, position: Int) {

        val allCountryItem=allCountryItem[position]
        holder.binding.allCountryItem=allCountryItem


    }

}