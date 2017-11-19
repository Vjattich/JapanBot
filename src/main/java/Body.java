

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

abstract class Body extends Down {

    protected String translate(String text) {
        String result;
        StringBuffer url = new StringBuffer("https://translate.google.com/#ja/ru");
        url.append("/" + text);
        try {
            Document doc = Jsoup.connect(String.valueOf(url)).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
            result = doc.title();
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }

    protected void sendMessage(String text, Update update) {
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(text);
        try {
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
