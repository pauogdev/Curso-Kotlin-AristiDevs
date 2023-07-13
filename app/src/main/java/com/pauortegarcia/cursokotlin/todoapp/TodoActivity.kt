package com.pauortegarcia.cursokotlin.todoapp

import android.app.Dialog
import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauortegarcia.cursokotlin.R
import com.pauortegarcia.cursokotlin.databinding.ActivityTodoBinding
import com.pauortegarcia.cursokotlin.databinding.DialogTaskBinding
import com.pauortegarcia.cursokotlin.todoapp.TaskCategory.*

class TodoActivity : AppCompatActivity() {
    private var listCategories = listOf(
        Business,
        Personal,
        Other
    )

    private var listTasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOtros", Other)

    )

    private lateinit var binding: ActivityTodoBinding
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var tasksAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
        initListeners()
    }


    private fun initUi() {
        categoriesAdapter = CategoriesAdapter(listCategories) { updateCategories(it) }
        binding.rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoriesAdapter

        tasksAdapter = TaskAdapter(listTasks) { onItemSelected(it) }
        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        binding.rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int) { //función lambda
        listTasks[position].isSelected = !listTasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position: Int) {
        listCategories[position].isSelected = !listCategories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun initListeners() {
        binding.fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        /* val bdDialog = DialogTaskBinding.inflate(layoutInflater)
         dialog.setContentView(bdDialog.root)*/

        val btAddTask = dialog.findViewById<Button>(R.id.btAddTask)
        val rgCategories = dialog.findViewById<RadioGroup>(R.id.rgCategories)
        val etTask = dialog.findViewById<EditText>(R.id.etTask)

        btAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_negocios) -> Business
                    getString(R.string.todo_personal) -> Personal
                    else -> Other
                }

                listTasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun updateTasks() { //notificar cambias al adapter
        val selectedCategories: List<TaskCategory> = listCategories.filter { it.isSelected }
        val newTasks = listTasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}