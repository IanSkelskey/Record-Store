package util;

public enum QueryTypes {
    
    ARTIST_COLLABORATION("scripts/query/ARTIST_COLLABORATION.sql"),
    BAND_MEMBERS("scripts/query/BAND_MEMBERS.sql"),
    SONG_ARTISTS("scripts/query/SONG_ARTISTS.sql"),
    ALBUM_SONG_TITLE("scripts/query/ALBUM_SONG_TITLE.sql"),
    SONG_LYRICS("scripts/query/SONG_LYRICS.sql"),
    EMPLOYEES_INFO("scripts/query/EMPLOYEES_INFO.sql"),
    ALBUM_INSTOCK_EVERYWHERE("scripts/query/ALBUM_INSTOCK_EVERYWHERE.sql"),
    ARTIST_ALBUMS("scripts/query/ARTIST_ALBUMS.sql"),
    LOCATIONS_INFO("scripts/query/LOCATIONS_INFO.sql"),
    ALBUMS_IN_RANGE("scripts/query/ALBUMS_IN_RANGE.sql"),
    BAND_OF_ARTIST("scripts/query/BAND_OF_ARTIST.sql"),
    ALBUMS_OF_GENRE("scripts/query/ALBUMS_OF_GENRE.sql");
    
    public final String queryPath;
    
    QueryTypes(String path) {
        this.queryPath = path;
    }
}
