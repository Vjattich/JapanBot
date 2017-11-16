
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


abstract class Body extends Down {

    private static final String HIRAGANA;
    private static final String KATAKANA;
    private static List<Pattern> patterns = new ArrayList<>();

    static {
        HIRAGANA = ".*\\p{InHIRAGANA}.*";
        KATAKANA = ".*\\p{InKATAKANA}.*";

        Pattern hira = Pattern.compile(HIRAGANA);
        Pattern kata = Pattern.compile(KATAKANA);

        patterns.add(hira);
        patterns.add(kata);
    }

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
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setText(text);
        try {
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    protected boolean isJapanese(String text) {
        for (Pattern p: patterns) {
            Matcher matcher = p.matcher(text);
            return matcher.matches();
        }
        return false;
    }

}
