package com.alltooeasy.maze.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.alltooeasy.maze.GameState;
import com.alltooeasy.maze.domain.Room;

public class MazePanel extends JPanel
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private GameState state;

    public void display( GameState state )
    {
        this.state = state;
        repaint();
    }

    @Override
    protected void paintComponent( Graphics g )
    {
        g.clearRect( 0, 0, getWidth(), getHeight() );

        StringBuilder buf = new StringBuilder();
        Room room = state.getRoom();
        buf.append( room.getNorth() != null ? 'N' : '-' );
        buf.append( room.getEast() != null ? 'E' : '-' );
        buf.append( room.getSouth() != null ? 'S' : '-' );
        buf.append( room.getWest() != null ? 'W' : '-' );

        g.drawString( buf.toString(), 5, 10 );
    }

}
