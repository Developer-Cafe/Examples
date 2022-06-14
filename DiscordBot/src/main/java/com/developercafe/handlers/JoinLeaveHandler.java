package com.developercafe.handlers;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class JoinLeaveHandler extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        MessageEmbed embed = new EmbedBuilder()
                .setTitle("Neues Mitglied")
                .setDescription("Willkommen " + event.getMember().getAsMention())
                .setColor(Color.BLUE)
                .setTimestamp(Instant.now())
                .build();

        event.getGuild().getTextChannelById("958792366574149752").sendMessageEmbeds(embed).queue();
    }

    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        MessageEmbed embed = new EmbedBuilder()
                .setTitle("Bye Bye")
                .setDescription("Alles gute <@" + event.getUser().getId() + ">")
                .setColor(Color.BLUE)
                .setTimestamp(Instant.now())
                .build();

        event.getGuild().getTextChannelById("958792366574149752").sendMessageEmbeds(embed).queue();
    }


}
