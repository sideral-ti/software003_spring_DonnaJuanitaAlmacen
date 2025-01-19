package com.sideralti.app.controller_rest;

import com.sideralti.app.service.OrdenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/ordenes")
@RequiredArgsConstructor
@Slf4j
public class OrdenRestController {

    private final OrdenService ordenService;




}
