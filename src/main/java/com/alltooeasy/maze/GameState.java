package com.alltooeasy.maze;

import com.alltooeasy.maze.domain.Player;
import com.alltooeasy.maze.domain.Room;

public class GameState
{
    private Room room;
    private Player player;

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer( Player player )
    {
        this.player = player;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom( Room room )
    {
        this.room = room;
    }

}
