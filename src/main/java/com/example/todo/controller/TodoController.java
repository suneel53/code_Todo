/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoH2Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TodoController{
    @Autowired
    private TodoH2Service ts;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return ts.getTodos();
    }

     @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {

        return ts.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {

        return ts.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {

        return ts.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable("id") int id) {

        ts.delete(id);
    }
}