package com.example.jpa.controller;

import com.example.jpa.service.TodoService;
import com.example.jpa.vo.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todo")
public class TodoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TodoService todoService;

    @GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Todo>> findAll() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{todoId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Todo> getTodo(@PathVariable("todoId") Long todoId) {
        Optional<Todo> todo = todoService.findById(todoId);

        return new ResponseEntity<Todo>(todo.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{todoId}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> delete(@PathVariable("todoId") Long todoId) {
        todoService.deleteById(todoId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(value = "/{todoId}",
            consumes = { MediaType.APPLICATION_JSON_VALUE},
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Todo> update(@PathVariable("todoId") Long todoId, @RequestBody Todo todo) {
        Optional<Todo> todo1 = todoService.updateById(todoId, todo);

        if (todo1.isPresent()) return new ResponseEntity<>(todo1.get(), HttpStatus.OK);
        else return new ResponseEntity<>(todo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.save(todo), HttpStatus.OK);
    }
}
