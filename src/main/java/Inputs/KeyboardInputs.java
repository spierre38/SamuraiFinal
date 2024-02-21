
package Inputs;

import static inputs.CONSTANTS.Directions.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

public class KeyboardInputs implements KeyListener 
{
    private GamePanel gamePanel;
    
    public KeyboardInputs(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }
    
            
    @Override
    public void keyTyped(KeyEvent e) 
    {
        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        
        switch (e.getKeyCode())
        {
            
        case KeyEvent.VK_A:
            gamePanel.setMovement(LEFT);
             break;
        case KeyEvent.VK_W:
            System.out.println("W");
            gamePanel.setMovement(UP);
             break;
        case KeyEvent.VK_D:
            gamePanel.setMovement(RIGHT);
            break;
        case KeyEvent.VK_S:
            gamePanel.setMovement(DOWN);
            break;
                  
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode())
        {
            
        case KeyEvent.VK_A:
        case KeyEvent.VK_W:
        case KeyEvent.VK_D:
        case KeyEvent.VK_S:
          
            gamePanel.setMoving(false);

            break;
           
        }    }
    
    
    
}
