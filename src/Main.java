import java.util.Scanner;
import java.util.ArrayList;

 
public class Main {

	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in); 
		Matrix mat = MatrixCreator(sc); 
		String input = inputMatrix(mat);
		mat.pruneInputMatrix(input);
		MatrixOperations operator = new MatrixOperations();
		RowReduction reducer = new RowReduction(); 
		reducer.RowReduce(mat);
		/* Scaling Test
			mat = operator.rowScale(mat, 1, 2); 
		  Interchange Test	
			mat = operator.rowInterchange(mat, 0, 1);  
	   Replacement Test
			mat = operator.rowReplacement(mat, 0, 1, -2);*/
	}
	
// Asks user to enter number of rows and columns and creates a Matrix using given input
	public static Matrix MatrixCreator(Scanner sc)
	{
		System.out.println("Enter number of rows:"); 
		String temprow = sc.next(); 
		System.out.println("Enter number of columns:"); 
		String tempcolumn = sc.next(); 
		
		Integer row = Integer.parseInt(temprow); 
		Integer column = Integer.parseInt(tempcolumn); 
		Matrix newMatrix = new Matrix(row, column); 
		
		return newMatrix; 
	}
// Asks user to input matrix.  Returns string containing raw input data
	public static String inputMatrix(Matrix mat)
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the rows of each matrix in the following format: {(a,b,c),(d,e,f)...(x,y,z)}");
		// Creates a string array and converts it to an integer array 
		String line = sc.nextLine(); 	
		//System.out.println(line);
		return line; 
	}	
}
