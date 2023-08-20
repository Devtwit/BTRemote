package com.hasanmumin.ble.client;

import android.bluetooth.BluetoothDevice;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Objects;

import no.nordicsemi.android.ble.callback.DataSentCallback;
import no.nordicsemi.android.ble.callback.profile.ProfileDataCallback;
import no.nordicsemi.android.ble.data.Data;

public abstract class ClientDataCallback implements ProfileDataCallback, DataSentCallback {
    abstract void onDataAvailable(String message, Object... arguments);

    @Override
    public void onDataReceived(@NonNull BluetoothDevice device, @NonNull Data data) {
        String rData =  new String(Objects.requireNonNull(data.getValue()));
        onDataAvailable("onDataReceived() data is %s", rData);
        switch(rData){
                case "Play":
                    // code block
                    Log.d("Play recieved",rData);
                    break;
                case "Pause" :
                    Log.d("Pause recieved",rData);
                    // code block
                    break;
                default:
                    Log.d("fr def recieved",rData);
                    // code block


        }
    }

    @Override
    public void onDataSent(@NonNull BluetoothDevice device, @NonNull Data data) {
        onDataAvailable("onDataSent() data is %s", new String(Objects.requireNonNull(data.getValue())));
    }

    @Override
    public void onInvalidDataReceived(@NonNull BluetoothDevice device, @NonNull Data data) {
        onDataAvailable("onInvalidDataReceived() data is %s", new String(Objects.requireNonNull(data.getValue())));
    }
}
