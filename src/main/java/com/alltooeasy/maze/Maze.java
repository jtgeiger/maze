package com.alltooeasy.maze;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alltooeasy.maze.domain.Room;
import com.alltooeasy.maze.ui.MazeKeyListener;
import com.alltooeasy.maze.ui.MazePanel;
import com.alltooeasy.maze.ui.UiBuilder;

public class Maze
{
    final static private Logger log = LoggerFactory.getLogger( Maze.class );

    static public void main( String[] args )
    {
        long startMs = System.currentTimeMillis();

        log.info( "main() started." );

        new Maze().go();

        long endMs = System.currentTimeMillis();

        log.info( "main() finished; duration={} ms.", endMs - startMs );
    }

    public void go()
    {
        Room one = new Room();
        Room two = new Room();

        one.setEast( two );
        one.setNorth( new Room() );
        two.setWest( one );
        two.setSouth( new Room() );

        GameState state = new GameState();
        state.setRoom( one );

        MazePanel mazePanel = new MazePanel();
        Border border = BorderFactory.createEmptyBorder( 10, 10, 10, 10 );
//        Border border = BorderFactory.createBevelBorder( BevelBorder.LOWERED );
        mazePanel.setBorder( border );

        Controller controller = new Controller();
        controller.setPanel( mazePanel );
        controller.setState( state );

        MazeKeyListener mazeKeyListener = new MazeKeyListener();
        mazeKeyListener.setController( controller );

        UiBuilder.buildUi( mazePanel, mazeKeyListener );

        controller.update();
    }

}
