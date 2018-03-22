/*
* Course: CS 1302
* Section: 09
* Professor: Carlos A. Cepeda
* Name: Austin Atteberry
* Assignment #: JavaFx Project
*/

package MemoryMatchObject;

public class MemoryMatch {
	
	/* Private data fields */
	private int rows, columns;
	private int[][] cardPosition;
	private String[] imageLocation;
	private String[][] cardImages;
	
	
	/* MemoryMatch method
	 * Description: Default constructor method
	 */
	public MemoryMatch() {
		/* Assign array size */
		this.rows = 4;
		this.columns = 6;
		
		/* Fill array */
		this.cardPosition = CreatePositionArray();
		
		/* Assign cardLocation */
		this.setImageLocation(0, "/Pictures/Match00.jpg");
		this.setImageLocation(1, "/Pictures/Match01.jpg");
		this.setImageLocation(2, "/Pictures/Match02.jpg");
		this.setImageLocation(3, "/Pictures/Match03.jpg");
		this.setImageLocation(4, "/Pictures/Match04.jpg");
		this.setImageLocation(5, "/Pictures/Match05.jpg");
		this.setImageLocation(6, "/Pictures/Match06.jpg");
		this.setImageLocation(7, "/Pictures/Match07.jpg");
		this.setImageLocation(8, "/Pictures/Match08.jpg");
		this.setImageLocation(9, "/Pictures/Match09.jpg");
		this.setImageLocation(10, "/Pictures/Match10.jpg");
		this.setImageLocation(11, "/Pictures/Match11.jpg");
		
		/* Initialize cardImages array */
		this.cardImages = new String[rows][columns];
		
		/* Fill cardImages array */
		this.setCardImages(this.imageLocation);
	}
	
	
	/* MemoryMatch method
	 * Description: Overloaded constructor method
	 */
	public MemoryMatch(int rows, int columns, String[] imageLocation) {
		/* Limit row size to at least 2 rows */
		if(rows <= 1) {
			rows = 2;
		}
		
		/* Limit column size to at least 2 columns */
		if(columns <= 1) {
			columns = 1;
		}
		
		/* Assign array size */
		this.rows = rows;
		this.columns = columns;
		
		/* Fill array */
		this.cardPosition = CreatePositionArray();
		
		/* Assign cardLocation */
		this.setImageLocation(imageLocation);
		
		/* Initialize cardImages array */
		this.cardImages = new String[rows][columns];
		
		/* Fill cardImages array */
		this.setCardImages(this.imageLocation);
	}
	
	
	/* getCardPosition method
	 * Description: cardPosition accessor method
	 */
	public int[][] getCardPosition() {
		return this.cardPosition;
	}
	
	
	/* setImageLocation method (Overloaded)
	 * Description: Mutator method for cardLocation
	 */
	public void setImageLocation(String[] cardLocation) {
		for(int i = 0; i < this.imageLocation.length; i++) {
			try {
				/* Copy string to variable and assign it to instance variable */
				String temp = cardLocation[i];
				this.imageLocation[i] = temp;
			}
			catch(java.lang.ArrayIndexOutOfBoundsException ex) {
				/* Skip if out of bounds */
			}
		}
	}
	
	
	/* setImageLocation method (Overloaded)
	 * Description: Mutator method for cardLocation
	 */
	public void setImageLocation(int arrayLocation, String imageLocation) {
		try {
			/* Assign string to instance variable */
			this.imageLocation[arrayLocation] = imageLocation;
		}
		catch(java.lang.ArrayIndexOutOfBoundsException ex) {
			/* Skip if out of bounds */
		}
	}
	
	
	/* getImageLocation method (Overloaded)
	 * Description: Accessor method for cardLocation
	 */
	public String[] getImageLocation() {
		return this.imageLocation;
	}
	
	
	/* getImageLocation method (Overloaded)
	 * Description: Accessor method for cardLocation
	 */
	public String getImageLocation(int location) {
		return this.imageLocation[location];
	}
	
	
	/* setCardImages method
	 * Description: Mutator method for cardImages
	 */
	private void setCardImages(String[] imageLocation) {
		try {
			/* Assign values individually */
			for(int i = 0; i < this.cardPosition.length; i++) {
				for(int j = 0; j < this.cardPosition[i].length; j++) {
					this.cardImages[i][j] = imageLocation[cardPosition[i][j]];
				}
			}
		}
		catch(java.lang.ArrayIndexOutOfBoundsException ex) {
			/* Skip if out of bounds */
		}
	}
	
	
	/* getCardImages method
	 * Description: Accessor method for cardImages
	 */
	public String[][] getCardImages() {
		return this.cardImages;
	}
	
	
	/* CreatePositionArray method
	 * Description: Returns a filled 2-dimensional array
	 */
	private int[][] CreatePositionArray() {
		/* Verify an even number of items */
		if(((this.rows * this.columns) % 2) != 0) {
			this.rows += 1; // Add row to get even number
		}
		
		/* Variable declaration section */
		int[][] temp = new int[this.rows][this.columns];
		int numPairs, pair = 0;
		
		/* Calculate the number of pairs */
		numPairs = ((this.rows * this.columns) / 2) - 1;
		
		/* Initialize imageLocation array */
		this.imageLocation = new String[numPairs + 1];
		
		/* Create Random object */
		java.util.Random generator = new java.util.Random();
		
		/* Fill array */
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				/* Set array value */
				temp[i][j] = pair;
				
				/* Increase pair or reset to zero */
				if(pair < numPairs) {
					pair++;
				}
				else {
					pair = 0;
				}
			}
		}
		
		/* Randomly mix array values */
		for(int i = 0; i < 1000; i++) {
			/* Generate two random array positions */
			int swapRow1 = generator.nextInt(this.rows);
			int swapColumn1 = generator.nextInt(this.columns);
			int swapRow2 = generator.nextInt(this.rows);
			int swapColumn2 = generator.nextInt(this.columns);
			
			/* Store values from random array positions */
			int swapValue1 = temp[swapRow1][swapColumn1];
			int swapValue2 = temp[swapRow2][swapColumn2];
			
			/* Swap array position values */
			temp[swapRow2][swapColumn2] = swapValue1;
			temp[swapRow1][swapColumn1] = swapValue2;
		}
		
		/* Return array */
		return temp;
	}
}