//package main;
//
//public class Game implements Runnable {
//    
//    private GameFrame gameFrame; 
//    private GamePanel gamePanel;
//    private Thread gameLoop;
//    private final int FPS_SET = 120;
//    private final int UPS_SET = 200;  
//    
//    private Player player; 
//    
//    public Game() {
//
//        gameFrame = new GameFrame();
//        gamePanel = gameFrame.getPanel();
//        startGameLoop();
//    }
//    
//    private void startGameLoop() {
//        gameLoop = new Thread(this);
//        gameLoop.start();
//        // Print the frame rate to the console log
//        System.out.println("FPS: " + FPS_SET + ", UPS: " + UPS_SET);
//    }
//
//    
//    public void update(){
//        gamePanel.gameUpdate();
//    }
//    @Override
//    public void run() {
//        double timePerFrame = 1000000000.0 / FPS_SET;
//        double timePerUpdate = 1000000000.0 / UPS_SET;
//        long previousTime = System.nanoTime();
//        int updates = 0; 
//        int frames = 0;
//        long lastUpdateCheck = System.currentTimeMillis();
//        double deltaU = 0;
//        double deltaF = 0; 
//        
//        while(true) {
//            long currentTime = System.nanoTime();  
//            
//            deltaU += (currentTime - previousTime) / timePerUpdate; 
//            deltaF+= (currentTime - previousTime) / timePerFrame; 
//            
//            previousTime = currentTime;
//            
//            if (deltaU >= 1) {
//                update();
//                updates++;
//                deltaU--;
//            }
//            
//            
//            if (deltaF >= 1 ){
//                
//                gamePanel.repaint();
//                frames++;
//                deltaF --;
//                
//            }
//
//            
//            if (System.currentTimeMillis() - lastUpdateCheck >= 1000) {
//                lastUpdateCheck = System.currentTimeMillis();
//                System.out.println(frames + "DT: " + updates);
//                frames = 0;
//                updates = 0;
//            }
//        }
//    }
//    
//}