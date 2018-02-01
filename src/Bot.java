import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    int a = 0;
    int b = 0;
    long[] pol = new long[a];
    String yangilik = null;
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String messsage = update.getMessage().getText();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(messsage);
            if (update.getMessage().getText().equals("/start")){
                a++;
                pol[b] = update.getMessage().getChatId();
                b++;
                if (a == 1000){
                    long ChatId =430291209;
                    SendMessage sendMessage1 = new SendMessage().setChatId(ChatId);
                    sendMessage1.setText("Foydalanuvchilar soni "+a+" dan oshdi");
                    try {
                        sendMessage(sendMessage1);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (messsage.equals("/yangilik")){
                sendMessage.setText(yangilik);
            }
            else{

                if(update.getMessage().getChatId() == 430291209){
                yangilik = messsage;
                SendMessage sendMessage1 = new SendMessage();
                sendMessage.setText(yangilik);
                for (int i = 0; i < pol.length; i++) {
                    sendMessage1.setChatId(pol[i]);
                    try {
                        sendMessage(sendMessage1);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    }
                }
            }
        }

    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return "338746202:AAHQRmOUhsBL0bP7TERlXQ4qZrrymCY3hLY";
    }
}
