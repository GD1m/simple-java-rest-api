package ru.gdim.simple_java_rest_api.application.utils;

import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public final class Url {
    @NotNull
    public static URL make(@NotNull String url) {
        try {
            return new URL(url);
        } catch (Throwable e) {
            throw new RuntimeException("Input data validation problem. Failed to create URL from given string: " + url);
        }
    }

    @NotNull
    public static List<URL> make(@NotNull List<String> urls) {
        return urls
                .stream()
                .map(Url::make)
                .collect(Collectors.toList());
    }
}
