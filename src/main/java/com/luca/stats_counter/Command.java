package com.luca.stats_counter;

import org.springframework.http.ResponseEntity;

public interface Command<Input, Output> {
    ResponseEntity<Output> execute(Input input);
}