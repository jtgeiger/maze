package com.alltooeasy.maze.ui;

import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alltooeasy.maze.GameState;
import com.alltooeasy.maze.domain.Room;

public class MazePanel extends JPanel
{
    final static private Logger log = LoggerFactory.getLogger( MazePanel.class );

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

        Insets insets = getInsets();
        log.info( "Insets={}", insets );

        g.translate( insets.left, insets.top );
        int width = getWidth() - insets.left - insets.right;
        int height = getHeight() - insets.top - insets.bottom;

        g.clearRect( 0, 0, width, height );

        StringBuilder buf = new StringBuilder();
        Room room = state.getRoom();
        buf.append( room.getNorth() != null ? 'N' : '-' );
        buf.append( room.getEast() != null ? 'E' : '-' );
        buf.append( room.getSouth() != null ? 'S' : '-' );
        buf.append( room.getWest() != null ? 'W' : '-' );

        g.drawString( buf.toString(), 5, 10 );

//        g.drawRect( insets.left, insets.top,
//                getWidth() - insets.left - insets.right, getHeight() - insets.top - insets.bottom );

        g.drawRect( 0, 0, width, height );


        int roomHeight = (int)( 0.6 * height );
        int roomWidth = (int)( 0.6 * width );
        int roomX = ( width - roomWidth ) / 2;
        int roomY = ( height - roomHeight ) / 2;

        g.drawRect( roomX, roomY, roomWidth, roomHeight );


        if ( room.getNorth() != null )
        {
            g.drawString( "N", roomX + ( roomWidth / 2 ), roomY );
        }

        if ( room.getEast() != null )
        {
            g.drawString( "E", roomX + roomWidth, roomY + ( roomHeight / 2 ) );
        }

        if ( room.getSouth() != null )
        {
            g.drawString( "S", roomX + ( roomWidth / 2 ), roomY + roomHeight );
        }

        if ( room.getWest() != null )
        {
            g.drawString( "W", roomX, roomY + ( roomHeight / 2 ) );
        }
    }

}
