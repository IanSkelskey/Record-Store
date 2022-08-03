package util;

public enum QueryTypes {
    
    ARTIST_COLLABORATION("SELECT \r\n" + 
            "    * \r\n" + 
            "FROM\r\n" + 
            "    (SELECT \r\n" + 
            "        song.songTitle\r\n" + 
            "    FROM\r\n" + 
            "        song, artist, songfeaturelist\r\n" + 
            "    WHERE\r\n" + 
            "        artist.StageName = ?\r\n" + 
            "            AND artist.ArtistID = songfeaturelist.ArtistID\r\n" + 
            "            AND songfeaturelist.SongID = song.SongID) AS A\r\n" + 
            "        JOIN\r\n" + 
            "    (SELECT \r\n" + 
            "        song.songTitle\r\n" + 
            "    FROM\r\n" + 
            "        song, artist, songfeaturelist\r\n" + 
            "    WHERE\r\n" + 
            "        artist.StageName = ?\r\n" + 
            "            AND artist.ArtistID = songfeaturelist.ArtistID\r\n" + 
            "            AND songfeaturelist.SongID = song.SongID) AS B ON A.SongTitle = B.songTitle;"),
    
    ALL_EMPLOYEES_INFO("SELECT \r\n" + 
            "    employee.EmployeeID, employee.Name, location.LocationName\r\n" + 
            "FROM\r\n" + 
            "    employee,\r\n" + 
            "    location\r\n" + 
            "WHERE\r\n" + 
            "    employee.EmployeeID = location.LocationID \r\n" + 
            "ORDER BY location.LocationID;"),
    
    ALBUM_INSTOCK_EVERYWHERE("SELECT \r\n" + 
            "    inventory.Amount, location.LocationName\r\n" + 
            "FROM\r\n" + 
            "    album,\r\n" + 
            "    inventory,\r\n" + 
            "    location\r\n" + 
            "WHERE\r\n" + 
            "    album.AlbumTitle = ?\r\n" + 
            "        AND album.AlbumID = inventory.AlbumID\r\n" + 
            "        AND inventory.LocationID = location.LocationID\r\n" + 
            "ORDER BY inventory.amount DESC;"),
    
    ARTIST_ALBUMS("SELECT -- Find all albums by a particular artist.\r\n" + 
            "    albumtitle, stagename\r\n" + 
            "FROM\r\n" + 
            "    album\r\n" + 
            "        INNER JOIN\r\n" + 
            "    song ON song.albumid = album.albumid\r\n" + 
            "        INNER JOIN\r\n" + 
            "    songfeaturelist ON songfeaturelist.SongID = song.songid\r\n" + 
            "        INNER JOIN\r\n" + 
            "    artist ON artist.artistid = songfeaturelist.artistid\r\n" + 
            "WHERE\r\n" + 
            "    StageName = ?\r\n" + 
            "GROUP BY albumtitle;");
    
    public final String query;
    
    private QueryTypes(String label) {
        this.query = label;
    }
}
