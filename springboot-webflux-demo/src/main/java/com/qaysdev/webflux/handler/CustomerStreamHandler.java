package com.qaysdev.webflux.handler;

import com.qaysdev.webflux.dao.CustomerDao;
import com.qaysdev.webflux.dto.Customer;
import com.qaysdev.webflux.entity.PatientDoctorChats;
import com.qaysdev.webflux.service.CustomerService;
import com.qaysdev.webflux.service.PatientDoctorChatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class CustomerStreamHandler {

    @Autowired
    private PatientDoctorChatsService patientDoctorChatsService;

    @Autowired
    private CustomerDao dao;


    public Mono<ServerResponse> getCustomers(ServerRequest request) {
        Flux<Customer> customersStream = dao.getCustomersStream();
        return ServerResponse.ok().
                contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customersStream, Customer.class);
    }



    public Mono<ServerResponse> loadAllCustomersStream(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(patientDoctorChatsService.loadAllCustomersStream(), PatientDoctorChats.class);
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        return ServerResponse.ok().body(patientDoctorChatsService.add(), PatientDoctorChats.class);
    }
}
