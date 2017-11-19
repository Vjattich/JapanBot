import org.telegram.telegrambots.api.objects.Update;

public class Head extends Body {
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText() && update.hasMessage() && update.getMessage().getText().matches(KANA)) {
            sendMessage(translate(update.getMessage().getText()), update);
        }
    }
}
