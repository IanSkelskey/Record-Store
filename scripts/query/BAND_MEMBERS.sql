SELECT
	g.stagename AS 'Group',
    i.stagename AS 'Member'
FROM
	artist AS i
		INNER JOIN
	memberof ON i.ArtistID = memberof.IndividualID
		INNER JOIN
	artist AS g ON g.ArtistID = memberof.GroupID
WHERE
	g.StageName = ?;