package inputs;

public class CONSTANTS {
    
    /////////////////////////////////
    /// switching to enums 
    //////////////////////////////
        public static class Directions {
            public static final int LEFT = 0;
            public static final int RIGHT = 1;
            public static final int DOWN = 2;
            public static final int UP = 3;                  
                    
        }
        
        
///////////////////////////////////////////////////////////
     //// switching to enums ////////////////////
        ////////////////////////////////////////
    
    public static class AnimCounterConstants {
        public static final int ATTACKING = 0; 
        public static final int ATTACKING_2 = 1; 
        public static final int DEATH = 2; 
        public static final int FALLING = 3; 
        public static final int IDLE = 4;
        public static final int JUMPING = 5;         
        public static final int RUNNING = 6; 
        public static final int HIT = 7; 
        
        
        
       
        
        public static int getAnimCount(int playerActions ) {
            
            switch (playerActions){

            case RUNNING:  
                return 8;

            case DEATH:
                return 7;
                       
            case IDLE:
            case ATTACKING:
            case ATTACKING_2:
                return 4;                 
            case HIT:
                return 3;
                
            case JUMPING :
            case FALLING :
                return 2;
            
            default:
                throw new IllegalArgumentException("Invalid player action: " + playerActions);
            } 
        }
    }
}
