package com.github.fabriciolfj.clientretry.api;

import com.github.fabriciolfj.clientretry.adapters.BackendAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry")
public class HelloController {

    @Autowired
    private BackendAdapter backendAdapter;

    @GetMapping
    @ExceptionHandler({ Exception.class })
    public String validaSpringRetryCapacidade(@RequestParam(required = false) boolean simulaRetry, @RequestParam(required = false) boolean simulaFallback) {
        return backendAdapter.getBackendResponse(simulaRetry, simulaFallback);
    }
}
