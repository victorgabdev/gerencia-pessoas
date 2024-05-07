package com.victorgabdev.gerenciapessoas.util;

import com.victorgabdev.gerenciapessoas.shared.exceptions.CustomException;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class ServiceUtils {
    public static <T> T checkEntityExists(Optional<T> entityOpt, String errorMessage) {
        return entityOpt.orElseThrow(() -> new CustomException(errorMessage, HttpStatus.NOT_FOUND));
    }
}
