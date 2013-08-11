package com.alltooeasy.maze.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JComponent;

import com.alltooeasy.maze.Controller;
import com.alltooeasy.maze.GameState;
import com.alltooeasy.maze.domain.Player;
import com.alltooeasy.maze.domain.Room;

public class MazePanel extends JComponent
{
    //final static private Logger log = LoggerFactory.getLogger( MazePanel.class );

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
        super.paintComponent( g );

        g = g.create();

        Insets insets = getInsets();
        //log.info( "Insets={}", insets );

        g.translate( insets.left, insets.top );
        int width = getWidth() - insets.left - insets.right - 1;
        int height = getHeight() - insets.top - insets.bottom - 1;

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

        Color fore = getForeground();

        if ( room.getNorth() != null )
        {
            //g.drawString( "N", roomX + ( roomWidth / 2 ), roomY );
            g.setColor( getBackground() );
            g.drawLine( roomX + (int)( roomWidth * ( Controller.TRIGGER_MIN / 100.0 ) ), roomY,
                    roomX + (int)( roomWidth * ( Controller.TRIGGER_MAX / 100.0 ) ), roomY );
            g.setColor( fore );
        }

        if ( room.getEast() != null )
        {
            //g.drawString( "E", roomX + roomWidth, roomY + ( roomHeight / 2 ) );
            g.setColor( getBackground() );
            g.drawLine( roomX + roomWidth, roomY + (int)( roomHeight * ( Controller.TRIGGER_MIN / 100.0 ) ),
                    roomX + roomWidth, roomY + (int)( roomHeight * ( Controller.TRIGGER_MAX / 100.0 ) ) );
            g.setColor( fore );
        }

        if ( room.getSouth() != null )
        {
            //g.drawString( "S", roomX + ( roomWidth / 2 ), roomY + roomHeight );
            g.setColor( getBackground() );
            g.drawLine( roomX + (int)( roomWidth * ( Controller.TRIGGER_MIN / 100.0 ) ), roomY + roomHeight,
                    roomX + (int)( roomWidth * ( Controller.TRIGGER_MAX / 100.0 ) ), roomY + roomHeight );
            g.setColor( fore );
        }

        if ( room.getWest() != null )
        {
            //g.drawString( "W", roomX, roomY + ( roomHeight / 2 ) );
            g.setColor( getBackground() );
            g.drawLine( roomX, roomY + (int)( roomHeight * ( Controller.TRIGGER_MIN / 100.0 ) ),
                    roomX, roomY + (int)( roomHeight * ( Controller.TRIGGER_MAX / 100.0 ) ) );
            g.setColor( fore );
        }

        Player player = state.getPlayer();

        int scaledX = (int)( player.getX() / 100.0 * roomWidth );
        int scaledY = (int)( player.getY() / 100.0 * roomHeight );

        g.drawString( "X", roomX + scaledX, roomY + scaledY );

    }

}
