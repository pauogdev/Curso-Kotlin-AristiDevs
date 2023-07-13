package com.pauortegarcia.cursokotlin.todoapp

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pauortegarcia.cursokotlin.R
import com.pauortegarcia.cursokotlin.databinding.ItemTaskCategoriesBinding

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemTaskCategoriesBinding.bind(view)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        var color = if (taskCategory.isSelected) {
            R.color.background_card
        } else {
            R.color.background_disabled
        }

        binding.viewConteiner.setCardBackgroundColor(ContextCompat.getColor(binding.viewConteiner.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Business -> {
                binding.tvCategoryName.text = "Negocios"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor(binding.divider.context, R.color.business_category)
                )

            }

            TaskCategory.Other -> {
                binding.tvCategoryName.text = "Otros"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor(binding.divider.context, R.color.other_category)
                )
            }

            TaskCategory.Personal -> {
                binding.tvCategoryName.text = "Personal"
                binding.divider.setBackgroundColor(
                    ContextCompat.getColor(binding.divider.context, R.color.personal_category)
                )
            }
        }


    }
}