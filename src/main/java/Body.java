
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


abstract class Body extends Down {

    //protected static Connection connection = Jsoup.connect("https://translate.google.com/#ja/ru");


/*    protected String translate(String text) {
        String translatedText = null;
        try {
            translatedText = Translate.execute(text, Language.JAPANESE, Language.RUSSIAN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translatedText;
    }*/

    protected String translate(String text) {
        String result = null;
        StringBuffer url = new StringBuffer("https://translate.google.com/ja/ru/");
        try {
            Document doc = Jsoup.connect(String.valueOf(url)).get();
            Element texting = doc.select("span[class=\"gt-ct-text\"]").first();
            texting.appendText(text);
            result = doc.select("span[class = \"\" ]").text();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result == null ? "false" : result;
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
