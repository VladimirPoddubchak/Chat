package com.poddubchak.chat.back.repositories;

import com.poddubchak.chat.back.model.ChatMsg;
import com.poddubchak.chat.back.model.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MsgRepository extends CrudRepository<ChatMsg,Long> {
    List<ChatMsg> fromUserIsNull();

    List<ChatMsg> fromUserIs(ChatUser chatUser);
    List<ChatMsg> toUserIs(ChatUser chatUser);
}
