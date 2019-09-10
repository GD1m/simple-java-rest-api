package ru.gdim.simple_java_rest_api.service.resource_version;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.gdim.simple_java_rest_api.service.catalog.exception.NotFoundException;
import ru.gdim.simple_java_rest_api.service.resource_version.exception.HttpRequestFailedException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

@Service
public final class ResourceVersionService {
    private final OkHttpClient okHttpClient;

    public ResourceVersionService(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public ResourceVersion tryToGet(@NotNull URL url) {
        Response headResponse = getHeadResponse(url);

        return tryToGetResourceVersion(headResponse, url);
    }

    private Response getHeadResponse(@NotNull URL url) {
        Request request = new Request.Builder()
                .url(url)
                .head()
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (Objects.equals(response.code(), HttpURLConnection.HTTP_NOT_FOUND)) {
                throw new NotFoundException(url);
            }

            if (!response.isSuccessful()) {
                throw new HttpRequestFailedException("Unexpected response code: " + response);
            }

            return response;
        } catch (IOException e) {
            throw new HttpRequestFailedException("Failed to get HEAD response from url: " + request.url(), e);
        }
    }

    private ResourceVersion tryToGetResourceVersion(@NotNull Response response, @NotNull URL url) {
        String eTag = response.header("ETag");
        String lastModified = response.header("Last-Modified");

        if (null == eTag || null == lastModified) {
            return null;
        }

        return new ResourceVersion(url, eTag, lastModified);
    }
}
