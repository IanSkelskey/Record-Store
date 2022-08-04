SELECT
	i.StageName AS 'Artist',
	g.StageName AS 'Band/Group'
FROM
	Artist AS i
		INNER JOIN
	MemberOf ON i.ArtistID = MemberOf.IndividualID
		INNER JOIN
	Artist AS g ON g.ArtistID = MemberOf.GroupID
WHERE
	i.ArtistName = ?;