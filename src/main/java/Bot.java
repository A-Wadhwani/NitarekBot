import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.rest.request.RouterOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;


public class Bot {
    public static void main(String[] args) {
        String token = "";
        String catApi = "";
        try {
            BufferedReader fr = new BufferedReader(new FileReader("src/SecretToken.txt"));
            token = fr.readLine();
            catApi = fr.readLine();

        } catch (IOException ignored){
        }
        final DiscordClient client = DiscordClientBuilder.create(token).build();
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(ready -> System.out.println("Logged in as " + ready.getSelf().getUsername()));
        createEvent(client, new BotPing());
        createEvent(client, new BotCat());
        createEvent(client, new BotHelp());
        client.login().block();
    }

    public synchronized static void createEvent(DiscordClient client, BotEvent event){
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .filter(msg -> msg.getContent().map(event.getInput()::equals).orElse(false))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(event.getOutputMessage()))
                .subscribe();
    }

}
