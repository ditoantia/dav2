package com.learn.antia.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.antia.R
import com.learn.antia.adapters.Todo
import com.learn.antia.adapters.TodoAdapter

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var todoAdapter: TodoAdapter

    private val todoList = mutableListOf(
        Todo(0, "Todo 1", false),
        Todo(1, "Todo 2", false),
        Todo(2, "Todo 3", false),
        Todo(3, "Todo 4", false),
        Todo(4, "Todo 5", false),
        Todo(5, "Todo 6", false),
        Todo(6, "Todo 7", false),
        Todo(7, "Todo 8", false),
        Todo(8, "Todo 9", false),
        Todo(9, "Todo 10", false),
        Todo(10, "Todo 11", false),
        Todo(11, "Todo 12", false),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        recyclerView  = view.findViewById(R.id.todoRecyclerView)

        todoAdapter = TodoAdapter(todoList) { todo ->
            // Handle task completion changes
            println("Task '${todo.task}' is completed: ${todo.isCompleted}")
        }
        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
    }
}
