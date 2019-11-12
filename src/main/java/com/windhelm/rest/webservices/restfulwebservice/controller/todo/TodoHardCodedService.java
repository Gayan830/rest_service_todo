package com.windhelm.rest.webservices.restfulwebservice.controller.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 3;

    static {
        todos.add(new Todo(1, "Gayan", "Learn to Drive", new Date(),false));
        todos.add(new Todo(2, "Gayan", "Learn Angular 8", new Date(),false));
        todos.add(new Todo(3, "Gayan", "Learn Spring boot", new Date(),false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        todos.remove(todo);
        return todo;
    }

    public Todo save(Todo todo){
        if(todo.getId()== -1 || todo.getId()== 0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo findById(long id) {
        for(Todo todo: todos){
            if(todo.getId() == id){
                System.out.println(todo);
                return todo;
            }

        }
        return null;
    }
}
