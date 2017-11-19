import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


abstract class Down extends TelegramLongPollingBot {

    protected static final String KANA = "(.*[ぁ-んァ-ン].*)";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Head());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public String getBotToken() {
        return "";
    }

    public String getBotUsername() {
        return "VjLupen_Bot";
    }

}
