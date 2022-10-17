package com.qaysdev.webflux.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;

@Data
@Entity
@Table(name = "PATIENT_DOCTOR_CHATS")
@IdClass(PatientDoctorChatsId.class)
public class PatientDoctorChats {

    public PatientDoctorChats() {
    }

    @Id
    @Column(name = "CHAT_ID")
    private BigDecimal chatId;

    @Id
    @Column(name = "MESSAGE_SEQ")
    private BigDecimal messageSeq;

    @Column(name = "HOSPITAL_ID")
    private BigDecimal hospitalId;

    @Column(name = "EPISODE_NO")
    private BigDecimal episodeNo;

    @Column(name = "PATIENT_ID")
    private BigDecimal patientId;

    @Column(name = "DOCTOR_ID")
    private String doctorId;

    @Column(name = "MESSAGE_TEXT")
    private String messageText;

    @Column(name = "STATUS")
    private String status;

    @DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
    @Column(name = "SENT_DATETIME")
    private LocalDateTime sentDateTime;

    @DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
    @Column(name = "SEEN_DATETIME")
    private LocalDateTime seenDateTime;

    @Column(name = "SENT_BY")
    private String sentBy;

    @Override
    public String toString() {
        return "PatientDoctorChats{" +
                "chatId=" + chatId +
                ", messageSeq=" + messageSeq +
                ", hospitalId='" + hospitalId + '\'' +
                ", episodeNo=" + episodeNo +
                ", messageText='" + messageText + '\'' +
                ", status='" + status + '\'' +
                ", sentDateTime=" + sentDateTime +
                ", seenDateTime=" + seenDateTime +
                ", sentBy='" + sentBy + '\'' +
                '}';
    }

}