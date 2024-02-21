
package main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;
import static inputs.CONSTANTS.Directions.*;
import static inputs.CONSTANTS.AnimCounterConstants.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//35 ???

public class GamePanel extends javax.swing.JPanel {
    
    private MouseInputs mouseInputs;
    private int xDelta = 100;
    private int yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] playerAnimations;
    private int animTicker;
    private int animTracker;
    private int animFrameRate = 30;
    private int animFrameWidth = 200; // Width of each frame in the animation
    private int animFrameHeight = 200; // Height of each frame in the animation
    private int playerAction = IDLE;
    private int playerDir = -1; 
    private boolean moving = false;


    public GamePanel()
    {
        
        initComponents();
        
        loadImage();
        
        loadAnimations();

        
        
        mouseInputs = new MouseInputs(this);
        
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        
        System.out.println("Game Panel Is working!");
        
        setFocusable(true);
        requestFocusInWindow();

        
    }
    
  
       /*
        private void loadImage() {
            try {
                // Assuming the image file is in the same directory as your source code
                URL imageUrl = getClass().getResource("/main/Idle.png");
                if (imageUrl == null) {
                    throw new IOException("Image file not found");
                }
                img = ImageIO.read(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace(); // Print stack trace for debugging
            }
        }
*/
    private void loadImage() {
    try {
        img = ImageIO.read(new File("C:\\Users\\ecloaner\\Documents\\NetBeansProjects\\SamuraiGame\\src\\main\\java\\main\\player_sprite.png"));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    
    
    private void loadAnimations()
            
    {
        playerAnimations = new BufferedImage[8][8];
        
        for (int j = 0; j < playerAnimations.length; j ++)
            for (int i = 0; i < playerAnimations[j].length; i++) 
                playerAnimations[j][i] = img.getSubimage(i * animFrameWidth, j * animFrameHeight, animFrameWidth, animFrameHeight);
    }
    
    
    
    public void setMovement(int movement){
        this.playerDir = movement;
        moving = true;
    }
    
    public void setMoving(boolean moving){
        this.moving = moving;
    }

        
          
    private void setAnim(){
        if (moving)
            playerAction = RUNNING;
                    else  
            playerAction = IDLE;
    }
    
    private void changeDir(){
        
        if(moving){
            switch(playerDir) {
                case LEFT:
                    xDelta -= 1;
                    break;
                case RIGHT:
                    xDelta += 1; 
                    break;
                case UP:
                    yDelta -= 1;
                    break;
                case DOWN:
                    yDelta+= 1;
                    break;

                        
            }
        }
        
    }
    
    
    public void gameUpdate(){
        
        updateAnim();
        
        setAnim();
        
        changeDir();

    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
            
            
            
    {
        super.paintComponent(g);
        
        gameUpdate();
        
        
       if (img!=null){
         // subImg = img.getSubimage(0, 0, 200, 200);
          g.drawImage( playerAnimations[playerAction][animTracker], xDelta, yDelta, 400, 400,null); //doubling the height );
          
          repaint();
          //200 , 200 gets the top left for the player
          // increase x by 200 to move right 
          // go down by 200 to get second row
       }
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(1320, 1400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void updateAnim() {
      
        animTicker++;
        if (animTicker >= animFrameRate){
            animTicker = 0;
            animTracker ++;
            if(animTracker >= getAnimCount(playerAction)) //number of frames in the row 
                animTracker = 0;
                  
        }

        
      
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
