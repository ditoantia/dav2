package com.learn.antia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learn.antia.R

data class Todo(
    val id: Int,
    var task: String,
    var isCompleted: Boolean = false
)

class TodoAdapter(
    private val todoList: MutableList<Todo>,
    private val onCheckChanged: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.bind(todo)
    }

    override fun getItemCount(): Int = todoList.size

    fun addTodo(todo: Todo) {
        todoList.add(todo)
        notifyItemInserted(todoList.size - 1)
    }

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskText: TextView = itemView.findViewById(R.id.taskText)
        private val checkBox: CheckBox = itemView.findViewById(R.id.taskCheckbox)

        fun bind(todo: Todo) {
            taskText.text = todo.task
            checkBox.isChecked = todo.isCompleted

            // Update completion status when the checkbox changes
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                todo.isCompleted = isChecked
                onCheckChanged(todo)
            }
        }
    }
}
