package com.github.fabriciolfj.clientretry.adapters;

import com.github.fabriciolfj.clientretry.exceptions.RemoteServiceNotAvailableException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface BackendAdapter {

    @Retryable(value = {RemoteServiceNotAvailableException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    String getBackendResponse(boolean simulaRetry, boolean simulaFallback);

    @Recover
    String getBackendResponseFallback(RemoteServiceNotAvailableException e);
}
