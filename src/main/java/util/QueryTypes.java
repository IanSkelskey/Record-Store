package util;

public enum QueryTypes {
    
    ARTIST_COLLABORATION("scripts/query/ARTIST_COLLABORATION.sql"),
    BAND_MEMBERS("scripts/query/BAND_MEMBERS.sql"),
    SONG_ARTISTS("scripts/query/SONG_ARTISTS.sql"),
    ALBUM_SONG_TITLE("scripts/query/ALBUM_SONG_TITLE.sql"),
    SONG_LYRICS("scripts/query/SONG_LYRICS.sql"),
    ALL_EMPLOYEES_INFO("scripts/query/ALL_EMPLOYEES_INFO.sql"),
    ALBUM_INSTOCK_EVERYWHERE("scripts/query/ALBUM_INSTOCK_EVERYWHERE.sql"),
    ARTIST_ALBUMS("scripts/query/ARTIST_ALBUMS.sql");
    
    public final String queryPath;
    
    private QueryTypes(String path) {
        this.queryPath = path;
    }
}
