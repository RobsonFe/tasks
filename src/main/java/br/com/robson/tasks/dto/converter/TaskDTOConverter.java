package br.com.robson.tasks.dto.converter;

import br.com.robson.tasks.dto.TaskDTO;
import br.com.robson.tasks.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskDTOConverter {

    public TaskDTO convert(Task task){
        return Optional.ofNullable(task)
                .map(source -> {
                    TaskDTO dto = new TaskDTO();
                    dto.setTitle(source.getTitle());
                    dto.setDescription(source.getDescription());
                    dto.setPriority(source.getPriority());
                    dto.setState(source.getState());
                    return dto;
                })
                .orElse(null);
    }

    public Task convert(TaskDTO dto){
        return Optional.ofNullable(dto)
                .map(source -> Task.builder()
                    .title(source.getTitle())
                    .description(source.getDescription())
                    .priority(source.getPriority())
                    .state(source.getState())
                    .build())
                .orElse(null);
    }

    public List<TaskDTO> convertList(List<Task> tasks){
        return Optional.ofNullable(tasks)
                .map(array -> array.stream().map(this::convert).collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }
}
