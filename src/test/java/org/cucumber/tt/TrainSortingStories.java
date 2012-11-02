package org.cucumber.tt;


import java.util.Stack;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * SimpleTrainSort BDD testing example. 
 * 
 * @author nlopez
 *
 */
public class TrainSortingStories {
	
	private TrainSort trainTrack;

	@Given("^a unsorted train \"([^\"]*)\" in a three way train track.$")
	public void a_unsorted_train_in_a_three_way_train_track(String arg1){
		trainTrack = new SimpleTrainSort();
		
		for ( int i = 0; i < arg1.length() ; i++ )
		{
			trainTrack.inputTrackAdd(arg1.charAt(i));
		}
		
		assertEquals("Failed adding cars into input train track",trainTrack.numOfCarsInInput(),arg1.length());
	}
	
	@When("^train size is equal to \"([^\"]*)\"$")
	public void train_size_is_equal_to(String arg1){
	   assertTrue(trainTrack.numOfCarsInInput() == Integer.parseInt(arg1));
	}
	
	@When("^\"([^\"]*)\" track is \"([^\"]*)\"$")
	public void track_is(String arg1, String arg2) {
		if ( arg1.equals("side") && arg2.equals("empty"))
		{
			assertTrue("Check that side track is empty",trainTrack.numOfCarsInSide() == 0);
		}
		else if ( arg1.equals("side") && arg2.equals("not empty"))
		{
			assertFalse("Check that side track is empty",trainTrack.numOfCarsInSide() == 0);
		}
		else if ( arg1.equals("input") && arg2.equals("empty"))
		{
			assertTrue("Check that input track is empty",trainTrack.numOfCarsInInput() == 0);
		}
		else if ( arg1.equals("exit") && arg2.equals("not empty"))
		{
			assertFalse("Check that exit track is not empty",trainTrack.numOfCarsInExit() == 0);
		}
		else if ( arg1.equals("exit") && arg2.equals("empty"))
		{
			assertTrue("Check that exit track is not empty",trainTrack.numOfCarsInExit() == 0);
		}
		else
		{
			assertNotNull("Error the conditions do not exist", null);
		}
		
	}
	
	@Then("^move the next car in \"([^\"]*)\" track into \"([^\"]*)\" track$")
	public void move_the_next_car_in_track_into_track(String arg1, String arg2){
		
		int numOfCarsInInput = trainTrack.numOfCarsInInput();
		int numOfCarsInSide =  trainTrack.numOfCarsInSide();
		int numOfCarsInExit =  trainTrack.numOfCarsInExit();
		
		trainTrack.simpleSortStep();
		
		if ( arg1.equals("input") && arg2.equals("exit"))
		{
			assertEquals("Failde creating train with one car",trainTrack.numOfCarsInInput(),numOfCarsInInput-1);
			assertEquals("Failde creating train with one car",trainTrack.numOfCarsInExit(),numOfCarsInExit+1);
		}
		else if ( arg1.equals("input") && arg2.equals("side"))
		{
			assertEquals("Failde creating train with one car",trainTrack.numOfCarsInInput(),numOfCarsInInput-1);
			assertEquals("Failde creating train with one car",trainTrack.numOfCarsInSide(),numOfCarsInSide+1);
		}
		else
		{
			assertNotNull("Error the conditions do not exist", null);
		}
		
	}
	
	
	@When("^the next car in input track is \"([^\"]*)\" than the next car in siding track$")
	public void the_next_car_in_input_track_is_than_the_next_car_in_siding_car(String arg1){
	     if ( arg1.equals("greater") )
	     {
	    	 assertTrue("Check that next input car is greater than next side car", trainTrack.peekInput() > trainTrack.peekSide());
	     }
	     else if ( arg1.equals("smaller") )
	     {
	    	 assertTrue("Check that next input car is greater than next side car", trainTrack.peekInput() < trainTrack.peekSide());
	     }
	}
	
	@Then("^move the next car in side track into exit track, and move next car in input track into side track$")
	public void move_the_next_car_in_side_track_into_exit_track_and_move_next_car_in_input_track_into_side_track() throws Throwable {
		int currentInputTrackSize = trainTrack.numOfCarsInInput();
		int currentSideTrackSize =  trainTrack.numOfCarsInSide();
		int currentExitTrackSize =  trainTrack.numOfCarsInExit();
		
		trainTrack.simpleSortStep();
		
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInInput(),currentInputTrackSize-1);
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInSide(),currentSideTrackSize);
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInExit(),currentExitTrackSize+1);
	}
	
	@Then("^move exit cars into input track, and move first input track into side track$")
	public void move_exit_cars_into_input_track_and_move_first_input_track_into_side_track(){
		int currentInputTrackSize = trainTrack.numOfCarsInInput();
		int currentSideTrackSize =  trainTrack.numOfCarsInSide();
		int currentExitTrackSize =  trainTrack.numOfCarsInExit();
		
		trainTrack.simpleSortStep();
		
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInInput(),currentExitTrackSize-1);
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInSide(),currentSideTrackSize+1);
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInExit(),currentInputTrackSize);
	    
	}

	@Then("^train is sorted! move cars into input track and then to exit track.$")
	public void train_is_sorted_move_cars_into_input_track_and_then_to_exit_track() throws Throwable {
		int currentInputTrackSize = trainTrack.numOfCarsInInput();
		int currentSideTrackSize =  trainTrack.numOfCarsInSide();
		int currentExitTrackSize =  trainTrack.numOfCarsInExit();
		
		trainTrack.simpleSortStep();
		
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInInput(),currentInputTrackSize);
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInSide(),currentExitTrackSize);
		assertEquals("Failde creating train with one car",trainTrack.numOfCarsInExit(),currentSideTrackSize);
	}
	
	@Then("^check the train is sorted$")
	public void check_the_train_is_sorted(){
		Stack<Integer> exitTrack = trainTrack.getExitTrack();
		
		for (int i = 0 ; i < exitTrack.size()-1; i++)
		{
			assertTrue("Train is not sorted", exitTrack.get(i) < exitTrack.get(i+1));
		}
	}
	
	@When("^train is sorted$")
	public void train_is_sorted(){
		trainTrack.sort();
		assertTrue("Sorting algorithm did not work!", trainTrack.isTrainSorted());
	}
	
}
