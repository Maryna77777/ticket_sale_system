package com.example.tickets;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperUtil {
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
    public static <R, E> List<R> convertList(List<E> list, Function<E, R> converter) {
        return list.stream().map(e -> converter.apply(e)).collect(Collectors.toList());
    }
}

