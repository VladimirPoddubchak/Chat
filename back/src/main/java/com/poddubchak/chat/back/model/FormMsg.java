package com.poddubchak.chat.back.model;

import lombok.Data;

import java.util.Date;
@Data
public class FormMsg {
    private String msg;
    private Long fromUserId;
    private Long toUserId;
    private Date date;
    private Boolean isPrivate;
}
