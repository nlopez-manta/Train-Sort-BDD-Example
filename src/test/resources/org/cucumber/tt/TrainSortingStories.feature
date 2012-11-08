Feature: Registration Paths

	Background: 
  		# All trains start in the input track.

	Scenario: Train with one car.
	
  		Given a unsorted train "7" in a three way train track.
  		When train size is equal to "1"
		And "side" track is "empty"
		Then move the next car in "input" track into "exit" track
	
	Scenario: Train with cars "375"
	
		Given a unsorted train "375" in a three way train track.
		
		When "exit" track is "empty"
		Then move the next car in "input" track into "exit" track
	
		When the next car in input track is "greater" than the next car in exit track  
		Then move the next car in "input" track into "side" track
	
		When the next car in input track is "smaller" than the next car in exit track
		Then move the next car in exit track into side track, and move next car in input track into exit track
	
		When "input" track is "empty"
		And "side" track is "not empty"
		And "exit" track is "not empty"
		Then move side cars into input track, and move first input car into exit track
		
		When the next car in input track is "smaller" than the next car in exit track
		Then move the next car in exit track into side track, and move next car in input track into exit track
		
		When "input" track is "empty"
		And "side" track is "not empty"
		And "exit" track is "not empty"
		Then move side cars into input track, and move first input car into exit track
	
		When "side" track is "empty"
		And "input" track is "empty"
		And "exit" track is "not empty"
		Then train is sorted! check the train is sorted.
		
	Scenario: Train with cars "5647382901"
		
		Given a unsorted train "5647382901" in a three way train track.
		When train is sorted
		Then train is sorted! check the train is sorted.