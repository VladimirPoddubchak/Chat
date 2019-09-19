package com.poddubchak.chat.back.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String msg;

    @ManyToOne
    private ChatUser fromUser;
    @ManyToOne
    private ChatUser toUser;
    private Date date;
    private Boolean isPrivate;
}
