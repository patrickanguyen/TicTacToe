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
public class Board {
    private String[][] board = {{"","",""},{"","",""},{"","",""}};
    private String winnerLetter;
    public final int row = 3;
    public final int column = 3;
    
    /**
     * Method that changes board into new letter
     * @param letter new letter
     * @param r row of array
     * @param c column of array
     */
    
    public void setBoard(String letter, int r, int c) {
        board[r][c] = letter;
    }
    
    /**
     * Method that checks if position is array is empty
     * @param r row of array
     * @param c column of array
     * @return true if position empty
     * and false if position not empty
     */
    public boolean checkEmpty(int r, int c) {
        return board[r][c].equals("");
    }
    
    /**
     * Prints out board
     * @return board in String
     */
    public String toString() {
        String output = "";
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c].equals(""))
                    output += " ";
                else
                    output += board[r][c];
                if (c != board[0].length-1)
                    output += " | ";
            }
            if (r != board.length-1)
                output += "\n";
        }
        return output;
    }
    
    /**
     * Method that returns letter of given position
     * @param row
     * @param column
     * @return letter of the selected position on board
     */
    public String getPosition(int row, int column) {
        return board[row][column];
    }
    
    /**
     * Method that checks if player has won
     * @return true if a player has got three letters in a row or diagonally
     * false if there isn't
     */
    public boolean checkWinner() {
        return checkDiagonal() || checkRows() || checkCol() || checkTie();
    }
    
    /**
     * Method that checks if same dots in row
     * @return true if winner
     */
    public boolean checkDiagonal() {
        String center = getPosition(1,1);
        String topLeft = getPosition(0,0);
        String topRight = getPosition(0,2);
        String bottomLeft = getPosition(2,0);
        String bottomRight = getPosition(2,2);
        if (center.equals(topLeft) && center.equals(bottomRight) && !center.equals("")){
            winnerLetter = center;
            return true;
        }
            
        else if (center.equals(topRight) && center.equals(bottomLeft) && !center.equals("")) {
            winnerLetter = center;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Method that checks for row with same letter
     * @return true if found and false if not
     */
    public boolean checkRows() {
        int same;
        for (int r = 0; r < 3; r++) {
            String letter = getPosition(r,0);
            same = 0;
            for (int c = 1; c < 3; c++) {
                if (letter.equals(getPosition(r,c)) && !letter.equals(""))
                    same++;
            }
            if (same == 2){
                winnerLetter = letter;
                return true;
            }
                
        }
        return false;
    }
    
    /**
     * Method that checks for letters with same column
     * @return true if winner
     */
    public boolean checkCol() {
        int same;
        for (int c = 0; c < 3; c++) {
            String letter = getPosition(0,c);
            same = 0;
            for (int r = 1; r < 3; r++) {
                if (letter.equals(getPosition(r,c)) && !letter.equals(""))
                    same++;
            }
            if (same == 2) {
                winnerLetter = letter;
                return true;
            }
                
        }
        return false;
    }
    /**
     * Method that checks for tie
     * @return true if all spaces are taken
     */
    public boolean checkTie() {
        int filledSquares = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!getPosition(r,c).equals(""))
                    filledSquares++;
            }
        }
        
        return filledSquares == 9;
    }
    
    /**
     * Method that returns the letter of the winner
     * @return single String character of winner
     */
    public String getWinnerLetter(){
        return winnerLetter;
    }
}
