package com.example.jpa.service;

import com.example.jpa.repository.TodoRepository;
import com.example.jpa.vo.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(e -> todos.add(e));

        return todos;
    }

    public Optional<Todo> findById(Long todoId) {
        return todoRepository.findById(todoId);
    }
    
    public void deleteById(Long todoId) {
        todoRepository.deleteById(todoId);
    }
    
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
    
    public Optional<Todo> updateById(Long todoId, Todo todo) {
        Optional<Todo> foundTodo = todoRepository.findById(todoId);
        
        if (foundTodo.isPresent()) {
            Todo todo1 = foundTodo.get();
            todo1.setStatus(todo.getStatus());
            todo1.setTitle(todo.getTitle());
            todoRepository.save(todo1);

            return foundTodo;
        }

        return Optional.empty();
    }

}
