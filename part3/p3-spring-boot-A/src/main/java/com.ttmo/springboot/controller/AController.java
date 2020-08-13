package com.ttmo.springboot.controller;

import com.ttmo.api.domain.B;
import com.ttmo.springboot.domain.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class AController {

    @Autowired
    RestTemplate restTemplate;

    Map<Integer, A> map;

    AController() {
        map = new HashMap<>() {
            {
                for (int i = 0; i < 3; i++) {
                    put(i, new A(i, String.valueOf(i)));
                }
            }
        };
    }


    @GetMapping("{id}")
    A get(@PathVariable("id") Integer id) {
        return map.get(id);
    }

    @GetMapping
    List<A> get() {
        return new ArrayList<>(map.values());
    }

    @PostMapping
    boolean add(A a) {
        map.put(a.getId(), a);
        return true;
    }

    private final String URL_B = "http://spring-boot-B-1:8081/";

    @GetMapping("b/{id}")
    B getB(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(URL_B + id, B.class);
    }

    @GetMapping("b")
    List<B> getB() {
        return restTemplate.getForObject(URL_B, List.class);
    }

    @PostMapping("b")
    Boolean addB(B b) {
        return restTemplate.postForObject(URL_B, b, Boolean.class);
    }

}
