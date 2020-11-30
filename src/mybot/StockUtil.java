package mybot;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
import yahoofinance.quotes.stock.StockDividend;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

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

    public static String getDividend(String symbol) {
        Stock stock;
        StockDividend dividend;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            dividend = stock.getDividend();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        return dividend.toString();
    }
    public static String getHistory(String symbol) {
        Stock stock;
        List history;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            history = stock.getHistory();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        return history.toString();
    }

    public static String getDividendHistory(String symbol) {
        Stock stock;
        List history;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            history = stock.getDividendHistory();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        return history.toString();
    }

    public static String getSplits(String symbol) {
        Stock stock;
        List history;
        try {
            stock = YahooFinance.get(symbol);
            if(stock == null) {
                return "company does not exist.";
            }
            history = stock.getSplitHistory();
        } catch (IOException e) {
            return "Invalid Input.";
        }
        return history.toString();
    }

    /*(public static void main(String[] args) {
        System.out.println(StockUtil.getVolume("fb"));
    }*/
}
