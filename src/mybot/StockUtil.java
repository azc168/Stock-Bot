package mybot;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException
        ;
import java.math.BigDecimal;

public class StockUtil {
    public static String getPrice(String symbol) {
        Stock stock;
        BigDecimal price;
        BigDecimal change;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            price = stock.getQuote().getPrice();
            change = stock.getQuote().getChange();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        if(change.floatValue() >= 0) {
            return "$" + price.toString() + "(+" + change.toString() + ")";
        } else {
            return "$" + price.toString() + "(" + change.toString() + ")";
        }
    }

    public static String getPreviousClose(String symbol) {
        Stock stock;
        BigDecimal price;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            price = stock.getQuote().getPreviousClose();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        return "$" + price.toString();
    }

    public static String getOpen(String symbol) {
        Stock stock;
        BigDecimal price;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            price = stock.getQuote().getOpen();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        return "$" + price.toString();
    }

    public static String getVolume(String symbol) {
        Stock stock;
        long volume;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            volume = stock.getQuote().getVolume();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        return "" + volume;
    }

    public static void main(String[] args) {
        System.out.println(StockUtil.getVolume("fb"));
    }
}
