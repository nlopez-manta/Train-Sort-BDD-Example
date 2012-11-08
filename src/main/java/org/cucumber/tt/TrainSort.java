package org.cucumber.tt;

import java.util.Stack;

/**
 * Interface for train sorting algorithms.
 * 
 * Simple sorting algorithm for sorting cars in a train using only 3 train
 * tracks.
 * 
 * Rules: 
 * - Stacks are used to represent the railroads. 
 * - You can only add cars in input track. 
 * - No duplicate IDs. 
 * - IDs only range from 0 to 9. 
 * - Cars can use any track to push the car in.
 * 
 * @author nlopez
 * @date 11/1/12
 */
public interface TrainSort {

	/**
	 * Method to step through the simple algorithm.
	 * 
	 * @return true or false if the train is sorted.
	 */
	public boolean simpleSortStep();

	/**
	 * Method to sort train.
	 * 
	 * @return true or false depending if the sorting was successful or not.
	 */
	public boolean sort();

	/**
	 * Method for adding cars into the input track
	 * 
	 * @param inCar
	 *            ID of the car.
	 */
	public void inputTrackAdd(int inCar);

	/**
	 * This method returns the number of cars in the input track.
	 * 
	 * @return number of cars in the input track.
	 */
	public int numOfCarsInInput();

	/**
	 * This method returns the number of cars in the side track.
	 * 
	 * @return number of cars in the side track.
	 */
	public int numOfCarsInSide();

	/**
	 * This method returns the number of cars in the exit track.
	 * 
	 * @return number of cars in the exit track.
	 */
	public int numOfCarsInExit();

	/**
	 * Returns the ID of the next available car in the side track.
	 * 
	 * @return car's ID
	 */
	public int peekExit();

	/**
	 * Returns the ID of the next available car in the input track.
	 * 
	 * @return car's ID
	 */
	public int peekInput();

	/**
	 * Method that returns the reference of the exit track.
	 * 
	 * @return
	 */
	public Stack<Integer> getExitTrack();

	/**
	 * Method to check is the train is sorted.
	 * 
	 * @return true or false depending if the train is sorted.
	 */
	public boolean isTrainSorted();
}
