package util;

public enum Query {
    
    ARTIST_COLLABORATION(
            1,
            "scripts/query/ARTIST_COLLABORATION.sql",
            "artist",
            "Search for all songs that two given artists collaborated on."),
    BAND_MEMBERS(
            2,
            "scripts/query/BAND_MEMBERS.sql",
            "band",
            "Search for all members of a particular band."),
    SONG_ARTISTS(
            3,
            "scripts/query/SONG_ARTISTS.sql",
            "song",
            "Get all artists that collaborated on a given song."),
    ALBUM_SONG_TITLE(
            4,
            "scripts/query/ALBUM_SONG_TITLE.sql",
            "song",
            "Search for an album by a song title."),
    SONG_LYRICS(
            5,
            "scripts/query/SONG_LYRICS.sql",
            "lyrics",
            "Search for all songs containing given lyrics."),
    EMPLOYEES_INFO(
            6,
            "scripts/query/EMPLOYEES_INFO.sql",
            "none",
            "Get the information for all employees."),
    ALBUM_INSTOCK_EVERYWHERE(
            7,
            "scripts/query/ALBUM_INSTOCK_EVERYWHERE.sql",
            "album",
            "See the stock quantities for a particular album at all locations."),
    ARTIST_ALBUMS(
            8,
            "scripts/query/ARTIST_ALBUMS.sql",
            "artist",
            "Search for all albums by a particular artist."),
    LOCATIONS_INFO(
            9,
            "scripts/query/LOCATIONS_INFO.sql",
            "none",
            "Get the information for all locations."),
    ALBUMS_IN_RANGE(
            10,
            "scripts/query/ALBUMS_IN_RANGE.sql",
            "date",
            "Search for all albums released in a range of dates."),
    BAND_OF_ARTIST(
            11,
            "scripts/query/BAND_OF_ARTIST.sql",
            "artist",
            "Find out what band a particular artist is a member of."),
    ALBUMS_OF_GENRE(
            12,
            "scripts/query/ALBUMS_OF_GENRE.sql",
            "genre",
            "Search for all albums of a particular genre.");

    public final int id;
    public final String path;
    public final String query;
    public final int paramCount;
    public final String paramType;
    public final String menuDescription;

    Query(int id, String path, String paramType, String menuDescription) {
        this.id = id;
        this.path = path;
        this.query = SQLHelper.convertScriptToString(this.path);
        this.paramCount = SQLHelper.countScriptParameters(this.query);
        this.paramType = paramType;
        this.menuDescription = menuDescription;
    }

    public static Query getQueryByID(int id) {
        for (Query qt : values()) {
            if (qt.id == id) {
                return qt;
            }
        }
        throw new IllegalArgumentException(String.valueOf(id));
    }

}
