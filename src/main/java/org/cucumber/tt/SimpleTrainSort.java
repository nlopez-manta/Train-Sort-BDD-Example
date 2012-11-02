package org.cucumber.tt;

import java.util.Stack;

/**
 * Simple sorting algorithm for sorting cars in a train using only 3 train tracks.
 * 
 * Rules
 * 
 * @author nlopez
 *
 */
public class SimpleTrainSort {
	
	// representing tracks as stacks
	private Stack<Integer> inputTrack;
	private Stack<Integer> sideTrack;
	private Stack<Integer> exitTrack;
	
	// Variable to keep track if train is sorted
	boolean sorted;
	
	/**
	 * Default constructor
	 */
	public SimpleTrainSort()
	{
		// initialize;
		inputTrack = new Stack<Integer>();
		sideTrack = new Stack<Integer>();
		exitTrack = new Stack<Integer>();
		sorted = false;
	}
	
	/**
	 * Method to step through the simple algorithm.
	 * 
	 * @return true or false if the train is sorted.
	 */
	public boolean simpleSortStep()
	{
		if (inputTrack.size() == 1 && sideTrack.empty())
		{
			exitTrack.push(inputTrack.pop());
		}
		else if (sideTrack.empty())
		{
			sideTrack.push(inputTrack.pop());
		}
		else if ( inputTrack.empty() && !sideTrack.empty() && !exitTrack.empty() )
		{
			while (!exitTrack.empty())
			{
				inputTrack.push(exitTrack.pop());
			}
			
			sideTrack.push(inputTrack.pop());
		}
		else if ( inputTrack.empty() && !sideTrack.empty() && exitTrack.empty() )
		{
			while (!sideTrack.empty())
			{
				inputTrack.push(sideTrack.pop());
			}
			
			while (!inputTrack.empty())
			{
				exitTrack.push(inputTrack.pop());
			}
			
			return true;
		}
		else if (inputTrack.peek() > sideTrack.peek())
		{
	          exitTrack.push(inputTrack.pop());
		}
		else if (inputTrack.peek() < sideTrack.peek()){
            exitTrack.push(sideTrack.pop());
            sideTrack.push(inputTrack.pop());
        }   
		
		
		return false;
	}
	
	/**
	 * Method to sort train.
	 * 
	 * @return true or false depending if the sorting was successful or not.
	 */
	public boolean sort()
	{
		while (!sorted)
		{
			sorted = simpleSortStep();
		}
		
		return sorted;
	}
	
	/**
	 * Method for adding cars into the input track
	 * 
	 * @param inCar ID of the car.
	 */
	public void inputTrackAdd(int inCar)
	{
		inputTrack.push(inCar);
	}
	
	/**
	 * This method returns the number of cars in the input track.
	 * @return number of cars in the input track.
	 */
	public int numOfCarsInInput()
	{
		return inputTrack.size();
	}
	
	/**
	 * This method returns the number of cars in the side track.
	 * @return number of cars in the side track.
	 */
	public int numOfCarsInSide()
	{
		return sideTrack.size();
	}
	
	/**
	 * This method returns the number of cars in the exit track.
	 * @return number of cars in the exit track.
	 */
	public int numOfCarsInExit()
	{
		return exitTrack.size();
	}
	
	/**
	 * Returns the ID of the next available car in the side track.
	 * @return car's ID
	 */
	public int peekSide()
	{
		return sideTrack.peek();
	}
	
	/**
	 * Returns the ID of the next available car in the input track.
	 * @return car's ID
	 */
	public int peekInput()
	{
		return inputTrack.peek();
	}

	/**
	 * Method that returns the reference of the exit track.
	 * @return
	 */
	public Stack<Integer> getExitTrack()
	{
		return exitTrack;
	}
	
	/**
	 * Method to check is the train is sorted.
	 * @return true or false depending if the train is sorted.
	 */
	public boolean isTrainSorted()
	{
		return sorted;
	}
}
