
public class RowReduction {
	/*
	 * Test Case 1: {(1,5,7),(-2,-7,-5)} Pivot every row
	 * Test Case 2: {(1,2,2,8),(-1,1,4,4),(-1,-1,1,9)} Pivot every row
	 * Test Case 3: {(1,2,3,4),(4,3,2,1)} LD matrix
	 * Test Case 4: {(1,2,2,4,1),(0,1,1,2,1),(0,0,0,2,1),(0,0,0,1,1)} LD matrix already in echelon form

	 */
	public Matrix RowReduce(Matrix mat)
	{
		MatrixOperations operator = new MatrixOperations(); 
		// check if matrix is already in echelon form 
		for(int i = 0; i < mat.getRow(); i++) // Turns the leading entries of each row into pivots
		{
		
			if(mat.matrix[i][i] != 0 && mat.matrix[i][i] != 1) { // Skips columns with no leading entries to avoid dividing by zero 
				double scalar = 1/mat.matrix[i][i];
				operator.rowScale(mat, i, scalar);
			}
	
		
			for(int j = i + 1; j < mat.getRow();j++) // Kills all the entries below the pivot
			{
				
				double scale = -(mat.matrix[j][i]);
				mat = operator.rowReplacement(mat, i, j, scale);
			}
			
		}
		boolean[] pivotTracker = new boolean[mat.getRow()];
		for(int i = 0; i < mat.getRow(); i++)
		{
			if(mat.matrix[i][i] == 1)
			{
				pivotTracker[i] = true;  
			}
		}
		
	for(int i = pivotTracker.length - 1; i > 0; i--)
	{
		if(pivotTracker[i])
		{
			for(int j = i - 1; j >= 0; j--)
			{
				double scale = -(mat.matrix[j][i]);
				mat = operator.rowReplacement(mat, i, j, scale);
			}
		}
	}
	//for(int i = 0; i < ) interchange zero rows

		return mat;
	}
}
