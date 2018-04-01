package com.example.course.converter;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseConverter<T, K> {
    public T convert(K source) {
        if (source == null) {
            return null;
        }
        return convertOrNull(source);
    }

    protected abstract T convertOrNull(K source);
}
