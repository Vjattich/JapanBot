import com.memetix.mst.translate.Translate;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


abstract class Down extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        /*Translate.setClientId("");
        Translate.setClientSecret("");*/
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
