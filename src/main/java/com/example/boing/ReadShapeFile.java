package com.example.boing;
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author musslimaz
 *
 */


import javafx.scene.paint.Color;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ReadShapeFile {

	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readLineByLine(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue

		List<String> shapeParameters;

		/* Inserting parameters of each shape into a List and
			passing it to the appropriate method to create a shape
		*/
		while(in.hasNextLine()) {
			shapeParameters = Arrays.asList(in.nextLine().split(" "));
			if (shapeParameters.get(0).equals("circle")) {
				shapeQueue.enqueue(readCircle(shapeParameters));
			}else if(shapeParameters.get(0).equals("oval")){
				shapeQueue.enqueue(readOval(shapeParameters));
			}else if(shapeParameters.get(0).equals("square")){
				shapeQueue.enqueue(readSquare(shapeParameters));
			}else if(shapeParameters.get(0).equals("rect")){
				shapeQueue.enqueue(readRect(shapeParameters));
			}else if(shapeParameters.get(0).equals("triangle")){
				shapeQueue.enqueue(readTriangle(shapeParameters));
			}
		}

		in.close();

		return shapeQueue;
	}


	/**
	 * Creates a new circle using List of shape parameters
	 *
	 * @param parameters
	 *            List of shape parameters
	 * @return an object Circle
	 */
	private static Circle readCircle(List<String> parameters){

		return new Circle( Integer.parseInt(parameters.get(1)),
				Integer.parseInt(parameters.get(2)),
				Integer.parseInt(parameters.get(3)),
				Integer.parseInt(parameters.get(4)),
				Integer.parseInt(parameters.get(5)),
				Integer.parseInt(parameters.get(7)),
				Color.rgb(Integer.parseInt(parameters.get(8)),
						  Integer.parseInt(parameters.get(9)),
						  Integer.parseInt(parameters.get(10))),
				Boolean.parseBoolean(parameters.get(6)));
	}


	/**
	 * Creates a new oval using List of shape parameters
	 *
	 * @param parameters
	 *            List of shape parameters
	 * @return an object Oval
	 */
	private static Oval readOval(List<String> parameters){

		return new Oval( Integer.parseInt(parameters.get(1)),
				Integer.parseInt(parameters.get(2)),
				Integer.parseInt(parameters.get(3)),
				Integer.parseInt(parameters.get(4)),
				Integer.parseInt(parameters.get(5)),
				Integer.parseInt(parameters.get(7)),
				Integer.parseInt(parameters.get(8)),
				Color.rgb(Integer.parseInt(parameters.get(9)),
						Integer.parseInt(parameters.get(10)),
						Integer.parseInt(parameters.get(11))),
				Boolean.parseBoolean(parameters.get(6)));
	}

	/**
	 * Creates a new square using List of shape parameters
	 *
	 * @param parameters
	 *            List of shape parameters
	 * @return an object Square
	 */
	private static Square readSquare(List<String> parameters){

		return new Square( Integer.parseInt(parameters.get(1)),
				Integer.parseInt(parameters.get(2)),
				Integer.parseInt(parameters.get(3)),
				Integer.parseInt(parameters.get(4)),
				Integer.parseInt(parameters.get(5)),
				Integer.parseInt(parameters.get(7)),
				Color.rgb(Integer.parseInt(parameters.get(8)),
						Integer.parseInt(parameters.get(9)),
						Integer.parseInt(parameters.get(10))),
				Boolean.parseBoolean(parameters.get(6)));
	}

	/**
	 * Creates a new rectangle using List of shape parameters
	 *
	 * @param parameters
	 *            List of shape parameters
	 * @return an object Rect
	 */
	private static Rect readRect(List<String> parameters){

		return new Rect( Integer.parseInt(parameters.get(1)),
				Integer.parseInt(parameters.get(2)),
				Integer.parseInt(parameters.get(3)),
				Integer.parseInt(parameters.get(4)),
				Integer.parseInt(parameters.get(5)),
				Integer.parseInt(parameters.get(7)),
				Integer.parseInt(parameters.get(8)),
				Color.rgb(Integer.parseInt(parameters.get(9)),
						Integer.parseInt(parameters.get(10)),
						Integer.parseInt(parameters.get(11))),
				Boolean.parseBoolean(parameters.get(6)));
	}

	/**
	 * Creates a new triangle using List of shape parameters
	 *
	 * @param parameters
	 *            List of shape parameters
	 * @return an object Triangle
	 */
	private static Triangle readTriangle(List<String> parameters){

		return new Triangle( Integer.parseInt(parameters.get(1)),
				Integer.parseInt(parameters.get(2)),
				Integer.parseInt(parameters.get(3)),
				Integer.parseInt(parameters.get(4)),
				Integer.parseInt(parameters.get(5)),
				Integer.parseInt(parameters.get(7)),
				Integer.parseInt(parameters.get(8)),
				Color.rgb(Integer.parseInt(parameters.get(9)),
						Integer.parseInt(parameters.get(10)),
						Integer.parseInt(parameters.get(11))),
				Boolean.parseBoolean(parameters.get(6)));
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {

	    // HINT: You might want to open a file here.
		File inputFile = new File(filename);
		Scanner in = null; //null is not sensible. Please change

		try {
			in = new Scanner(inputFile);
		}catch (FileNotFoundException e) {
			System.out.println("Could not find " + filename);
			e.printStackTrace();
		}


		return ReadShapeFile.readLineByLine(in);
	}
}
