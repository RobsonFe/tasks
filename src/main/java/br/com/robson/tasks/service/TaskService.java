package br.com.robson.tasks.service;

import br.com.robson.tasks.model.Task;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TaskService {

    public static List<Task> taskList;

    public Mono<Task> insert(Task task){
        return Mono.just(task)
                .flatMap(it -> this.save(it));
    }

    private Mono<Task> save(Task task){
        return Mono.just(task)
                .map(Task::newTask);
    }
}
