package com.developercafe;

import com.developercafe.files.Config;
import com.developercafe.handlers.ButtonInteractionHandler;
import com.developercafe.handlers.JoinLeaveHandler;
import com.developercafe.handlers.SlashCommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.EnumSet;

public class Main {
    private static JDA bot;

    public static void main(String[] args) throws IOException, LoginException {
        Config.init();


        System.out.println(Config.getTicketCounter());
        Config.setTicketCounter(Config.getTicketCounter() + 1);
        System.out.println(Config.getTicketCounter());


        EnumSet<GatewayIntent> intents = EnumSet.of(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES);
        bot = JDABuilder.createDefault(Config.getToken(), intents)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.playing("Made with \u2764\uFE0F"))
                .addEventListeners(new SlashCommandHandler())
                .addEventListeners(new ButtonInteractionHandler())
                .addEventListeners(new JoinLeaveHandler())
                .build();
        CommandListUpdateAction commands = bot.updateCommands();
        commands.addCommands(
                Commands.slash("github", "github link"),
                Commands.slash("test", "macht alles oder nichts")
        ).queue();
    }

    public static JDA getBot() {
        return bot;
    }
}