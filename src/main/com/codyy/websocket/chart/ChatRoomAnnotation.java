package main.com.codyy.websocket.chart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{roomId}")
public class ChatRoomAnnotation {

    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Set<ChatRoomAnnotation> connections =
            new CopyOnWriteArraySet<>();
    private static final Map<String, Session> map = new HashMap<String, Session>();

    private final String nickname;
    private Session session;

    public ChatRoomAnnotation() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }

    @OnOpen
    public void start(Session session, @PathParam(value="roomId") String roomId) {
        this.session = session;
        connections.add(this);
        map.put(roomId+"_"+nickname, session);
        String message = String.format("* %s %s", nickname, "has joined.");
        broadcast(message, roomId);
    }

    @OnClose
    public void end(@PathParam(value="roomId") String roomId) {
        connections.remove(this);
        map.remove(roomId+"_"+nickname);
        String message = String.format("* %s %s",
                nickname, "has disconnected.");
        broadcast(message, roomId);
    }

    @OnMessage
    public void incoming(String message, @PathParam(value="roomId") String roomId) {
        // Never trust the client
    	// TODO: 过滤输入的内容
    	broadcast(nickname+":"+message, roomId);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        System.out.println("Chat Error: " + t.toString());
    }

    private void broadcast(String msg, String roomId) {
        for (ChatRoomAnnotation client : connections) {
            try {
                synchronized (client) {
                	if(map.get(roomId+"_"+client.nickname) != null){
                		(map.get(roomId+"_"+client.nickname)).getBasicRemote().sendText(msg);
                	}
                    //client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
            	System.out.println("Chat Error: Failed to send message to client");
            	map.remove(roomId+"_"+client.nickname);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickname, "has been disconnected.");
                broadcast(message, roomId);
            }
        }
    }
}
