package com.policarpo.mytasks.entity

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeParseException

data class TaskDto(
    var id: Long? = null,
    var title: String,
    var description: String? = null,
    var date: String? = null,
    var time: String? = null,
    var completed: Boolean = false
) : Serializable
{
    fun validateTask(): Pair<Boolean, String>{
        if(!TaskValidator.validateTitle(title))
            return Pair(false, "Missing Title");

        if(!TaskValidator.validateDate(date))
            return Pair(false, "Invalid date, please use yyyy-MM-dd");

        if(!TaskValidator.validateTime(time))
            return Pair(false, "Invalid time, please use HH:mm");

        return Pair(true, "");
    }

    fun toTask(): Task {
        return Task(
            id,
            title,
            description,
            if (!date.isNullOrEmpty()) LocalDate.parse(date) else null,
            if (!time.isNullOrEmpty()) LocalTime.parse(time) else null,
            completed
        )
    }
}

data class Task(
    var id: Long? = null,
    var title: String,
    var description: String? = null,
    var date: LocalDate? = null,
    var time: LocalTime? = null,
    var completed: Boolean = false
) : Serializable

object TaskValidator {
    fun validateTitle(title: String): Boolean {
        return title.isNotEmpty()
    }

    fun validateDate(date: String?): Boolean {
        if (date.isNullOrEmpty()) return true
        return try {
            LocalDate.parse(date)
            return true
        } catch (e: DateTimeParseException) {
            false
        }
    }

    fun validateTime(time: String?): Boolean {
        if (time.isNullOrEmpty()) return true
        return try {
            LocalTime.parse(time)
            return true
        } catch (e: DateTimeParseException) {
            false
        }
    }
}
