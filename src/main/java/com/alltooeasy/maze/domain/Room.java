package com.alltooeasy.maze.domain;

public class Room
{

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room getNorth()
    {
        return north;
    }
    public void setNorth( Room north )
    {
        this.north = north;
    }
    public Room getEast()
    {
        return east;
    }
    public void setEast( Room east )
    {
        this.east = east;
    }
    public Room getSouth()
    {
        return south;
    }
    public void setSouth( Room south )
    {
        this.south = south;
    }
    public Room getWest()
    {
        return west;
    }
    public void setWest( Room west )
    {
        this.west = west;
    }

}
