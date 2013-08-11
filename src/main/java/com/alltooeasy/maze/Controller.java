package com.alltooeasy.maze;

import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alltooeasy.maze.domain.Player;
import com.alltooeasy.maze.domain.Room;
import com.alltooeasy.maze.ui.MazePanel;

public class Controller
{
    final static private Logger log = LoggerFactory.getLogger( Controller.class );


    final static public int TRIGGER_MIN = 44;
    final static public int TRIGGER_MAX = 55;

    private MazePanel panel;
    private GameState state;

    public MazePanel getPanel()
    {
        return panel;
    }

    public void setPanel( MazePanel panel )
    {
        this.panel = panel;
    }

    public GameState getState()
    {
        return state;
    }

    public void setState( GameState state )
    {
        this.state = state;
    }

    public void update()
    {
        panel.display( state );
    }

/*
    public void keyPressed( KeyEvent evt )
    {
        Room newRoom = null;

        switch ( evt.getKeyCode() )
        {

            case KeyEvent.VK_UP:
            {
                newRoom = state.getRoom().getNorth();
                break;
            }

            case KeyEvent.VK_RIGHT:
            {
                newRoom = state.getRoom().getEast();
                break;
            }

            case KeyEvent.VK_DOWN:
            {
                newRoom = state.getRoom().getSouth();
                break;
            }

            case KeyEvent.VK_LEFT:
            {
                newRoom = state.getRoom().getWest();
                break;
            }

            default:
                log.error( "Unexpected key=" + evt );
        }

        if ( newRoom != null )
        {
            state.setRoom( newRoom );
            update();
        }
    }
*/
    public void keyPressed( KeyEvent evt )
    {
        Player player = state.getPlayer();
        int x = player.getX();
        int y = player.getY();

        boolean needUpdate = true;

        int step = 3;

        switch ( evt.getKeyCode() )
        {
            case KeyEvent.VK_UP:
                y -= step;
                break;

            case KeyEvent.VK_RIGHT:
                x += step;
                break;

            case KeyEvent.VK_DOWN:
                y += step;
                break;

            case KeyEvent.VK_LEFT:
                x -= step;
                break;

            default:
                needUpdate = false;
                log.error( "Unexpected key=" + evt );
        }

        if ( needUpdate )
        {
            Room room = state.getRoom();

            boolean xTrigger = ( x > TRIGGER_MIN && x < TRIGGER_MAX );
            boolean yTrigger = ( y > TRIGGER_MIN && y < TRIGGER_MAX );

            if ( y < 0 && xTrigger && room.getNorth() != null )
            {
                state.setRoom( room.getNorth() );
                //x = 50;
                y = 99;
            }
            else if ( y > 99 && xTrigger && room.getSouth() != null )
            {
                state.setRoom( room.getSouth() );
                //x = 50;
                y = 0;
            }
            else if ( x < 0 && yTrigger && room.getWest() != null )
            {
                state.setRoom( room.getWest() );
                x = 99;
                //y = 50;
            }
            else if ( x > 99 && yTrigger && room.getEast() != null )
            {
                state.setRoom( room.getEast() );
                x = 0;
                //y = 50;
            }

            if ( x > 99 )
                x = 99;
            else if ( x < 0 )
                x = 0;

            if ( y > 99 )
                y = 99;
            else if ( y < 0 )
                y = 0;

            player.setX( x );
            player.setY( y );
            log.info( "Player coords=({}, {}).", x, y );
            update();
        }
    }

}
