
public class MatrixOperations {

	public Matrix rowInterchange(Matrix mat, int row1, int row2)
	{
		double[] temp = new double[mat.getColumn()]; // Creates temporary double array to store the values of row1
		for(int i = 0; i < mat.getColumn();i++)   
		{
			temp[i] = mat.matrix[row1][i];
		}
		for(int j = 0; j < mat.getColumn();j++)  // Replaces entries of row1 with entries of row2
		{
			mat.matrix[row1][j] = mat.matrix[row2][j];
		}
		for(int k = 0; k < mat.getColumn();k++)
		{
			mat.matrix[row2][k] = temp[k];
		}
		System.out.println();
		System.out.println("R"+(row1+1)+" <=> R"+(row2+1));
		mat.outputMatrix();
		return mat; 
		
	}
	public Matrix rowReplacement(Matrix mat, int row1, int row2, double scalar) //row1 is being scaled
	{
		double[] subtractor = new double[mat.getColumn()]; //Creates a temporary double array to store the scaled entries of row1
		for(int i = 0; i < mat.getColumn();i++)
		{
			subtractor[i] = mat.matrix[row1][i] * scalar; 
		}
		for(int j = 0; j < mat.getColumn(); j++) // Adds scaled entries of row1 to row2
		{
			mat.matrix[row2][j] += subtractor[j];
		}
		System.out.println();
		System.out.println(scalar+"R"+(row1+1) +" + R"+(row2+1) +" --> R"+(row2+1));
		mat.outputMatrix();
		return mat; 
		
	}
	public Matrix rowScale(Matrix mat, int row, double scalar)
	{
		for(int i = 0; i < mat.getColumn();i++ )
		{
			mat.matrix[row][i] *= scalar; 
		}
		System.out.println();
		System.out.println(scalar+"R"+(row +1) +"--> R"+(row +1) );
		mat.outputMatrix(); 
		return mat; 
	}
	

}
