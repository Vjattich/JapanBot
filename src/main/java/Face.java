import org.telegram.telegrambots.api.objects.Update;

public class Face extends Body {

    public void onUpdateReceived(Update update) {
        if ((update.getMessage().hasText() && update.hasMessage() ||
                update.getMessage().isGroupMessage() && update.getMessage().hasText())) {
            if (isJapanese(update.getMessage().getText())) {
                sendMessage(translate("true"), update);
            } else {
                sendMessage(translate("false"), update);
            }
        }
    }

}
