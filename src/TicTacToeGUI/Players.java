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
abstract class Players {
    private Board myBoard;
    private String myLetter = "";
    private String myName;
    
    Players(Board board, String name) {
        myBoard = board;
        myName = name;
    }
    
    public Board getBoard(){
        return myBoard;
    }
    
    public void setLetter(String letter) {
        myLetter = letter;
    }
    
    public String getLetter() {
        return myLetter;
    }
    
    public String toString() {
        return myName;
    }
    
    public boolean sameLetter(String letter){
        return myLetter.equals(letter);
    }
    
    public String getName(){
        return myName;
    }
}
