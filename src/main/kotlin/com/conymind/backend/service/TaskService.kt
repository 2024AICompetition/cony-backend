package com.conymind.backend.service

import com.conymind.backend.entity.TaskEntity
import com.conymind.backend.entity.toTask
import com.conymind.backend.model.Task
import com.conymind.backend.repository.ProfileRepository
import com.conymind.backend.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val profileRepository: ProfileRepository, private val taskRepository: TaskRepository) {

    fun getAllTasks(uid : String): List<Task> = taskRepository.findAllByProfileUid(uid).map {
        it.toTask()
    }
    fun createTask(uid : String, content: String): Task {
        val profile = profileRepository.findByUid(uid) ?: throw NoSuchElementException("Profile not found")
        return taskRepository.save(TaskEntity(profile = profile, content = content)).toTask()
    }

    fun updateTask(currentUserUid : String, id: Long, content: String, completed: Boolean): Task {
        val task = taskRepository.getReferenceById(id)
        if (task.profile.uid != currentUserUid) throw IllegalAccessException("You are not allowed to update this task")

        task.content = content
        task.completed = completed
        return taskRepository.save(task).toTask()
    }

    fun deleteTask(currentUserUid : String, id: Long) {
        val task = taskRepository.getReferenceById(id)
        if (task.profile.uid != currentUserUid) throw IllegalAccessException("You are not allowed to delete this task")

        taskRepository.deleteById(id)
    }
}