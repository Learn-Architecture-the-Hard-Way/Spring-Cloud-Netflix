package com.ttmo.springboot.controller;

import com.ttmo.api.domain.B;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@RestController
public class BController {

    Map<Integer, B> map;

    BController() {
        map = new HashMap<>() {
            {
                for (int i = 0; i < 3; i++) {
                    put(i, new B(i, String.valueOf(i)));
                }
            }
        };
    }


    @GetMapping("{id}")
    B get(@PathVariable("id") Integer id) {
        return map.get(id);
    }

    @GetMapping
    List<B> get() {
        return new ArrayList<>(map.values());
    }

    @PostMapping
    boolean add(B b) {
        map.put(b.getId(), b);
        return true;
    }

}
