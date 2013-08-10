package com.alltooeasy.maze.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alltooeasy.maze.Controller;

public class MazeKeyListener implements KeyListener
{
    final static private Logger log = LoggerFactory.getLogger( MazeKeyListener.class );

    private Controller controller;

    public Controller getController()
    {
        return controller;
    }

    public void setController( Controller controller )
    {
        this.controller = controller;
    }

    @Override
    public void keyTyped( KeyEvent evt )
    {
        // TODO Auto-generated method stub
        log.debug( "Key typed={}.", evt );
    }

    @Override
    public void keyPressed( KeyEvent evt )
    {
        // TODO Auto-generated method stub
        log.debug( "Key pressed={}.", evt );
        controller.keyPressed( evt );
    }

    @Override
    public void keyReleased( KeyEvent evt )
    {
        // TODO Auto-generated method stub
        log.debug( "Key released={}.", evt );
    }

}
