package com.afs.restapi.service;

import com.afs.restapi.advice.ErrorResponse;
import com.afs.restapi.entity.Todo;
import com.afs.restapi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }

    public Todo update(Integer id, Todo updatedTodo) {
        Todo tobeUpdatedTodo = todoRepository.findById(id).orElseThrow(RuntimeException::new);
        tobeUpdatedTodo.setDone(updatedTodo.getDone());
        return todoRepository.save(tobeUpdatedTodo);
    }
}
