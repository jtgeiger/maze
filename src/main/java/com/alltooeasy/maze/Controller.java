package com.alltooeasy.maze;

import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alltooeasy.maze.domain.Room;
import com.alltooeasy.maze.ui.MazePanel;

public class Controller
{
    final static private Logger log = LoggerFactory.getLogger( Controller.class );

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

    public void keyPressed( KeyEvent evt )
    {
        switch ( evt.getKeyCode() )
        {
            case KeyEvent.VK_RIGHT:
            {
                Room east = state.getRoom().getEast();
                if ( east != null )
                    state.setRoom( east );
                break;
            }

            case KeyEvent.VK_LEFT:
            {
                Room west = state.getRoom().getWest();
                if ( west != null )
                    state.setRoom( west );
                break;
            }

            default:
                log.error( "Unexpected key=" + evt );
        }

        update();
    }

}
