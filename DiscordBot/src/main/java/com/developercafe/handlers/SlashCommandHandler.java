package com.developercafe.handlers;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class SlashCommandHandler extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getGuild() == null) return;
        switch (event.getName()) {
            case "github" -> {
                MessageEmbed embed = new EmbedBuilder()
                        .setTitle("Github")
                        .setDescription("Der Bot wird aktiv von Jan T. und Tom H. entwickelt. Ihr könnt gerne mal auf Github vorbeischauen :)\n[Github](https://github.com/Developer-Cafe)")
                        .setTimestamp(Instant.now())
                        .setColor(Color.BLUE) //Such dir mal ne Farbe aus
                        .build();
                event.deferReply(false).addEmbeds(embed).queue();
            }

        }
    }
}
