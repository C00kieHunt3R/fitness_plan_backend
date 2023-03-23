package org.ssau.fitness_plan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchEntityIdException extends RuntimeException {
    public NoSuchEntityIdException(String entityName,  Long id) {
        super(
                String.format("Сущность [%s] с ID [%d] не существует", entityName, id)
        );
    }
}
