package domain;

import java.util.HashMap;

public class ChatHistory {

    private HashMap<Integer,Chatmessage> chatmessages;

    public ChatHistory(){
        chatmessages = new HashMap<>();
    }

    public void addChatMessage(Chatmessage chatmessage) {
        chatmessages.put(chatmessage.getId(),chatmessage);
    }
}
