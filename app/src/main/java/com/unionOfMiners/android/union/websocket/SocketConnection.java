package com.unionOfMiners.android.union.websocket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unionOfMiners.android.union.Constants;
import com.unionOfMiners.android.union.coinModel.CoinsFromSocket;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by HP on 04.08.2017.
 *
 */
public class SocketConnection {

    private ClientWebSocket clientWebSocket;
    private Context context;

    public SocketConnection(Context context) {
        this.context = context;
    }

    public void openConnection() {
        if (clientWebSocket != null) {
            clientWebSocket.close();
        }
        try {
            clientWebSocket = new ClientWebSocket(new ClientWebSocket.MessageListener() {
                @Override
                public void onSocketMessage(String message) {
                   // Log.i(Constants.TAG, message);
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        CoinsFromSocket coinsFromSocket = mapper.readValue(message.getBytes(), CoinsFromSocket.class);
                        EventBus.getDefault().post(coinsFromSocket);
                    } catch (Exception exc) {
                        Log.i(Constants.TAG, exc.getLocalizedMessage());
                    }
                }
            });
            clientWebSocket.connect();
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getLocalizedMessage());
        }
        initScreenStateListener();
    }

    public void closeConnection() {
        if (clientWebSocket != null) {
            clientWebSocket.close();
            clientWebSocket = null;
        }
        releaseScreenStateListener();
    }

    private void initScreenStateListener() {
        context.registerReceiver(screenStateReceiver, new IntentFilter(Intent.ACTION_SCREEN_ON));
        context.registerReceiver(screenStateReceiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }

    private void releaseScreenStateListener() {
        try {
            context.unregisterReceiver(screenStateReceiver);
        } catch (IllegalArgumentException e) {
            Log.e(Constants.TAG, e.getLocalizedMessage());
        }
    }

    private BroadcastReceiver screenStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                openConnection();
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                closeConnection();
            }
        }
    };

    public boolean isConnected() {
        return clientWebSocket != null && clientWebSocket.getConnection() != null && clientWebSocket.getConnection().connected();
    }
}
