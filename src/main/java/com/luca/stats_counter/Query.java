package com.luca.stats_counter;

import org.springframework.http.ResponseEntity;

public interface Query<Input, Output> {
    ResponseEntity<Output> execute(Input input);
}