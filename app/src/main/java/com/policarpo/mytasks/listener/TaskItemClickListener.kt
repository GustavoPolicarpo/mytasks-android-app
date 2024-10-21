package com.policarpo.mytasks.listener

import com.policarpo.mytasks.entity.Task

interface TaskItemClickListener {

    fun onClick(task: Task)

    fun onMarkAsCompleteClick(position: Int, task: Task)

    fun onShareClick(task: Task)
}