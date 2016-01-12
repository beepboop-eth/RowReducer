
public class Matrix {
	protected int row; 
	protected int column;
	protected double matrix[][]; 
	
	public Matrix(int r, int c)
	{
		row = r; 
		column = c; 
		matrix = new double[r][c]; 
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public double[][] getMatrix() {
		return matrix;
	}
	
	public void outputMatrix(){
		for(int i = 0; i < row; i++)
		{
			
				System.out.println();
			
			for(int j = 0; j < column; j++)
			{
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
		}
	}

	
	public String pruneInputMatrix(String input)
	{
		
		int rowcount = 0;
		int openP = input.indexOf("(");  // contains index of opening parenthesis
		int closeP = input.indexOf(")");
		int lastcloseP = input.lastIndexOf(")"); 
		//System.out.println(lastcloseP);
		while(closeP <= lastcloseP)
		{
			
			String temprow = input.substring(openP + 1,closeP); // substring containing a row of the matrix
			String[] StringRow = temprow.split(","); // Splits temprow using commas as delimiters
			Double[] row = new Double[column];
			for(int i = 0; i < row.length; i++)
			{
				row[i] = Double.parseDouble(StringRow[i]);    // Converts string array to double array
			}
			for(int i = 0; i < column; i++)
			{
				matrix[rowcount][i] = row[i];              // Adds current row to matrix
			}
			rowcount++;                         // updates values for rowcount, openP, and closeP
			openP = input.indexOf("(", openP +1);
			if(openP < 0) // checks if openP can still be found
			{
				break;
			}
			closeP = input.indexOf(")", closeP +1);
			
		} 
		
		outputMatrix(); 
		
		return input; 
	}
	
}
