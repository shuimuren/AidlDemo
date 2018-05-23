// IGameManager.aidl
package com.test.view.aidltest;
import com.test.view.aidltest.Game;
// Declare any non-default types here with import statements

interface IGameManager {
  List<Game> getGameList();
  void addGame(in Game game);
}
