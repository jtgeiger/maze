package com.alltooeasy.maze.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class UiBuilder
{

    private UiBuilder() {}  //Prevent instantiation.

    static public void buildUi( final Component component, final KeyListener keyListener )
    {
        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run()
            {
                new UiBuilder().doUi( component, keyListener );
            }
        } );
    }


    private void doUi( Component component, KeyListener keyListener )
    {
        JFrame frame = new JFrame( "Maze" );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

            //TODO: Add the listener to the component rather than passing it in here.
        frame.addKeyListener( keyListener );

        Container cp = frame.getContentPane();
        cp.add( component );

        frame.setSize( 400, 400 );

        frame.setVisible( true );
    }

}
