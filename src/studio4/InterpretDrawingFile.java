package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Parameter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); // making Scanner with a File

		String shapeType;
		int redComponent;
		int greenComponent;
		int blueComponent;
		boolean isFilled;
		double penRadius = .05;
		double parameterOne;
		double parameterTwo;
		double parameterThreein;
		double parameterFour;
		double parameterFive;
		double parameterSix;
		while (in.hasNext()) {
			shapeType = in.next();
			redComponent = in.nextInt();
			greenComponent = in.nextInt();
			blueComponent = in.nextInt();
			isFilled = in.nextBoolean();
			parameterOne = in.nextDouble();
			parameterTwo = in.nextDouble();
			parameterThreein = in.nextDouble();
			StdDraw.setPenRadius(penRadius);
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			if (!isFilled) {
				if (shapeType.equalsIgnoreCase("circle")) {
					StdDraw.circle(parameterOne, parameterTwo, parameterThreein);
				} else if (shapeType.equalsIgnoreCase("square")) {
					StdDraw.square(parameterOne, parameterTwo, parameterThreein);
				} else if (shapeType.equalsIgnoreCase("ellipse")){
					parameterFour = in.nextDouble();
					StdDraw.ellipse(parameterOne, parameterTwo, parameterThreein, parameterFour);
				} else {
					parameterFour = in.nextDouble();
					StdDraw.rectangle(parameterOne, parameterTwo, parameterThreein, parameterFour);
				}
			} else {
				if (shapeType.equalsIgnoreCase("circle")) {
					StdDraw.filledCircle(parameterOne, parameterTwo, parameterThreein);
				} else if (shapeType.equalsIgnoreCase("square")) {
					StdDraw.filledSquare(parameterOne, parameterTwo, parameterThreein);
				} else if (shapeType.equals("ellipse")) {
					parameterFour = in.nextDouble();
					StdDraw.filledEllipse(parameterOne, parameterTwo, parameterThreein, parameterFour);
				} else {
					parameterFour = in.nextDouble();
					StdDraw.filledRectangle(parameterOne, parameterTwo, parameterThreein, parameterFour);
				}
			}
		}
		in.close();
	}
}
