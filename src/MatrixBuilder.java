public class MatrixBuilder {
		
	public static double[][] matrix;
	public static double[][] abReduced;
	
	public static double high,
				  low,
				  avg,
				  size;
	
	public MatrixBuilder() {}
	
	
	public  static void valores(double[][] data) {
        
	
		double sum=0;
		 high = data[0][0];
		 low = data[0][0];
		 avg=0;
		 size=0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if(high<data[i][j]) {
					high=data[i][j];
				}
				if(data[i][j]<low) {
					low=data[i][j];
				}
				sum+=data[i][j];
				size++;
			}
		}
		avg=sum/size;
		
	}
	
	
	public static double[][] generateEcuations( int rows_columns, int tmp_up, int tmp_down, int tmp_left ,int tmp_right){
		int double_rows=rows_columns*rows_columns;
		double[][] matrix= new double[double_rows][double_rows];
		double[] augmentedMatrix=new double[double_rows];
		int counter=0;
		
		for (int i=0;i<rows_columns;i++) {
			for (int j=0;j<rows_columns;j++) {
				if (i==0) {							//Comprobar si está en la primer fila
					if (j==0) {						//Comprobar si es la primer esquina
						augmentedMatrix[counter]=-(tmp_left+tmp_up);
						matrix[counter][counter]=-4;
						matrix[counter][counter+1]=1;
						matrix[counter][counter+rows_columns]=1;
					}else if (j==rows_columns-1) {	//Comprobar si es la segunda esquina
						augmentedMatrix[counter]=-(tmp_up+tmp_right);
						matrix[counter][counter]=-4;
						matrix[counter][counter-1]=1;
						matrix[counter][counter+rows_columns]=1;
					}else {							//Si es parte de la primer fila, pero no esquina
						augmentedMatrix[counter]=-tmp_up;
						matrix[counter][counter]=-4;
						matrix[counter][counter+1]=1;
						matrix[counter][counter-1]=1;
						matrix[counter][counter+rows_columns]=1;
					}
				}else if(i==rows_columns-1) {
					if(j==0) {
						augmentedMatrix[counter]=-(tmp_left+tmp_down);
						matrix[counter][counter]=-4;
						matrix[counter][counter+1]=1;
						matrix[counter][counter-rows_columns]=1;
					}else if (j==rows_columns-1) {
						augmentedMatrix[counter]=-(tmp_down+tmp_right);
						matrix[counter][counter]=-4;
						matrix[counter][counter-1]=1;
						matrix[counter][counter-rows_columns]=1;
					}else {
						augmentedMatrix[counter]=-tmp_down;
						matrix[counter][counter]=-4;
						matrix[counter][counter-1]=1;
						matrix[counter][counter+1]=1;
						matrix[counter][counter-rows_columns]=1;
					}
				}else if(j==0) {
					augmentedMatrix[counter]=-tmp_left;
					matrix[counter][counter]=-4;
					matrix[counter][counter+1]=1;
					matrix[counter][counter+rows_columns]=1;
					matrix[counter][counter-rows_columns]=1;
				}else if(j==rows_columns-1) {
					augmentedMatrix[counter]=-tmp_right;
					matrix[counter][counter]=-4;
					matrix[counter][counter-1]=1;
					matrix[counter][counter+rows_columns]=1;
					matrix[counter][counter-rows_columns]=1;
				}else {
					matrix[counter][counter]=-4;
					matrix[counter][counter-1]=1;
					matrix[counter][counter+1]=1;
					matrix[counter][counter+rows_columns]=1;
					matrix[counter][counter-rows_columns]=1;
				}
				
				
				
				
				
				
				counter++;
			}
			
			
			}
		
		
		double fullMatrix[][]=new double [double_rows][double_rows+1];
		for (int i=0;i<double_rows;i++) {
			for (int j=0;j<double_rows;j++) {
				fullMatrix[i][j]=matrix[i][j];
			}
			fullMatrix[i][double_rows]=augmentedMatrix[i];
		}
		
		return fullMatrix;
	}
	
	public double[][] cloneMatrix(double[][] matrix, int rows_columns){
		double[][] tmp=new double[rows_columns][rows_columns+1];
		for(int i = 0; i < rows_columns; i++)
		    {
		      for(int j = 0; j < rows_columns+1; j++)
		      {
		        tmp[i][j] = matrix[i][j];
		      }
		    }
		    return tmp;
		
	}
	
	public static double[][] Gauss_Jordan(double epsilon, double[][] matrix, int rows_columns)
	  {
	    double[][] abReduced = new MatrixBuilder().cloneMatrix(matrix, rows_columns);
	    int m=rows_columns;
	    int n=rows_columns+1;
	    for(int i = 0; i < m; i++)
	    {
	      if(Math.abs(abReduced[i][i]) < epsilon)
	      {
	        for(int k = i + 1; k < m; k++)
	        {
	          if(Math.abs(abReduced[k][i]) > epsilon)
	          {
	          
	            for(int j = 0; j < n; j++)
	            {
	              double temp = abReduced[k][j];
	              abReduced[k][j] = abReduced[i][j];
	              abReduced[i][j] = temp;
	            }
	            break;
	          }
	        }
	        if(Math.abs(abReduced[i][i]) < epsilon)
	        {
	          
	        }
	      }
	      double piv = abReduced[i][i];
	      for(int j = 0; j < n; j++)
	      {
	        abReduced[i][j] = abReduced[i][j] / piv;
	      }
	      
	      for(int k = 0; k < m; k++)
	      {
	        if(k != i)
	        {
	          double factor = -abReduced[k][i];
	          for(int j = 0; j < n; j++)
	          {
	            abReduced[k][j] = abReduced[i][j] * factor + abReduced[k][j]; 
	          }
	        }
	      }
	    }
	    return abReduced;
	  }
	
	public static double[][] coordenadasXY(double[][] abReduced, int rows_columns){
		int double_rows=rows_columns*rows_columns;
		double[][] resultadoXY=new double[rows_columns][rows_columns];
	    int count=0;
	    for(int i=0;i<rows_columns;i++) {
	    		for (int j=0;j<rows_columns;j++) {
	    			resultadoXY[i][j]=abReduced[count][double_rows];
	    			count++;
	    		}
	    }
	    
	    for (double[] rows : resultadoXY) {
			for (double number : rows) {
				
				System.out.printf("%.2f",number);
				System.out.print(" ");
			}
			System.out.println();
		} 
	    return resultadoXY;
	}
	
	

	
}