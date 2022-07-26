-- Lyrics
UPDATE SONG -- Album: In My Room by Jacob Collier
SET
    Lyrics = CASE songID
        WHEN
            1
        THEN
            'Woke up today my mind a whirl
			   From head to toe with endless feeling
			   Try to explain just what I see
			   You say to me I must be dreaming
			   You called my name the way
			   I wished you would in my imagination
			   Now every single thing around me
			   Filling me with this sensation

			   In my searching around
			   I\'ve seen so many faces
			   Now I\'ve found the one I needed
			   And the sun is rising

			   I woke up today
			   Like I wanted
			   Since you walked my way
			   I found my strength to feel it
			   I woke up today
			   Heaven knows it
			   Found a girl who makes me see

			   Ahh

			   Spoke up today about the things in my life
			   I didn\'t think I needed
			   They flew outside my window pane
			   Now pain is not to be kept a secret
			   (No more, baby, yeah)
			   These walls are built for no exceptions
			   To the things I\'ve treasured dearly
			   And now the dust has cleared away
			   But baby, I see you don\'t need me

			   In this crazy old world
			   I\'ve been so many places
			   See now, I\'m gonna need some shelter
			   When the sun is sinking

			   I woke up today
			   Like I wanted
			   Since you walked my way
			   I found my strength to feel it
			   I woke up today
			   Heaven knows it
			   Found a girl who makes me see

			   I woke up today
			   Like I wanted
			   Since you walked my way
			   I found my, found my strength to feel it
			   I woke up today
			   Like I wanted
			   Since you walked my way
			   I found my, found my strength to feel it
			   I woke up today
			   Like I wanted
			   Since you walked my way
			   I found my, found my strength to feel it

			   I woke up today
			   Like I wanted to
			   Since you walked my way
			   Woke up today just like I wanted to
			   Found my strength to feel it, oh'
        WHEN
            2
        THEN
            'There\'s a world where I can go to tell my secrets to
			   In my room, in my room
			   In my room, in my room

			   In this world I lock out all my worries and my fears
			   In my room, in my room
			   In my room, in my room

			   Do my dreaming and my scheming, lie awake and pray
			   Do my crying and my sighing, laugh at yesterday

			   Now it\'s dark and I\'m alone but I won\'t be afraid
			   In my room, in my room
			   In my room, in my room

			   Do my dreaming and my scheming, lie awake and pray
			   I do my crying and I do my sighing, laugh at yesterday

			   Now it\'s dark and I\'m alone but I won\'t be afraid
			   In my room, in my room (yeah)
			   In my room, in my room

			   In my room, in my room
			   In my room, in my room
			   In my room, in my room
			   In my room, in my room'
    END
WHERE
    songID BETWEEN 1 AND 11;