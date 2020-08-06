import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Bot462 extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            long chat_id = update.getMessage().getChatId();

            List<Photo> photos = new ArrayList<>();
            DB_Connection db_connection = new DB_Connection();
            try (Statement statement = db_connection.getConnection().createStatement()){
                try(ResultSet resultSet = statement.executeQuery("select id , title , privacy , description ,upload_date, view_ from photo");){
                    while (resultSet.next()){
                        int id = resultSet.getInt(1);
                        String title = resultSet.getString(2);
                        String privacy = resultSet.getString(3);
                        String description = resultSet.getString(4);
                        Date date = resultSet.getDate(5);
                        Integer view_ = resultSet.getInt(6);
                        Photo photo = new Photo();
                        photo.setId(id);
                        photo.setTitle(title);
                        photo.setPrivacy(privacy);
                        photo.setUploadDate(date);
                        photo.setDescription(description);
                        photo.setView(view_);
                        photos.add(photo);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String s = null;
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(update.getMessage().getChatId()).setMessageId(update.getMessage().getMessageId());
            SendPhoto sendPhoto = new SendPhoto();
            try {
                sendPhoto.setCaption("photo").setChatId(update.getMessage().getChatId()).setPhoto( "mostafa" , new FileInputStream("src/main/java/9.png"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                execute(deleteMessage);
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            for (Photo p: photos) {
                s = p.toString();
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText(s);
                try {
                    execute(message ); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }



        }
    }

    @Override
    public String getBotUsername() {
        return "@Se_Mo_462bot";
    }
    @Override
    public String getBotToken() {
        return "1115034528:AAHTsND8rBSTVjK78HEGOVz82xGezDMU-2w";
    }
//
//    public void onUpdateReceived(Update update) {
//
//    }
//
//    @Override
//    public String getBotUsername() {
//        return "@Se_Mo_462bot";
//    }
//    @Override
//    public String getBotToken() {
//        return "1115034528:AAHTsND8rBSTVjK78HEGOVz82xGezDMU-2w";
//    }
}

