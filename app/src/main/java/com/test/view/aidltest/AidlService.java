package com.test.view.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AidlService extends Service {
    private CopyOnWriteArrayList<Game> mGameList = new CopyOnWriteArrayList<>();
    private Binder binder = new IGameManager.Stub() {
        @Override
        public List<Game> getGameList() throws RemoteException {
            return mGameList;
        }

        @Override
        public void addGame(Game game) throws RemoteException {
                mGameList.add(game);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mGameList.add(new Game("英雄联盟","腾讯出品"));
        mGameList.add(new Game("跑跑卡丁车","卡丁车中的跑跑"));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


}
