package com.tongyl.example.jdemosb.controller;

import com.tongyl.example.jdemosb.service.task.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 异步调用示例
 * @author create by Tunyl on 2020/1/14
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/movies")
    public String completableFutureTask() {
        long start = System.currentTimeMillis();
        List<String> words = Arrays.asList("F","T","Z","S","J","C");
        List<CompletableFuture<List<String>>> completableFutureList = words.stream()
                .map(word -> asyncService.completableFutureTask(word))
                .collect(Collectors.toList());
        List<List<String>> results = completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        //CompletableFuture.join() 等待结果
        System.out.println("Elapsed Time:" + (System.currentTimeMillis() - start));
        return results.toString();
    }
}
