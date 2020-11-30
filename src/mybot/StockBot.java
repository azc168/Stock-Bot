package mybot;

import org.jibble.pircbot.*;

public class StockBot extends PircBot {

    public StockBot() {
        this.setName("stockExpert");
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        String result;
        if (message == null) {
            sendMessage(channel, "invalid command");
            return;
        }
        if (message.equalsIgnoreCase("help")) {
            sendMessage(channel, "Enter a <command> and <stock> separated by a <:>");
            sendMessage(channel, "ex: get price:fb");
            return;
        }
        if (message.equalsIgnoreCase("commands")) {
            sendMessage(channel, "available commands:");
            sendMessage(channel, "get price");
            sendMessage(channel, "get previous close");
            sendMessage(channel, "get open");
            sendMessage(channel, "get volume");
            sendMessage(channel, "get dividend");
            sendMessage(channel, "get history");
            sendMessage(channel, "get dividend history");
            sendMessage(channel, "get split history");
            return;
        }
        int index = message.indexOf(":");

        if (index < 0) {
            sendMessage(channel, "invalid command");
            return;
        }
        String command = message.substring(0, index).toLowerCase();

        String symbol = message.substring(index + 1);

        //cases start here
        switch (command) {
            case "get price":
                result = StockUtil.getPrice(symbol);
                sendMessage(channel, result);
                break;

            case "get previous close":
                result = StockUtil.getPreviousClose(symbol);
                sendMessage(channel, result);
                break;

            case "get open":
                result = StockUtil.getOpen(symbol);
                sendMessage(channel, result);
                break;

            case "get volume":
                result = StockUtil.getVolume(symbol);
                sendMessage(channel, result);
                break;

            case "get history":
                result = StockUtil.getHistory(symbol);
                sendMessage(channel, result);
                break;

            case "get dividend history":
                result = StockUtil.getDividendHistory(symbol);
                sendMessage(channel, result);
                break;

            case "get dividend":
                result = StockUtil.getDividend(symbol);
                sendMessage(channel, result);
                break;

            case "get split history":
                result = StockUtil.getSplits(symbol);
                sendMessage(channel, result);
                break;

            default:
                result = "command not supported.";
                sendMessage(channel, result);
                break;
        }
    }

}
