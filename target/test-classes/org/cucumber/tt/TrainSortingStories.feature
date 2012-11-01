Feature: Registration Paths

	Background: 
  		# All trains start in the input track.

	Scenario: Train with one car.
	
  		Given a unsorted train "7" in a three way train track.
		When "side" track is "empty"
		Then move the next car in input track into exit track
	
	Scenario: Train with cars "375"
	
		Given a unsorted train "375" in a three way train track.
		
		When "side" track is "empty"
		Then move the next car in the input track and move it to the side track.
	
		When the next car in input track is "greater" than the next car in siding track  
		Then move the next car in input track into exit track
	
		When the next car in input track is "smaller" than the next car in siding track
		Then move the next car in side track into exit track, and move next car in input track into side track
	
		When "input" track is "empty"
		And "side" track is "not empty"
		And "exit" track is "not empty"
		Then move exit cars into input track, and move first input track into side track
		
		When the next car in input track is "smaller" than the next car in siding track
		Then move the next car in side track into exit track, and move next car in input track into side track
		
		When "input" track is "empty"
		And "side" track is "not empty"
		And "exit" track is "not empty"
		Then move exit cars into input track, and move first input track into side track
	
		When "side" track is "not empty"
		And "input" track is "empty"
		And "exit" track is "empty"
		Then train is sorted! move cars into input track and then to exit track.
		And check the train is sorted
		
	Scenario: Train with cars "5647382901"
		
		Given a unsorted train "5647382901" in a three way train track.
		When train is sorted
		Then check the train is sorted