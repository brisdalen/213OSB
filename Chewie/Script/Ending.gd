extends Node2D

var game_end = false

func _process(delta):
	if game_end == false:
		var spots = $Spots.get_child_count()
		for i in $Spots.get_children():
			if i.occupied:
				spots -= 1
	
		if spots == 0:
			$AcceptDialog.popup()
			game_end = true



