SELECT
    I.Amount AS 'Quantity', L.LocationName AS 'Location', M.cost as 'Cost'
FROM
	Album AS M
		INNER JOIN
	Inventory AS I ON M.AlbumID = I.AlbumID
		INNER JOIN
	Location AS L ON I.LocationID = L.LocationID
WHERE
	M.AlbumTitle = ?
ORDER BY I.Amount DESC;