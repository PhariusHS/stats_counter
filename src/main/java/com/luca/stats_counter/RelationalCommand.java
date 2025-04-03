package com.luca.stats_counter;

import org.springframework.http.ResponseEntity;

public interface RelationalCommand<Input, Output, RelationalInput> {
    ResponseEntity<Output> execute(Input input, RelationalInput secondInput, RelationalInput thirdInput);
}