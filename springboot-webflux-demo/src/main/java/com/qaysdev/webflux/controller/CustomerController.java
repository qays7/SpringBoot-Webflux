package com.qaysdev.webflux.controller;

import com.qaysdev.webflux.dto.Customer;
import com.qaysdev.webflux.entity.PatientDoctorChats;
import com.qaysdev.webflux.service.CustomerService;
import com.qaysdev.webflux.service.PatientDoctorChatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Autowired
    private PatientDoctorChatsService patientDoctorChatsService;


    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.loadAllCustomers();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return service.loadAllCustomersStream();
    }
    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PatientDoctorChats> getChat() {
        return patientDoctorChatsService.loadAllCustomersStream();
    }

    @GetMapping("/add")
    @ResponseBody
    public Mono<PatientDoctorChats> add() {
        return patientDoctorChatsService.add();
    }
}
