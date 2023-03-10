package info.itsthesky.disky.core;

import info.itsthesky.disky.elements.components.core.ComponentRow;
import info.itsthesky.disky.managers.BotManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.components.Component;

import java.util.ArrayList;
import java.util.List;

public final class JDAUtils {

	public static MessageBuilder constructMessage(Object input) {
		if (input == null)
			return null;
		final MessageBuilder builder = new MessageBuilder();
		if (input instanceof MessageBuilder)
			return (MessageBuilder) input;
		if (input instanceof String)
			builder.append((String) input);
		if (input instanceof EmbedBuilder)
			builder.setEmbeds(((EmbedBuilder) input).build());
		return builder;
	}

	public static Component[] convert(ComponentRow[] rows) {
		final List<Component> components = new ArrayList<>();
		for (ComponentRow row : rows)
			components.addAll(row.asComponents());
		return components.toArray(new Component[0]);
	}

	public static Class<?> getOptionClass(OptionType type) {
		switch (type) {
			case ROLE:
				return Role.class;
			case USER:
				return User.class;
			case CHANNEL:
				return MessageChannel.class;
			case NUMBER:
				return Number.class;
			case INTEGER:
				return Integer.class;
			case STRING:
				return String.class;
			case ATTACHMENT:
				return Message.Attachment.class;
			case BOOLEAN:
				return Boolean.class;
			case MENTIONABLE:
				return IMentionable.class;
			default:
				return Object.class;
		}
	}

	public static Object parseOptionValue(OptionMapping option) {
		switch (option.getType()) {
			case ROLE:
				return option.getAsRole();
			case USER:
				return option.getAsUser();
			case CHANNEL:
				return option.getAsMessageChannel();
			case NUMBER:
				return option.getAsDouble();
			case INTEGER:
				return option.getAsInt();
			case STRING:
				return option.getAsString();
			case ATTACHMENT:
				return option.getAsAttachment();
			case BOOLEAN:
				return option.getAsBoolean();
			case MENTIONABLE:
				return option.getAsMentionable();
			default:
				return Object.class;
		}
	}
}
