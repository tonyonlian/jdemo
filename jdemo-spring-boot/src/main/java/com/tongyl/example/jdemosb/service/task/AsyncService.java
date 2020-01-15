package com.tongyl.example.jdemosb.service.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author create by Tunyl on 2020/1/13
 * @version 1.0
 */
@Slf4j
@Service
public class AsyncService {
    private List<String> movies = new ArrayList<>(Arrays.asList("Forrest Gump","Titanic","Spirted Away","The Shawshank Redemption","Zootopia","Farewell","Joker","Crawl"));
    @Async
    public CompletableFuture<List<String>> completableFutureTask(String start){
        log.warn(Thread.currentThread().getName() + "start this task");
        List<String> results = movies.stream()
                .filter(movie -> movie.startsWith(start))
                .collect(Collectors.toList());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(results);
    }


}
