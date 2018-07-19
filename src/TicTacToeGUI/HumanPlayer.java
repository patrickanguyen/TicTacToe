/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeGUI;

/**
 *
 * @author Patrick
 */
public class HumanPlayer extends Players{
    
    public HumanPlayer(Board board, String name) {
        super(board,name);
    }
    
    /**
     * Method that selects the point the player chooses, provided
     * that the selection is valid else do nothing
     * 
     * @param myRow value in rowField that indicates 
     * the row of board that the player wants to select
     * 
     * @param myColumn value in columnField that indicates 
     * the column of board that the player wants to select
     */
    public boolean select(int myRow, int myColumn){
        
        if ((myRow < getBoard().row && myColumn < getBoard().column) && getBoard().checkEmpty(myRow,myColumn)) {
            getBoard().setBoard(getLetter(),myRow,myColumn);
            return true;
        }
        else
            return false;
            
    }
}
