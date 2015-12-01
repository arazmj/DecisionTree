# Generating Data Set

The function genTttMoveData() generates TTT data set but new human interaction as it uses SimpleMaxiMini
algorithm to find the best move, so feel free to regenerate the data. You may achive different data set 
by adjusting maxMoves and SEED constant variables. 

## Algorithm

The core algorithm for building decision trees called ID3 by J. R. Quinlan which employs a top-down,
greedy search through the space of possible branches with no backtracking. ID3 uses Entropy and Information
Gain to construct a decision tree.

## Instructions



## Output
Generating examples..................
Training Set: restaurant-train.txt
Patrons = None : No (2)
Patrons = Some : Yes (4)
Patrons = Full (6)
	Hungry = No : No (2)
	Hungry = Yes (4)
		Type = French : No
		Type = Italian : No (1)
		Type = Thai (2)
			FriSat = No : No (1)
			FriSat = Yes : Yes (1)
		Type = Burger : Yes (1)

Accuracy of decision tree on the training set : 100.0

Training Set: ids-train.txt
serror_rate = zero : normal (398)
serror_rate = 1-24 : normal (1)
serror_rate = 25-49 : normal (1)
serror_rate = 50-74 : normal
serror_rate = 75-99 : neptune (2)
serror_rate = oneHundred : neptune (398)

Accuracy of decision tree on the training set : 100.0
Accuracy of decision tree on the test set : 100.0

Training Set: ttt-train.txt
middle-middle = x (384)
	bottom-left = x (147)
		top-right = x : yes (77)
		top-right = o (51)
			bottom-right = x (18)
				top-left = x : yes (8)
				top-left = o (8)
					top-middle = x : no (2)
					top-middle = o : no (4)
					top-middle = b : yes (2)
				top-left = b : yes (2)
			bottom-right = o (22)
				middle-right = x (7)
					top-left = x (3)
						middle-left = x : yes (1)
						middle-left = o : no (2)
						middle-left = b : no
					top-left = o : yes (2)
					top-left = b : yes (2)
				middle-right = o : no (10)
				middle-right = b (5)
					top-left = x : yes (2)
					top-left = o (2)
						top-middle = x : yes (1)
						top-middle = o : no (1)
						top-middle = b : no
					top-left = b : yes (1)
			bottom-right = b (11)
				top-left = x : yes (3)
				top-left = o (6)
					top-middle = x : yes (2)
					top-middle = o : no (3)
					top-middle = b : yes (1)
				top-left = b : yes (2)
		top-right = b : yes (19)
	bottom-left = o (148)
		bottom-right = x (63)
			top-left = x : yes (38)
			top-left = o (17)
				middle-left = x (4)
					middle-right = x : yes (3)
					middle-right = o : no (1)
					middle-right = b : yes
				middle-left = o : no (10)
				middle-left = b (3)
					top-middle = x : yes (1)
					top-middle = o : no (1)
					top-middle = b : yes (1)
			top-left = b : yes (8)
		bottom-right = o (51)
			bottom-middle = x (20)
				top-middle = x : yes (12)
				top-middle = o (5)
					top-left = x (3)
						top-right = x : no (2)
						top-right = o : yes (1)
						top-right = b : no
					top-left = o : yes (1)
					top-left = b : yes (1)
				top-middle = b (3)
					top-left = x : no (1)
					top-left = o : no (1)
					top-left = b : yes (1)
			bottom-middle = o : no (21)
			bottom-middle = b (10)
				top-middle = x (5)
					top-right = x (3)
						top-left = x : yes (2)
						top-left = o : no (1)
						top-left = b : yes
					top-right = o : no (1)
					top-right = b : yes (1)
				top-middle = o : yes (2)
				top-middle = b : yes (3)
		bottom-right = b (34)
			middle-left = x : yes (17)
			middle-left = o (12)
				top-left = x : yes (3)
				top-left = o : no (6)
				top-left = b : yes (3)
			middle-left = b : yes (5)
	bottom-left = b (89)
		top-right = x : yes (15)
		top-right = o (48)
			bottom-middle = x (24)
				top-middle = x : yes (13)
				top-middle = o (8)
					top-left = x (3)
						middle-left = x : no (1)
						middle-left = o : yes (1)
						middle-left = b : yes (1)
					top-left = o : no (4)
					top-left = b : yes (1)
				top-middle = b (3)
					top-left = x : yes (1)
					top-left = o : yes (1)
					top-left = b : no (1)
			bottom-middle = o : yes (11)
			bottom-middle = b (13)
				top-left = x (8)
					bottom-right = x : yes (5)
					bottom-right = o (3)
						top-middle = x : no (1)
						top-middle = o : yes (1)
						top-middle = b : no (1)
					bottom-right = b : yes
				top-left = o : no (2)
				top-left = b (3)
					top-middle = x : no (1)
					top-middle = o : yes (1)
					top-middle = b : yes (1)
		top-right = b : yes (26)
middle-middle = o (277)
	bottom-right = x (135)
		bottom-middle = x (62)
			bottom-left = x : yes (35)
			bottom-left = o (21)
				middle-right = x (8)
					top-right = x : yes (4)
					top-right = o : no (4)
					top-right = b : no
				middle-right = o : no (8)
				middle-right = b : no (5)
			bottom-left = b (6)
				middle-right = x : yes (3)
				middle-right = o : no (3)
				middle-right = b : no
		bottom-middle = o (39)
			top-middle = x (15)
				top-right = x (8)
					bottom-left = x (3)
						middle-right = x : yes (1)
						middle-right = o : no (2)
						middle-right = b : no
					bottom-left = o : yes (4)
					bottom-left = b : yes (1)
				top-right = o (6)
					middle-right = x : no (4)
					middle-right = o : yes (1)
					middle-right = b : no (1)
				top-right = b : no (1)
			top-middle = o : no (18)
			top-middle = b (6)
				top-left = x (3)
					middle-right = x : no (1)
					middle-right = o : no (1)
					middle-right = b : yes (1)
				top-left = o : yes (1)
				top-left = b : yes (2)
		bottom-middle = b (34)
			top-right = x (18)
				middle-right = x : yes (12)
				middle-right = o (5)
					middle-left = x : no
					middle-left = o : no (4)
					middle-left = b : yes (1)
				middle-right = b : yes (1)
			top-right = o (12)
				bottom-left = x (4)
					top-middle = x : no (1)
					top-middle = o (2)
						top-left = x : yes (1)
						top-left = o : no (1)
						top-left = b : no
					top-middle = b : yes (1)
				bottom-left = o : no (8)
				bottom-left = b : no
			top-right = b (4)
				top-middle = x : no (2)
				top-middle = o : yes (1)
				top-middle = b : no (1)
	bottom-right = o (86)
		top-left = x (41)
			bottom-middle = x (16)
				middle-left = x (8)
					bottom-left = x : yes (4)
					bottom-left = o : no (3)
					bottom-left = b : no (1)
				middle-left = o (5)
					bottom-left = x : no (4)
					bottom-left = o : yes (1)
					bottom-left = b : no
				middle-left = b (3)
					top-right = x : yes (1)
					top-right = o : no (2)
					top-right = b : no
			bottom-middle = o (12)
				top-middle = x (7)
					top-right = x : yes (5)
					top-right = o : yes (1)
					top-right = b : no (1)
				top-middle = o : no (2)
				top-middle = b (3)
					bottom-left = x : yes (2)
					bottom-left = o : no (1)
					bottom-left = b : yes
			bottom-middle = b (13)
				top-right = x : yes (8)
				top-right = o (2)
					top-middle = x : no (1)
					top-middle = o : no
					top-middle = b : yes (1)
				top-right = b : yes (3)
		top-left = o : no (42)
		top-left = b : no (3)
	bottom-right = b (56)
		top-left = x (40)
			middle-right = x (12)
				top-right = x (5)
					top-middle = x : yes (3)
					top-middle = o : no (2)
					top-middle = b : yes
				top-right = o (5)
					bottom-left = x : yes (2)
					bottom-left = o : no (3)
					bottom-left = b : no
				top-right = b : no (2)
			middle-right = o (14)
				middle-left = x (8)
					bottom-left = x : yes (6)
					bottom-left = o : no (1)
					bottom-left = b : yes (1)
				middle-left = o : no (3)
				middle-left = b : yes (3)
			middle-right = b (14)
				bottom-left = x : yes (6)
				bottom-left = o (5)
					top-right = x : yes (3)
					top-right = o : no (2)
					top-right = b : yes
				bottom-left = b (3)
					top-middle = x : yes (2)
					top-middle = o : no (1)
					top-middle = b : yes
		top-left = o : no (4)
		top-left = b : no (12)
middle-middle = b (139)
	top-left = x (70)
		bottom-right = x : yes (15)
		bottom-right = o (38)
			bottom-left = x (20)
				middle-left = x : yes (14)
				middle-left = o (3)
					top-right = x : yes (2)
					top-right = o : no (1)
					top-right = b : yes
				middle-left = b (3)
					top-right = x : yes (1)
					top-right = o : no (2)
					top-right = b : no
			bottom-left = o (11)
				bottom-middle = x : yes (1)
				bottom-middle = o : no (7)
				bottom-middle = b : yes (3)
			bottom-left = b (7)
				top-right = x : yes (5)
				top-right = o : no (2)
				top-right = b : yes
		bottom-right = b : yes (17)
	top-left = o (47)
		bottom-right = x (36)
			bottom-left = x (18)
				bottom-middle = x : yes (12)
				bottom-middle = o (3)
					top-right = x : yes (2)
					top-right = o : no (1)
					top-right = b : yes
				bottom-middle = b (3)
					top-right = x : yes (1)
					top-right = o : no (2)
					top-right = b : no
			bottom-left = o (10)
				middle-left = x (2)
					top-middle = x : no
					top-middle = o : no (1)
					top-middle = b : yes (1)
				middle-left = o : no (6)
				middle-left = b : yes (2)
			bottom-left = b (8)
				top-right = x : yes (6)
				top-right = o : no (2)
				top-right = b : yes
		bottom-right = o : no (3)
		bottom-right = b : no (8)
	top-left = b (22)
		bottom-right = x : yes (15)
		bottom-right = o : no (7)
		bottom-right = b : yes

Accuracy of decision tree on the training set : 100.0
Accuracy of decision tree on the test set : 85.44304

Training Set: ttt-play-train.txt
middle-middle = x (70)
	top-left = x (14)
		bottom-left = x (2)
			top-right = x : top-right
			top-right = o : bottom-right (1)
			top-right = b : top-right (1)
		bottom-left = o (8)
			middle-right = x : middle-left (1)
			middle-right = o (4)
				top-middle = x : bottom-right
				top-middle = o : bottom-right (3)
				top-middle = b : top-middle (1)
			middle-right = b (3)
				bottom-middle = x : bottom-middle
				bottom-middle = o : bottom-right (1)
				bottom-middle = b : bottom-middle (2)
		bottom-left = b (4)
			top-middle = x : top-right (1)
			top-middle = o : bottom-left (2)
			top-middle = b : bottom-left (1)
	top-left = o (33)
		top-right = x (8)
			middle-left = x (3)
				top-middle = x : bottom-right
				top-middle = o : middle-right (1)
				top-middle = b (2)
					bottom-left = x : bottom-right
					bottom-left = o : bottom-right (1)
					bottom-left = b : bottom-left (1)
			middle-left = o : bottom-left (3)
			middle-left = b : middle-left (2)
		top-right = o (16)
			bottom-middle = x : top-middle (6)
			bottom-middle = o (5)
				middle-right = x : middle-left (1)
				middle-right = o (3)
					top-middle = x : bottom-right (1)
					top-middle = o : top-middle
					top-middle = b : top-middle (2)
				middle-right = b : middle-right (1)
			bottom-middle = b (5)
				top-middle = x : bottom-middle (3)
				top-middle = o : bottom-middle
				top-middle = b (2)
					middle-left = x : top-middle (1)
					middle-left = o : bottom-middle (1)
					middle-left = b : bottom-middle
		top-right = b (9)
			top-middle = x (2)
				middle-left = x : bottom-middle (1)
				middle-left = o : top-right
				middle-left = b : top-right (1)
			top-middle = o : top-right (6)
			top-middle = b : top-middle (1)
	top-left = b (23)
		bottom-right = x : top-left (9)
		bottom-right = o (9)
			bottom-left = x : middle-left (1)
			bottom-left = o (5)
				middle-left = x (2)
					top-right = x : bottom-middle (1)
					top-right = o : middle-right (1)
					top-right = b : bottom-middle
				middle-left = o : top-left (2)
				middle-left = b : top-left (1)
			bottom-left = b (3)
				top-right = x : bottom-left (2)
				top-right = o : top-left (1)
				top-right = b : bottom-left
		bottom-right = b (5)
			middle-left = x : top-left (1)
			middle-left = o (4)
				bottom-left = x : bottom-right (1)
				bottom-left = o (3)
					top-middle = x : top-left (1)
					top-middle = o (2)
						top-right = x : bottom-right (1)
						top-right = o : top-left (1)
						top-right = b : bottom-right
					top-middle = b : top-left
				bottom-left = b : bottom-right
			middle-left = b : top-left
middle-middle = o (75)
	top-right = x (26)
		top-left = x (6)
			top-middle = x : top-middle
			top-middle = o (3)
				middle-left = x : bottom-middle (1)
				middle-left = o : middle-left
				middle-left = b : middle-left (2)
			top-middle = b : top-middle (3)
		top-left = o (11)
			middle-right = x : bottom-right (4)
			middle-right = o (5)
				top-middle = x : middle-left (3)
				top-middle = o (2)
					middle-left = x : bottom-middle (1)
					middle-left = o : bottom-middle
					middle-left = b : bottom-left (1)
				top-middle = b : middle-left
			middle-right = b : middle-right (2)
		top-left = b (9)
			top-middle = x : top-left (6)
			top-middle = o (2)
				middle-left = x : bottom-right
				middle-left = o : bottom-right (1)
				middle-left = b : middle-left (1)
			top-middle = b : top-left (1)
	top-right = o (29)
		top-left = x (13)
			top-middle = x (5)
				middle-left = x : bottom-left (2)
				middle-left = o : middle-right (2)
				middle-left = b : bottom-left (1)
			top-middle = o (5)
				bottom-left = x (2)
					middle-left = x : bottom-middle
					middle-left = o : bottom-middle (1)
					middle-left = b : middle-left (1)
				bottom-left = o : bottom-left
				bottom-left = b : bottom-left (3)
			top-middle = b (3)
				bottom-middle = x : middle-right (1)
				bottom-middle = o : top-middle (2)
				bottom-middle = b : top-middle
		top-left = o (7)
			middle-right = x : bottom-left (1)
			middle-right = o : bottom-left (3)
			middle-right = b (3)
				top-middle = x : bottom-right (2)
				top-middle = o : bottom-right
				top-middle = b : top-middle (1)
		top-left = b (9)
			bottom-right = x (2)
				middle-left = x : top-left (1)
				middle-left = o : bottom-left (1)
				middle-left = b : bottom-left
			bottom-right = o : top-left (6)
			bottom-right = b : bottom-right (1)
	top-right = b (20)
		top-left = x (12)
			top-middle = x : top-right (5)
			top-middle = o (5)
				middle-right = x : bottom-middle (1)
				middle-right = o : top-right (2)
				middle-right = b : top-right (2)
			top-middle = b (2)
				middle-left = x : top-middle (1)
				middle-left = o : top-right (1)
				middle-left = b : top-right
		top-left = o : top-right (5)
		top-left = b (3)
			middle-left = x : top-left (2)
			middle-left = o : top-right (1)
			middle-left = b : top-left
middle-middle = b (55)
	top-right = x (23)
		middle-left = x (5)
			bottom-right = x (2)
				top-middle = x : middle-right
				top-middle = o : middle-right (1)
				top-middle = b : top-middle (1)
			bottom-right = o : center (2)
			bottom-right = b : center (1)
		middle-left = o : center (11)
		middle-left = b (7)
			bottom-left = x : center (3)
			bottom-left = o (4)
				top-left = x : center (1)
				top-left = o (3)
					top-middle = x (2)
						bottom-middle = x : center (1)
						bottom-middle = o : middle-left (1)
						bottom-middle = b : center
					top-middle = o : middle-left (1)
					top-middle = b : middle-left
				top-left = b : center
			bottom-left = b : center
	top-right = o (24)
		top-left = x : center (11)
		top-left = o (8)
			bottom-right = x : middle-left (1)
			bottom-right = o : center (6)
			bottom-right = b : center (1)
		top-left = b (5)
			middle-left = x (3)
				middle-right = x (2)
					bottom-left = x : top-left (1)
					bottom-left = o : center (1)
					bottom-left = b : center
				middle-right = o : top-left (1)
				middle-right = b : top-left
			middle-left = o : top-left (2)
			middle-left = b : top-left
	top-right = b (8)
		bottom-right = x : top-right (4)
		bottom-right = o (4)
			middle-right = x : center (1)
			middle-right = o (3)
				bottom-left = x : top-right (2)
				bottom-left = o : center (1)
				bottom-left = b : top-right
			middle-right = b : top-right
		bottom-right = b : top-right

Accuracy of decision tree on the training set : 100.0
Accuracy of decision tree on the test set : 56.0

Training Set: ttt-play-extra-train.txt
middle-middle = x (70)
	top-left = x (14)
		bottom-left = x (2)
			top-right = x : top-right
			top-right = o : bottom-right (1)
			top-right = b : top-right (1)
		bottom-left = o (8)
			middle-right = x : middle-left (1)
			middle-right = o (4)
				top-middle = x : bottom-right
				top-middle = o : bottom-right (3)
				top-middle = b : top-middle (1)
			middle-right = b (3)
				bottom-middle = x : bottom-middle
				bottom-middle = o : bottom-right (1)
				bottom-middle = b : bottom-middle (2)
		bottom-left = b (4)
			top-middle = x : top-right (1)
			top-middle = o : bottom-left (2)
			top-middle = b : bottom-left (1)
	top-left = o (33)
		top-right = x (8)
			middle-left = x (3)
				top-middle = x : bottom-right
				top-middle = o : middle-right (1)
				top-middle = b (2)
					bottom-left = x : bottom-right
					bottom-left = o : bottom-right (1)
					bottom-left = b : bottom-left (1)
			middle-left = o : bottom-left (3)
			middle-left = b : middle-left (2)
		top-right = o (16)
			bottom-middle = x : top-middle (6)
			bottom-middle = o (5)
				middle-right = x : middle-left (1)
				middle-right = o (3)
					top-middle = x : bottom-right (1)
					top-middle = o : top-middle
					top-middle = b : top-middle (2)
				middle-right = b : middle-right (1)
			bottom-middle = b (5)
				extra = Win : bottom-middle (4)
				extra = Block : top-middle (1)
		top-right = b (9)
			top-middle = x (2)
				middle-left = x : bottom-middle (1)
				middle-left = o : top-right
				middle-left = b : top-right (1)
			top-middle = o : top-right (6)
			top-middle = b : top-middle (1)
	top-left = b (23)
		bottom-right = x : top-left (9)
		bottom-right = o (9)
			bottom-left = x : middle-left (1)
			bottom-left = o (5)
				middle-left = x (2)
					top-right = x : bottom-middle (1)
					top-right = o : middle-right (1)
					top-right = b : bottom-middle
				middle-left = o : top-left (2)
				middle-left = b : top-left (1)
			bottom-left = b (3)
				top-right = x : bottom-left (2)
				top-right = o : top-left (1)
				top-right = b : bottom-left
		bottom-right = b (5)
			middle-left = x : top-left (1)
			middle-left = o (4)
				bottom-left = x : bottom-right (1)
				bottom-left = o (3)
					top-middle = x : top-left (1)
					top-middle = o (2)
						top-right = x : bottom-right (1)
						top-right = o : top-left (1)
						top-right = b : bottom-right
					top-middle = b : top-left
				bottom-left = b : bottom-right
			middle-left = b : top-left
middle-middle = o (75)
	top-right = x (26)
		top-left = x (6)
			top-middle = x : top-middle
			top-middle = o (3)
				middle-left = x : bottom-middle (1)
				middle-left = o : middle-left
				middle-left = b : middle-left (2)
			top-middle = b : top-middle (3)
		top-left = o (11)
			middle-right = x : bottom-right (4)
			middle-right = o (5)
				top-middle = x : middle-left (3)
				top-middle = o (2)
					middle-left = x : bottom-middle (1)
					middle-left = o : bottom-middle
					middle-left = b : bottom-left (1)
				top-middle = b : middle-left
			middle-right = b : middle-right (2)
		top-left = b (9)
			top-middle = x : top-left (6)
			top-middle = o (2)
				middle-left = x : bottom-right
				middle-left = o : bottom-right (1)
				middle-left = b : middle-left (1)
			top-middle = b : top-left (1)
	top-right = o (29)
		top-left = x (13)
			top-middle = x (5)
				middle-left = x : bottom-left (2)
				middle-left = o : middle-right (2)
				middle-left = b : bottom-left (1)
			top-middle = o (5)
				bottom-left = x (2)
					middle-left = x : bottom-middle
					middle-left = o : bottom-middle (1)
					middle-left = b : middle-left (1)
				bottom-left = o : bottom-left
				bottom-left = b : bottom-left (3)
			top-middle = b (3)
				bottom-middle = x : middle-right (1)
				bottom-middle = o : top-middle (2)
				bottom-middle = b : top-middle
		top-left = o (7)
			middle-right = x : bottom-left (1)
			middle-right = o : bottom-left (3)
			middle-right = b (3)
				top-middle = x : bottom-right (2)
				top-middle = o : bottom-right
				top-middle = b : top-middle (1)
		top-left = b (9)
			bottom-right = x (2)
				middle-left = x : top-left (1)
				middle-left = o : bottom-left (1)
				middle-left = b : bottom-left
			bottom-right = o : top-left (6)
			bottom-right = b : bottom-right (1)
	top-right = b (20)
		top-left = x (12)
			top-middle = x : top-right (5)
			top-middle = o (5)
				middle-right = x : bottom-middle (1)
				middle-right = o : top-right (2)
				middle-right = b : top-right (2)
			top-middle = b (2)
				middle-left = x : top-middle (1)
				middle-left = o : top-right (1)
				middle-left = b : top-right
		top-left = o : top-right (5)
		top-left = b (3)
			middle-left = x : top-left (2)
			middle-left = o : top-right (1)
			middle-left = b : top-left
middle-middle = b (55)
	top-right = x (23)
		middle-left = x (5)
			bottom-right = x (2)
				top-middle = x : middle-right
				top-middle = o : middle-right (1)
				top-middle = b : top-middle (1)
			bottom-right = o : center (2)
			bottom-right = b : center (1)
		middle-left = o : center (11)
		middle-left = b (7)
			extra = Win : center (5)
			extra = Block : middle-left (2)
	top-right = o (24)
		top-left = x : center (11)
		top-left = o (8)
			bottom-right = x : middle-left (1)
			bottom-right = o : center (6)
			bottom-right = b : center (1)
		top-left = b (5)
			extra = Win (2)
				bottom-left = x : top-left (1)
				bottom-left = o : center (1)
				bottom-left = b : center
			extra = Block : top-left (3)
	top-right = b (8)
		bottom-right = x : top-right (4)
		bottom-right = o (4)
			middle-right = x : center (1)
			middle-right = o (3)
				bottom-left = x : top-right (2)
				bottom-left = o : center (1)
				bottom-left = b : top-right
			middle-right = b : top-right
		bottom-right = b : top-right

Accuracy of decision tree on the training set : 100.0
Accuracy of decision tree on the test set : 62.0

