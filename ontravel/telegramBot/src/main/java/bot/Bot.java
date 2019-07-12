package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import utils.ResponseCreator;


public class Bot extends TelegramLongPollingBot {

    private ResponseCreator responseCreator = new ResponseCreator();

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public synchronized void sendMsg(String chatId, String messageFromUser) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);

        sendMessage.setText(responseCreator.getCityInfo(messageFromUser));
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "CityInformation_bot" ;
    }

    @Override
    public String getBotToken() {
        return "809700989:AAFk36mGyxNrjKGl0Xyb0TKOox_NFuXJfjU";
    }
}
