package com.alltooeasy.maze;

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
        two.setWest( one );

        GameState state = new GameState();
        state.setRoom( one );

        MazePanel mazePanel = new MazePanel();

        Controller controller = new Controller();
        controller.setPanel( mazePanel );
        controller.setState( state );

        MazeKeyListener mazeKeyListener = new MazeKeyListener();
        mazeKeyListener.setController( controller );

        UiBuilder.buildUi( mazePanel, mazeKeyListener );

        controller.update();
    }

}
