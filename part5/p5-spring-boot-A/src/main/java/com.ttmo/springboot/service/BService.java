package com.ttmo.springboot.service;

import com.ttmo.api.domain.B;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@FeignClient("SPRING-BOOT-B")
public interface BService {

    @GetMapping("{id}")
    B get(@PathVariable("id") Integer id);

    @GetMapping
    List<B> get();

    @PostMapping
    boolean add(B b);

}
