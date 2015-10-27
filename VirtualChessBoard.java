import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class VirtualChessBoard {

	public enum Chessmen {
		WHITE_KING, WHITE_QUEEN, WHITE_ROOK, WHITE_BISHOP, WHITE_KNIGHT, WHITE_PAWN, BLACK_KING, BLACK_QUEEN, BLACK_ROOK, BLACK_BISHOP, BLACK_KNIGHT, BLACK_PAWN, EMPTY
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String move = "";
		
		Chessmen[][] chessboard = new Chessmen[8][8];
		populateBoard(chessboard);
		
		while (!move.equalsIgnoreCase("exit")) {
			printBoard(chessboard);
			System.out.println("Input your move or type exit");
			move = input.nextLine();
			int fromRow = translateFromRow(move);
			int fromCol = translateFromCol(move);
			int toRow = translateToRow(move);
			int toCol = translateToCol(move);
			boolean isValid = isValid (chessboard,fromRow, fromCol, toRow, toCol);
			if (isValid)
			{
				if (isWhite(chessboard[toRow][toCol])==true)
				{
					aList.add(chessboard[toRow][toCol]);
				}
				else 
				{
					bList.add(chessboard[toRow][toCol]);
				}
				System.out.println("White pieces taken: " + aList.toString());
				System.out.println("Black pieces taken: " + bList.toString());
				chessboard[toRow][toCol] = chessboard[fromRow][fromCol];
				chessboard[fromRow][fromCol] = Chessmen.EMPTY;
			}
			else
			{
				System.out.println("Try again?");
			}
			
		}
	
	}

	static ArrayList <Chessmen> aList = new ArrayList <Chessmen> ();
	static ArrayList <Chessmen> bList = new ArrayList <Chessmen> ();
	
//	public static void aListPrint (Chessmen piece)
//	{
//		for (Iterator <Chessmen> iterator = aList.iterator(); iterator.hasNext();)
//			piece = iterator.next();
//			if ("EMPTY".equals(piece))
//			{
//				iterator.remove ();
//		System.out.println("White pieces taken: " + aList.toString());
//			}
//	}
	public static void populateBoard(Chessmen[][] chessboard) {
		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard.length; j++) {
				if (i == 0 && (j == 0 || j == 7))
					chessboard[i][j] = Chessmen.BLACK_ROOK;
				else if (i == 0 && (j == 1 || j == 6))
					chessboard[i][j] = Chessmen.BLACK_KNIGHT;
				else if (i == 0 && (j == 2 || j == 5))
					chessboard[i][j] = Chessmen.BLACK_BISHOP;
				else if (i == 0 && j == 3)
					chessboard[i][j] = Chessmen.BLACK_QUEEN;
				else if (i == 0 && j == 4)
					chessboard[i][j] = Chessmen.BLACK_KING;
				else if (i == 1 && j >= 0 && j <= 7)
					chessboard[i][j] = Chessmen.BLACK_PAWN;
				else if (i == 6 && j >= 0 && j <= 7)
					chessboard[i][j] = Chessmen.WHITE_PAWN;
				else if (i == 2 || i == 3 || i == 4 || i == 5)
					chessboard[i][j] = Chessmen.EMPTY;
				else if (i == 7 && (j == 0 || j == 7))
					chessboard[i][j] = Chessmen.WHITE_ROOK;
				else if (i == 7 && (j == 1 || j == 6))
					chessboard[i][j] = Chessmen.WHITE_KNIGHT;
				else if (i == 7 && (j == 2 || j == 5))
					chessboard[i][j] = Chessmen.WHITE_BISHOP;
				else if (i == 7 && j == 3)
					chessboard[i][j] = Chessmen.WHITE_QUEEN;
				else if (i == 7 && j == 4)
					chessboard[i][j] = Chessmen.WHITE_KING;
			}
		}
	}

	public static void printBoard(Chessmen[][] chessboard) {

		String chars = "  a\tb\tc\td\te\tf\tg\th";
		System.out.println(chars);

		for (int i = 0; i < chessboard.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < chessboard.length; j++) {
				switch (chessboard[i][j]) {
				case BLACK_ROOK:
					System.out.print("\u265C \t");
					break;
				case BLACK_KNIGHT:
					System.out.print("\u265E \t");
					break;
				case BLACK_BISHOP:
					System.out.print("\u265D \t");
					break;
				case BLACK_QUEEN:
					System.out.print("\u265B \t");
					break;
				case BLACK_KING:
					System.out.print("\u265A \t");
					break;
				case BLACK_PAWN:
					System.out.print("\u265F \t");
					break;
				case WHITE_PAWN:
					System.out.print("\u2659 \t");
					break;
				case WHITE_ROOK:
					System.out.print("\u2656 \t");
					break;
				case WHITE_KNIGHT:
					System.out.print("\u2658 \t");
					break;
				case WHITE_BISHOP:
					System.out.print("\u2657 \t");
					break;
				case WHITE_QUEEN:
					System.out.print("\u2655 \t");
					break;
				case WHITE_KING:
					System.out.print("\u2654 \t");
					break;
				case EMPTY:
					System.out.print(" " + "\t");

				}

			}
			System.out.print("\n");
		}
	}

	public static int translateFromRow(String move) {
		String[] letter = move.split(" ");
		char variable = letter[0].charAt(1);
		int fromRow = 8 - ((int) (variable) - 48);
		return fromRow;
	}

	public static int translateFromCol(String move) {
		String[] letter = move.split(" ");
		char variable = letter[0].charAt(0);
		int fromCol = (int) variable - 97;
		return fromCol;
	}

	public static int translateToRow(String move) {
		String[] letter = move.split(" ");
		char variable = letter[2].charAt(1);
		int toRow = 8 - ((int) (variable) - 48);
		return toRow;
	}

	public static int translateToCol(String move) {
		String[] letter = move.split(" ");
		char variable = letter[2].charAt(0);
		int toCol = (int) variable - 97;
		return toCol;
	}

	public static boolean isWhite(Chessmen piece) {

		switch (piece) {

		case BLACK_ROOK:
		case BLACK_BISHOP:
		case BLACK_KNIGHT:
		case BLACK_PAWN:
		case BLACK_QUEEN:
		case BLACK_KING:
			return false;
		default:
			return true;

		}
	}

	public static boolean diagonalMoveR(int fromRow, int fromCol, int toRow,
			int toCol) {
		boolean isTrue = true;
		if (toRow == fromRow + 1 && toCol == fromRow + 1) {
			isTrue = true;
		}

		return isTrue;
	}

	public static boolean diagonalMoveL(int fromRow, int fromCol, int toRow,
			int toCol) {
		boolean isTrue = true;
		if (toRow == fromRow - 1 && toCol == fromRow - 1) {
			isTrue = true;
		}

		return isTrue;
	}

	public static boolean verticalMoveWP(Chessmen[][] chessboard, int fromRow,
			int fromCol, int toRow, int toCol, boolean isWhite) {

		for (int i = fromRow; i >= 0; i--) {
			if (chessboard[i][fromCol] != Chessmen.EMPTY) {
				if ((isWhite(chessboard[i][fromCol]) && isWhite)
						|| (!isWhite(chessboard[i][fromCol]) && !isWhite)) {
					break;
				} else {
					if (chessboard[i][fromCol] == chessboard[toRow][toCol]) {
						return true;
					} else {
						break;
					}
				}
			}
		}

		return false;
	}

	public static boolean verticalMoveBP(Chessmen[][] chessboard, int fromRow,
			int fromCol, int toRow, int toCol, boolean isWhite) {
		for (int i = fromRow; i < 7; i++) {
			if (chessboard[i][fromCol] != Chessmen.EMPTY) {
				if ((isWhite(chessboard[i][fromCol]) && isWhite)
						|| (!isWhite(chessboard[i][fromCol]) && !isWhite)) {
					break;
				} else {
					if (chessboard[i][fromCol] == chessboard[toRow][toCol]) {
						return true;
					} else {
						break;
					}
				}
			}
		}

		return false;
	}

	public static boolean horizontalMoveBP(Chessmen[][] chessboard,
			int fromRow, int fromCol, int toRow, int toCol, boolean isWhite) {
		for (int i = fromCol; i < 7; i++) {
			if (chessboard[fromRow][i] != Chessmen.EMPTY) {
				if (((isWhite(chessboard[fromRow][i]) && isWhite) || (!isWhite(chessboard[fromRow][i]) && !isWhite))) {
					break;
				} else if (chessboard[fromRow][i] == chessboard[toRow][toCol]) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	public static boolean horizontalMoveWP(Chessmen[][] chessboard,
			int fromRow, int fromCol, int toRow, int toCol, boolean isWhite) {
		for (int i = fromCol; i >= 0; i--) {
			if (chessboard[fromRow][i] != Chessmen.EMPTY) {
				if (((isWhite(chessboard[fromRow][i]) && isWhite) || (!isWhite(chessboard[fromRow][i]) && !isWhite))) {
					break;
				} else if (chessboard[fromRow][i] == chessboard[toRow][toCol]) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	public static boolean validDiagonalMoveRBP(Chessmen [][] chessboard, int fromRow, int fromCol, int toRow, int toCol, boolean isWhite) {
		if (toRow>0 && toCol>0)
		{
		for (int i = fromRow; i < 7; i++) {
			for (int j = fromCol; j<7; j++)
			{
				if  (chessboard[toRow][toCol] != Chessmen.EMPTY) 
				{
				if ((isWhite(chessboard[fromRow][fromCol]) && isWhite(chessboard[toRow][toCol])) 
						|| (!isWhite(chessboard[fromRow][fromCol]) && !isWhite(chessboard[toRow][toCol]))) {
							break;
					} 
				else if (chessboard[fromRow][fromCol] == chessboard[i][j]) {
							return true;
				}
				}
			}
		}
		}
		return false;
	}
	
	public static boolean validDiagonalMoveLBP(Chessmen [][] chessboard, int fromRow, int fromCol, int toRow, int toCol, boolean isWhite) {
		if (toRow>0 && toCol>0)
		{
		for (int i = fromRow; i < 7; i++) {
			for (int j = fromCol; j>=0; j--)
			{
				if  (chessboard[toRow][toCol] != Chessmen.EMPTY) 
				{
				if ((isWhite(chessboard[fromRow][fromCol]) && isWhite(chessboard[toRow][toCol])) 
						|| (!isWhite(chessboard[fromRow][fromCol]) && !isWhite(chessboard[toRow][toCol]))) {
							break;
					} 
				else if (chessboard[fromRow][fromCol] == chessboard[i][j]) {
							return true;
				}
				}
			}
		}
		}
		return false;
	}

	public static boolean validDiagonalMoveRWP(Chessmen [][] chessboard, int fromRow, int fromCol, int toRow, int toCol, boolean isWhite) {
		if (toRow>0 && toCol>0)
		{
		for (int i = fromRow; i <7; i++) {
			for (int j = fromCol; j>=0; j--)
			{
				if  (chessboard[toRow][toCol] != Chessmen.EMPTY) 
				{
				if ((isWhite(chessboard[fromRow][fromCol]) && isWhite(chessboard[toRow][toCol])) 
						|| (!isWhite(chessboard[fromRow][fromCol]) && !isWhite(chessboard[toRow][toCol]))) {
							break;
					} 
				else if (chessboard[fromRow][fromCol] == chessboard[i][j]) {
							return true;
				}
				}
			}
		}
		}
		return false;
	}
	
	public static boolean validDiagonalMoveLWP(Chessmen [][] chessboard, int fromRow, int fromCol, int toRow, int toCol) {
		if (toRow>0 && toCol>0)
		{
		for (int i = fromRow; i < 7; i++) {
			for (int j = fromCol; j>=0; j--)
			{
				if  (chessboard[toRow][toCol] != Chessmen.EMPTY) 
				{
				if ((isWhite(chessboard[fromRow][fromCol]) && isWhite(chessboard[toRow][toCol])) 
						|| (!isWhite(chessboard[fromRow][fromCol]) && !isWhite(chessboard[toRow][toCol]))) {
							break;
					} 
				else if (chessboard[fromRow][fromCol] == chessboard[i][j]) {
							return true;
				}
				}
			}
		}
		}
		return false;
	}
							
public static boolean isValid(Chessmen[][] chessboard, int fromRow, int fromCol, int toRow, int toCol) 
	{
		System.out.println(chessboard[fromRow][fromCol]);

		if (fromRow < 0 || fromRow > 8 || toRow < 0 || toRow > 8 || fromCol < 0
				|| toCol > 8) {
			return false;
		}
		if (fromRow == toRow && fromCol == toCol) {
			return false;
		}

		switch (chessboard[fromRow][fromCol]) {
		
		case BLACK_PAWN:
			if (toCol == fromCol && toRow == fromRow + 1)
				return true;
			else if (fromRow == 1
					&& (toRow == fromRow + 1 || toRow == fromRow + 2))
				return true;
			else if ((diagonalMoveR(fromRow, fromCol, toRow, toCol) == true || diagonalMoveL(
					fromRow, fromCol, toRow, toCol) == true)
					&& chessboard[toRow][toCol] != Chessmen.EMPTY)
				return true;
			else 
				System.out.println("Error");
			return false;
		case WHITE_PAWN:
			if (toCol == fromCol && toRow == fromRow + 1)
				return true;
			else if (fromRow == 6
					&& (toRow == fromRow + 1 || toRow == fromRow + 2))
				return true;
			else if ((diagonalMoveR(fromRow, fromCol, toRow, toCol) == true || diagonalMoveL(
					fromRow, fromCol, toRow, toCol) == true)
					&& chessboard[toRow][toCol] != Chessmen.EMPTY)
				return true;
			else 
				System.out.println("Error");
			return false;
		
		case BLACK_KING:
				if ((toCol == fromCol || toCol == fromCol - 1 || toCol == fromCol + 1)
						&& (toRow == fromRow || toRow == fromRow - 1 || toRow == fromRow + 1)
						&& (chessboard[toRow][toCol] == Chessmen.EMPTY || isWhite(chessboard[toRow][toCol]))) {
					return true;
				} else {
					System.out.println("Error");
					return false;
				}

		case BLACK_QUEEN:
				if ((validDiagonalMoveRBP(chessboard,fromRow, fromCol, toRow, toCol,
						isWhite(chessboard[toRow][toCol])) || (validDiagonalMoveLBP(chessboard,
						fromRow, fromCol, toRow, toCol,
						isWhite(chessboard[toRow][toCol])) || (verticalMoveBP(chessboard,
						fromRow, fromCol, toRow, toCol,
						isWhite(chessboard[toRow][toCol])) || (horizontalMoveBP(chessboard,
						fromRow, fromCol, toRow, toCol,
						isWhite(chessboard[toRow][toCol]))))))) {
					return true;
				} else {
					System.out.println("Error");
					return false;
				}

			case BLACK_ROOK:
				if (fromRow ==toRow && (toCol == fromCol-1) || toRow == fromRow + 1 && fromCol==toCol)
				return true;
				if (isWhite(chessboard[toRow][toCol])==true)
				return true;
				else 
					System.out.println("Error");
				return false;
				
			case BLACK_BISHOP:
				if ((validDiagonalMoveRBP(chessboard,fromRow, fromCol, toRow, toCol,
						isWhite(chessboard[toRow][toCol])) || (validDiagonalMoveLBP(chessboard,
						fromRow, fromCol, toRow, toCol,
						isWhite(chessboard[toRow][toCol]))))) {
					return true;
				} else {
					System.out.println("Error");
					return false;
				}

			case BLACK_KNIGHT:
				if (((toRow == fromRow + 2 || toRow == fromRow - 2) && (toCol == fromCol - 1 || toCol == fromCol + 1))
						&& (chessboard[toRow][toCol] == Chessmen.EMPTY || isWhite(chessboard[toRow][toCol]))) {
					return true;
				} else if (((toRow == fromRow - 1 || toRow == fromRow + 1) && (toCol == fromCol + 2 || toCol == fromCol - 2))
						&& (chessboard[toRow][toCol] == Chessmen.EMPTY || isWhite(chessboard[toRow][toCol]))) {
					return true;
				} else {
					System.out.println("Error");
					return false;
				}

				case WHITE_KING:
			if ((toCol == fromCol || toCol == fromCol - 1 || toCol == fromCol + 1)
					&& (toRow == fromRow || toRow == fromRow - 1 || toRow == fromRow + 1)
					&& (chessboard[toRow][toCol] == Chessmen.EMPTY || !isWhite(chessboard[toRow][toCol]))) {
				return true;
			} else {
				System.out.println("Error");
				return false;
			}

		case WHITE_QUEEN:
			if ((validDiagonalMoveRWP(chessboard,fromRow, fromCol, toRow, toCol,
					isWhite(chessboard[toRow][toCol])) || (validDiagonalMoveLBP(chessboard,
					fromRow, fromCol, toRow, toCol,
					isWhite(chessboard[toRow][toCol])) || (verticalMoveWP(chessboard
					,fromRow, fromCol, toRow, toCol,
					isWhite(chessboard[toRow][toCol])) || (horizontalMoveWP(chessboard,
					fromRow, fromCol, toRow, toCol,
					isWhite(chessboard[toRow][toCol]))))))) {
				return true;
			} else {
				System.out.println("Error");
				return false;
			}

		case WHITE_ROOK:
			
			if (toRow == fromRow -1 && toCol == fromCol || toRow == fromRow && toCol==fromCol+1)
				return true;
				if (isWhite(chessboard[toRow][toCol])==false)
				return true;
				else
					return false;

		case WHITE_BISHOP:
			if ((validDiagonalMoveRWP(chessboard,fromRow, fromCol, toRow, toCol,
					isWhite(chessboard[toRow][toCol])) || (validDiagonalMoveLWP(chessboard,
					fromRow, fromCol, toRow, toCol)))) {
				return true;
			} else {
				System.out.println("Error");
				return false;
			}

		case WHITE_KNIGHT:
			if (((toRow == fromRow + 2 || toRow == fromRow - 2) && (toCol == fromCol - 1 || toCol == fromCol + 1))
					&& (chessboard[toRow][toCol] == Chessmen.EMPTY || isWhite(chessboard[toRow][toCol]))) {
				return true;
			} else if (((toRow == fromRow - 1 || toRow == fromRow + 1) && (toCol == fromCol + 2 || toCol == fromCol - 2))
					&& (chessboard[toRow][toCol] == Chessmen.EMPTY || isWhite(chessboard[toRow][toCol]))) {
				return true;
			} else {
				System.out.println("Error");
				return false;
			}


		default:
			return false;
		}

	}

	{

	}

}
