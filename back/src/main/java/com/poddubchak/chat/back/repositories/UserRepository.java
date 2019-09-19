package com.poddubchak.chat.back.repositories;

import com.poddubchak.chat.back.model.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<ChatUser,Long> {

    Optional<ChatUser>findByLogin(String login);
    List<ChatUser> isOnlineIsTrue();


}
