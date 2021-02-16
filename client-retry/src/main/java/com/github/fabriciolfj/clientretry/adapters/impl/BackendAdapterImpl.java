package com.github.fabriciolfj.clientretry.adapters.impl;

import com.github.fabriciolfj.clientretry.adapters.BackendAdapter;
import com.github.fabriciolfj.clientretry.exceptions.RemoteServiceNotAvailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BackendAdapterImpl implements BackendAdapter {

    private final Logger logger = LoggerFactory.getLogger(BackendAdapterImpl.class);
    private static final String MSG = "Serviço encontra-se indisponível";

    @Override
    public String getBackendResponse(boolean simulaRetry, boolean simulaFallback) {
        if (simulaRetry) {
            if (simulaFallback) {
                logger.info("Simulando fallback");
                throw new RemoteServiceNotAvailableException(MSG);
            }

            int random = new Random().nextInt(4);

            if (random % 2 == 0) {
                logger.info("Simulando retry");
                throw new RemoteServiceNotAvailableException(MSG);
            }
        }

        return "ok";
    }

    @Override
    public String getBackendResponseFallback(RemoteServiceNotAvailableException e) {
        return "Todas as retentativas foram feitas, fallback acionado";
    }
}
