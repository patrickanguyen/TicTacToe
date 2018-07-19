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
public class RobotPlayer extends Players{
    private int myRow = 0;
    private int myColumn = 0;
    public RobotPlayer(Board board, String name) {
        super(board,name);
    }
    
    /**
     * Chooses spot on board
     */
    public void select() {
        boolean selected = false;
        think();
        while (!selected) {
            if (getBoard().checkEmpty(myRow,myColumn) && (myColumn < getBoard().column) && getBoard().checkEmpty(myRow,myColumn) && !getBoard().checkWinner()) {
                getBoard().setBoard(getLetter(),myRow,myColumn);
                selected = true;
            }
            else if (getBoard().checkWinner())
                selected = true;
            else
                think();
        }
    }
    
    public int getRow(){
        return myRow;
    }
    public int getColumn() {
        return myColumn;
    }
    
    /**
     * Randomly selects row and column for computer
     */
    public void think() {
        myRow = (int)(Math.random()*3);
        myColumn = (int)(Math.random()*3);
    }
}
