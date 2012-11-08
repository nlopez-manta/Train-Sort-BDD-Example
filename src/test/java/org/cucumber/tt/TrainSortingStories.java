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
		}/*
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
		}*/

	}
	
	@Then("^move the next car in \"([^\"]*)\" track into \"([^\"]*)\" track$")
	public void move_the_next_car_in_track_into_track(String arg1, String arg2)
	{

		int numOfCarsInInput = trainTrack.numOfCarsInInput();
		int numOfCarsInExit =  trainTrack.numOfCarsInExit();

		trainTrack.simpleSortStep();

		if ( arg1.equals("input") && arg2.equals("exit"))
		{
			assertEquals("Wrong number of cars in input track",trainTrack.numOfCarsInInput(),numOfCarsInInput-1);
			assertEquals("Wrong number of cars in exit track",trainTrack.numOfCarsInExit(),numOfCarsInExit+1);
		}
		else
		{
			assertNotNull("Error the conditions do not exist", null);
		}

	}	

}