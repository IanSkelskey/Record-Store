package util;

public enum Query {

    EMPLOYEES_INFO(
            "EMPLOYEES_INFO.sql",
            "none",
            "Get the information for all employees."),
    LOCATIONS_INFO(
            "LOCATIONS_INFO.sql",
            "none",
            "Get the information for all locations."),
    ALBUMS_INFO(
            "ALBUMS_INFO.sql",
            "none",
            "Get information for all albums in the system."),
    SONGS_INFO(
            "SONGS_INFO.sql",
            "none",
            "Get information for all songs in the system."),
    ARTISTS_INFO(
            "ARTISTS_INFO.sql",
            "none",
            "Get information for all artists in the system."),
    ARTIST_COLLABORATION(
            "ARTIST_COLLABORATION.sql",
            "artist",
            "Search for all songs that two given artists collaborated on."),
    BAND_MEMBERS(
            "BAND_MEMBERS.sql",
            "band",
            "Search for all members of a particular band."),
    BAND_OF_ARTIST(
            "BAND_OF_ARTIST.sql",
            "artist",
            "Find out what band a particular artist is a member of."),
    SONG_ARTISTS(
            "SONG_ARTISTS.sql",
            "song",
            "Get all artists that collaborated on a given song."),
    SONG_LYRICS(
            "SONG_LYRICS.sql",
            "lyrics",
            "Search for all songs containing given lyrics."),
    ALBUM_INSTOCK_EVERYWHERE(
            "ALBUM_INSTOCK_EVERYWHERE.sql",
            "album",
            "See the stock quantities for a particular album at all locations."),
    ALBUM_SONG_TITLE(
            "ALBUM_SONG_TITLE.sql",
            "song",
            "Search for an album by a song title."),
    ARTIST_ALBUMS(
            "ARTIST_ALBUMS.sql",
            "artist",
            "Search for all albums by a particular artist."),
    ALBUMS_IN_RANGE(
            "ALBUMS_IN_RANGE.sql",
            "date",
            "Search for all albums released in a range of dates."),
    ALBUMS_OF_GENRE(
            "ALBUMS_OF_GENRE.sql",
            "genre",
            "Search for all albums of a particular genre.");

    public final int id;
    public final String query;
    public final int paramCount;
    public final String paramType;
    public final String description;

    Query(String filename, String paramType, String description) {
        this.id = Counter.count++;
        this.query = SQLHelper.convertScriptToString("src/main/resources/sql/query/" + filename);
        this.paramCount = SQLHelper.countScriptParameters(this.query);
        this.paramType = paramType;
        this.description = description;
    }

    public static Query getQueryByID(int id) {
        for (Query qt : values()) {
            if (qt.id == id) {
                return qt;
            }
        }
        throw new IllegalArgumentException(String.valueOf(id));
    }

    @Override
    public String toString() {
        return this.id + "\t- " + this.description;
    }

    private static class Counter {
        private static int count = 1;
    }

}
