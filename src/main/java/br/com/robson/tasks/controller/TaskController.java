package br.com.robson.tasks.controller;

import br.com.robson.tasks.dto.TaskDTO;
import br.com.robson.tasks.dto.converter.TaskDTOConverter;
import br.com.robson.tasks.model.Task;
import br.com.robson.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;
    private final TaskDTOConverter  converter;

    public TaskController(TaskService service, TaskDTOConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @RequestMapping("/test")
    public String test() {
        return "API OK!!!";
    }

    @GetMapping("/list")
    public Mono<List<TaskDTO>> list() {
        return service.list()
                .map(converter::convertList);
    }

    @PostMapping("/save")
    public Mono<TaskDTO> save(@RequestBody Task task) {
        return service.insert(task)
                .map(converter::convert);
    }
}
