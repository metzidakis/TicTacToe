import java.util.Scanner;
import java.util.Arrays;
public class TicTacToeGrid {

	//variables
	private static String[][] values = new String[3][3];

	//constructor
	//TicTacToeGrid ( String[][] ticTacToeGrid ) {
	//	this.values = ticTacToeGrid;
	//}

	//constructor
	TicTacToeGrid () {
		this.values = new String[3][3];
		for ( int i = 0; i <=2; i++ ) {
			for (int a = 0; a <=2; a++) {
				this.values[i][a] = " ";
			}
		}
	}

	//Getters and Setters
	public static String[][] getValues() {return values;};
	public void setValue( int x, int y, String z) { this.values[x][y] = z; };



	//method to generate the grid
	public static void generateGrid(String[][] ticTacToeValues) {
		System.out.println();
		System.out.print("                     -------------------");
		for ( int i = 0; i <=2; i++ ) {
			System.out.println();
			System.out.print("                   ");
			for (int a = 0; a <=2; a++) {
				System.out.print( "  |  " + ticTacToeValues[i][a]);
			}
			System.out.print("  |  ");
		    System.out.println();
			System.out.print("                     -------------------");
		}
		System.out.println();
		System.out.println();
	}

	//check if there is a winner and if there is it prints him
	public boolean checkWinner() {
		boolean gameover = false;
		String winner = " no winner ";
		for ( int i = 0; i <=2; i++ ) {
			if (  this.values[i][0].equals(this.values[i][1]) && this.values[i][2].equals(this.values[i][1])  && !this.values[i][0].equals(" ") ) {
				gameover = true;
				winner = this.values[i][0];
			}
			if (  this.values[0][i].equals(this.values[1][i]) && this.values[2][i].equals(this.values[1][i])  && !this.values[0][i].equals(" ") ) {
				gameover = true;
				winner = this.values[0][i];
			}
		}
		if ( this.values[0][0].equals(this.values[1][1]) && this.values[2][2].equals(this.values[1][1])  && !this.values[0][0].equals(" ") ) {
				gameover = true;
				winner = this.values[0][0];
		}
		if ( this.values[2][0].equals(this.values[1][1]) && this.values[0][2].equals(this.values[1][1])  && !this.values[1][1].equals(" ") ) {
			    gameover = true;
			    winner = this.values[2][0];
		}
		if ( gameover == true ) {
			System.out.println( "Player " + winner + " wins the game");
		}
		return ( gameover );
	}

	//check if board is full
	public boolean checkIfBoardIsFull() {
		boolean isFull = true;
		for ( int i = 0; i <= 2; i++ ) {
			for ( int a = 0; a <= 2; a++ ) {
				if ( this.values[i][a].equals(" ") ) {
					isFull = false;
				}
			}
		}
		if ( isFull == true ) {
			System.out.println( "There is no winner, you are both equally good at this. Try again to see who will endure and prevail!!!");
		}
		return isFull;
	}

	//check if the user input is legit
	public boolean validator( int x, int y ) {
		boolean numok = false;
		int i = x - 1;
		int a = y - 1;
		if (this.values[i][a].equals(" ") ) {
			numok = true;
		}
		if (!(this.values[i][a].equals(" "))) {
			System.out.println("In case you did not notice this cell is taken... try again");
		}
		return numok;
	}

	//ensures user inputs 1 , 2 , 3 only
	public int numValidator() {
		Scanner input = new Scanner(System.in);
		int correctInput;
		boolean validateInput = false;
		String proxyx = "a";
		while ( validateInput == false ) {
			proxyx = input.nextLine();
			if ( proxyx.equals("1") || proxyx.equals("2") || proxyx.equals("3") ) {
				validateInput = true;
			} else {
				System.out.println("input 1 or 2 or 3");
			}
		}
		correctInput = Integer.parseInt(proxyx);
		return correctInput;

	}



}

