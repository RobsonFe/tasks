package br.com.robson.tasks.controller;

import br.com.robson.tasks.model.Task;
import br.com.robson.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @RequestMapping("/test")
    public String test() {
        return "API OK!!!";
    }

    @GetMapping("/list")
    public Mono<List<Task>> list() {
        return service.list();
    }

    @PostMapping("/save")
    public Mono<Task> save(@RequestBody Task task) {
        return service.insert(task);
    }
}
