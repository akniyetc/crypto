package com.unionOfMiners.android.union.websocket;

import android.util.Log;

import com.unionOfMiners.android.union.Constants;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


/**
 * Created by HP on 04.08.2017.
 *
 */
public class ClientWebSocket {

    private MessageListener listener;
    private Socket ws;

    public ClientWebSocket(MessageListener listener) {
        this.listener = listener;
    }

    public void connect() {
        try {
            if (ws != null) {
                reconnect();
            } else {
                ws = IO.socket(Constants.SOCKET_HOST);
                ws.on("trades", new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        //Log.v("THREAD",Thread.currentThread().toString());
                        listener.onSocketMessage(args[0].toString());
                    }
                });
                ws.connect();
            }
        } catch (Exception exc) {
            Log.e(Constants.TAG, exc.getLocalizedMessage());
        }
    }

    private void reconnect() {
        try {
            ws.disconnect();
            ws.connect();
        } catch (Exception exc) {
            Log.i(Constants.TAG, exc.getLocalizedMessage());
        }
    }

    public Socket getConnection() {
        return ws;
    }

    public void close() {
        ws.disconnect();
    }

    public interface MessageListener {
        void onSocketMessage(String message);
    }
}

