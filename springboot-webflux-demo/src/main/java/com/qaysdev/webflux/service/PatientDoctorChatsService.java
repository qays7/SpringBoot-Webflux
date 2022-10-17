package com.qaysdev.webflux.service;

import com.qaysdev.webflux.entity.PatientDoctorChats;
import com.qaysdev.webflux.repository.PatientDoctorChatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class PatientDoctorChatsService {

    @Autowired
    private PatientDoctorChatsRepository patientDoctorChatsRepository;

    public Flux<PatientDoctorChats> loadAllCustomersStream() {
        return Flux.defer(() -> Flux.fromIterable(patientDoctorChatsRepository
                        .findAll()
                        .stream()
                        .sorted(Comparator.comparing(PatientDoctorChats::getMessageSeq))
                        .collect(Collectors.toList())))
                .subscribeOn(Schedulers.elastic());
    }

    public Mono<PatientDoctorChats> add() {
        return Mono.fromCallable(() -> {
            PatientDoctorChats chat = new PatientDoctorChats();
            chat.setHospitalId(BigDecimal.valueOf(1L));
            chat.setChatId(BigDecimal.valueOf(1L));
            chat.setMessageSeq(BigDecimal.valueOf(34L));
            chat.setPatientId(BigDecimal.valueOf(360529L));
            chat.setEpisodeNo(BigDecimal.valueOf(13L));
            chat.setDoctorId("066");
            chat.setMessageText("Last reactive message");
            chat.setStatus("NEW");
            chat.setSentBy("PATIENT");
            chat.setSentDateTime(LocalDateTime.now());
            return patientDoctorChatsRepository.save(chat);
        }).subscribeOn(Schedulers.elastic());
    }


}
