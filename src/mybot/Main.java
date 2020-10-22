package mybot;

import org.jibble.pircbot.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Now start our bot up.
        StockBot bot = new StockBot();

        // Enable debugging output.
        bot.setVerbose(true);

        // Connect to the IRC server.
        bot.connect("irc.freenode.net");

        // Join the #pircbot channel.
        bot.joinChannel("#stockChat");

        bot.sendMessage("#stockChat", "Hello! Welcome to #stockChat. Enter help to see how to use chat. Enter commands for a list of commands.");
    }
}
