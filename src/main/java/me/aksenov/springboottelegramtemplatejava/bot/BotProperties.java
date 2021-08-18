package me.aksenov.springboottelegramtemplatejava.bot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "bot")
public class BotProperties {
    private String username;
    private String token;
}