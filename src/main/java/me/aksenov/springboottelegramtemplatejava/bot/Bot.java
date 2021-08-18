package me.aksenov.springboottelegramtemplatejava.bot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.aksenov.springboottelegramtemplatejava.service.LogicHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@AllArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private final BotProperties properties;
    private final LogicHandler logicHandler;

    @Override
    public String getBotUsername() {
        return properties.getUsername();
    }

    @Override
    public String getBotToken() {
        return properties.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info(update.toString());
        logicHandler.handleUpdate(update);
    }

    @PostConstruct
    public void startup() throws TelegramApiException {
        log.info(properties.getUsername() + " bot starting...");
        new TelegramBotsApi(DefaultBotSession.class).registerBot(this);
        log.info(properties.getUsername() + " started!");
    }
}
