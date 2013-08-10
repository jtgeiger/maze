package com.alltooeasy.maze;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException( "OGTE TODO!" );
    }

}
