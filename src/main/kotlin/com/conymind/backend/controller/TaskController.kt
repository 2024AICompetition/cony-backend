package com.conymind.backend.controller

import com.conymind.backend.model.Task
import com.conymind.backend.model.api.UpdateTaskRequest
import com.conymind.backend.security.FirebaseUserDetails
import com.conymind.backend.service.TaskService
import org.hibernate.sql.Update
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasks(@AuthenticationPrincipal userDetails: FirebaseUserDetails): List<Task> = taskService.getAllTasks(userDetails.uid)

    @PostMapping
    fun createTask(@AuthenticationPrincipal userDetails: FirebaseUserDetails, @RequestBody task: UpdateTaskRequest): Task =
        taskService.createTask(uid = userDetails.uid, content = task.content)

    @PutMapping("/{id}")
    fun updateTask(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
        @PathVariable id: Long,
        @RequestBody updatedTask: UpdateTaskRequest
    ): Task =
        taskService.updateTask(
            currentUserUid = userDetails.uid,
            id = id,
            content = updatedTask.content,
            completed = updatedTask.completed
        )

    @DeleteMapping("/{id}")
    fun deleteTask(@AuthenticationPrincipal userDetails: FirebaseUserDetails, @PathVariable id: Long) =
        taskService.deleteTask(currentUserUid = userDetails.uid, id = id)
}