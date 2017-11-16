
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


abstract class Body extends Down {

    protected static final String KANA = "(.*[ぁ-んァ-ン].*)";

    protected String translate(String text) {
        /*String translatedText = null;
        try {
            translatedText = Translate.execute(text, Language.JAPANESE, Language.RUSSIAN);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return text;
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
