package com.qaysdev.webflux.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PatientDoctorChatsId implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private BigDecimal chatId;

    private BigDecimal messageSeq;

    public PatientDoctorChatsId() {
    }

    public PatientDoctorChatsId(BigDecimal chatId, BigDecimal messageSeq) {
        this.chatId = chatId;
        this.messageSeq = messageSeq;
    }

    @Override
    public String toString() {
        return "PatientTeamChatsId [teamChatId=" + chatId + ", messageSeq=" + messageSeq + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((messageSeq == null) ? 0 : messageSeq.hashCode());
        result = prime * result + ((chatId == null) ? 0 : chatId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PatientDoctorChatsId other = (PatientDoctorChatsId) obj;
        if (messageSeq == null) {
            if (other.messageSeq != null)
                return false;
        } else if (!messageSeq.equals(other.messageSeq))
            return false;
        if (chatId == null) {
            if (other.chatId != null)
                return false;
        } else if (!chatId.equals(other.chatId))
            return false;
        return true;
    }
}