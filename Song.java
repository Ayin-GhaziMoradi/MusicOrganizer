public class Song {
    //artist's name
    private String artist;
    //stores file name (address)
    private String fileName;
    //stores the year that song was published in
    private String year;

    /**
     *
     * @param artist artist's name
     * @param fileName song name
     * @param year publish year
     */
    public Song(String artist, String fileName, String year) {
        this.artist = artist;
        this.fileName = fileName;
        this.year = year;
    }

    /**
     *
     * @return artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     *
     * @param artist set song's artist name
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     *
     * @return song name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName set this as the song name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return publish year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year set publish year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * prints full details of the song
     */
    public void printSong(){
        System.out.println(getFileName() + "  by : " + getArtist() +
                "  year : " + getYear());
    }
}
