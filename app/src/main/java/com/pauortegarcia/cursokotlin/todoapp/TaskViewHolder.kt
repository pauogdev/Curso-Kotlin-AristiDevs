package com.pauortegarcia.cursokotlin.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pauortegarcia.cursokotlin.R
import com.pauortegarcia.cursokotlin.databinding.ItemTodoTaskBinding

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemTodoTaskBinding.bind(view)

    fun render(task: Task) {
        // if para tachar o destachar el texto en un TextView
        if (task.isSelected) {
            binding.tvTask.paintFlags = binding.tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            binding.tvTask.paintFlags =
                binding.tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        binding.tvTask.text = task.name
        binding.cbTask.isChecked = task.isSelected

        val color = when (task.category) {
            TaskCategory.Business -> R.color.business_category
            TaskCategory.Other -> R.color.other_category
            TaskCategory.Personal -> R.color.personal_category
        }

        binding.cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(
                binding.tvTask.context,
                color
            )
        )


    }
}