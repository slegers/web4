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

    public HashMap<Integer,Chatmessage> getChatmessages(){
        return chatmessages;
    }

    public String  getChatmessagesToJSon() {
        if(getChatmessages().values().size() == 0){
            return "{}";
        }
        String s = "{";
        int i = 0;
        for (Chatmessage m: getChatmessages().values()) {
            s = s + " \""+ i + "\" : {";
            s = s + "\"time\": \"" + m.getTime() + "\"";
            s = s + ",\"message\" :\"" + m.getMessage() + "\"";
            s = s + ",\"person\": \"" + m.getPerson().getUserId() +"\"},";
            i++;
        }
        if(s.length() > 1){
            s = s.substring(0,s.length()-1);
        }
        return s + "}";
    }
}
