package me.aksenov.springboottelegramtemplatejava.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Service
public class LogicHandler {

    public void handleUpdate(Update update) {
        //your logic
    }
}
