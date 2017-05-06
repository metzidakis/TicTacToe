import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe {

	/*
	Implement a tic tac toe (triliza) game which is played by two players.
	You may use one or two dimention array to store the results (the 'X' and 'O').
	You can use a while loop to give turns for the 'X' or the 'O' player.
	Create a drawFunction that can take as an argument the array and print the current tic tac toe's status before each players turn.
	Create function that can check rows, columns, and diagonals, which is performed after a player played his symbol,
	'X' or 'O', and prints win if there is a winner, otherwise the game still goes on if and if there is available position in the array.
	If a player placed his symbol in an occupied position print an error message and let him play again.
	*/




	public static void main(String []args) {

		//Welcome message and rules
		System.out.println("                         WELCOME          ");
		System.out.println("                THIS IS A TIC TAC TOE GAME");
		System.out.println(" RULES: WAIT YOUR TURN, THEN INPUT THE NUMBER OF ROW AND COLUMN");
		System.out.println("               THAT YOU WANT TO PLACE YOUR MARKER");
		System.out.println("              FORM A LINE OF 3 MARKERS AND WIN !!!");
		System.out.println("               MAY THE FORCE GUIDE YOUR X XOR O");
		System.out.println();
		System.out.println();
		System.out.println();

		// Generate the Grid
		TicTacToeGrid ticTacToeGrid = new TicTacToeGrid();
		boolean haveWinner = false;
		boolean isBoardFull = false;
		boolean turnX = true;
		boolean validateInput = false;
		String proxyx = "4";
		String proxyy = "4";

		//Generate the starting grid
		ticTacToeGrid.generateGrid(ticTacToeGrid.getValues());


		// Game starts
		do {
			int nrowpx = 4;
			int ncolpx = 4;
			Scanner input = new Scanner(System.in);
			if ( turnX == true ){
				boolean numok = false;
				while ( numok == false ) {
					System.out.println("It is Player X turn");
					System.out.println("Input the number of row u wanna place X:");
					nrowpx = ticTacToeGrid.numValidator();
				    System.out.println("Input the number of column u wanna place X:");
					ncolpx = ticTacToeGrid.numValidator();
					numok = ticTacToeGrid.validator( nrowpx , ncolpx );
				}
				ticTacToeGrid.setValue( nrowpx-1, ncolpx-1, "X" );
				ticTacToeGrid.generateGrid(ticTacToeGrid.getValues());
				turnX = false;
			}else {
				int nrowpo = 4;
				int ncolpo = 4;
				boolean numok = false;
				while( numok == false ) {
					System.out.println("It is Player O turn");
					System.out.println("Input the number of row u wanna place O:");
					nrowpo = ticTacToeGrid.numValidator();
					System.out.println("Input the number of column u wanna place O:");
					ncolpo = ticTacToeGrid.numValidator();
					numok = ticTacToeGrid.validator( nrowpo , ncolpo );
				}
				ticTacToeGrid.setValue( nrowpo-1, ncolpo-1, "O" );
				ticTacToeGrid.generateGrid(ticTacToeGrid.getValues());
				turnX = true;
			}
			haveWinner = ticTacToeGrid.checkWinner();
			isBoardFull = ticTacToeGrid.checkIfBoardIsFull();


			} while ( haveWinner == false && isBoardFull == false );




	}



}