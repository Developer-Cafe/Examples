package com.developercafe.handlers;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ButtonInteractionHandler extends ListenerAdapter {

    public void onButtonInteraction(ButtonInteractionEvent event) {

        /*switch (event.getButton().getId()) {

            case "openRequest" -> event.getInteraction().getChannel().delete().queue();

        }*/

    }

}
