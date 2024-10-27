package com.policarpo.mytasks.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.policarpo.mytasks.R
import com.policarpo.mytasks.databinding.TaskListItemBinding
import com.policarpo.mytasks.entity.Task
import com.policarpo.mytasks.fragment.PreferenceFragment
import com.policarpo.mytasks.listener.TaskItemClickListener
import java.time.format.DateTimeFormatter
import java.util.Locale

class TaskViewHolder(
    private val context: Context,
    private val binding: TaskListItemBinding,
    private val listener: TaskItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun setValues(task: Task) {
        binding.tvTitle.text = task.title

        if (task.completed) {
            binding.tvTitle.setBackgroundResource(R.color.green_700)
        } else {
            binding.tvTitle.setBackgroundResource(R.color.blue_700)
        }

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val isFullDate = sharedPreferences.getBoolean(PreferenceFragment.DATE_FORMAT_KEY, false)

        binding.tvDate.text = task.date?.let {
            if (isFullDate){
                val fullDateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy", Locale.getDefault())
                task.date!!.format(fullDateFormatter)
            }else{
                task.date.toString()
            }
        } ?: run {
            "-"
        }

        binding.tvTime.text = task.time?.let {
            task.time.toString()
        } ?: run {
            "-"
        }

        binding.root.setOnClickListener {
            listener.onClick(task)
        }

        binding.root.setOnCreateContextMenuListener { menu, _, _ ->
            menu.add(ContextCompat.getString(context, R.string.mark_as_completed)).setOnMenuItemClickListener {
                listener.onMarkAsCompleteClick(adapterPosition, task)
                true
            }
            menu.add(ContextCompat.getString(context, R.string.share)).setOnMenuItemClickListener {
                listener.onShareClick(task)
                true
            }
        }
    }
}