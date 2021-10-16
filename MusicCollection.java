import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 *
 * @author Ayin
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Song> files;
    // A player for the music files.
    private MusicPlayer player;
    // An ArrayList that stores details of the user's favorite songs
    private static  ArrayList<Song> favoriteList;


    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        player = new MusicPlayer();
        files = new ArrayList<Song>();
        favoriteList = new ArrayList<Song>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String artist , String filename , String year)
    {
        Song temp = new Song(artist , filename , year);
        files.add(temp);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * Return the number of favorite files.
     * @return The number of files in the favorites' list.
     */
    public int getNumberOfFavorites()
    {
        return favoriteList.size();
    }
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        files.get(index).printSong();
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(int i = 0 ; i<getNumberOfFiles() ; i++){
            files.get(i).printSong();
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        files.remove(index);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            player.startPlaying(files.get(index).getFileName());
        }


    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index >= 0 && index < files.size())
            return true;
        else {
            System.out.println("invalid input");
            return false;
        }
    }

    /**
     * check if the given name is among the favorite list
     * @param inputName the name to be checked in the list
     * @return true if it exists in the list
     */
    public boolean isInFav(String inputName){
        for(int i=0 ; i < getNumberOfFavorites() ; i++) {
            if (inputName.equals(favoriteList.get(i).getFileName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * gets a song name and adds the full details to the favorite list
     * it check if the input is valid and if the input already is in the list or not
     * @param inputName name of the song to be added to the list
     */
    public void addToFavorites(String inputName){
        Boolean addedSuccessfuly = false ;
        if(!isInFav(inputName)){
            for(int i=0 ; i < getNumberOfFiles() ; i++){
                String name = files.get(i).getFileName();
                String artist = files.get(i).getArtist();
                String year = files.get(i).getYear();
                if(inputName.equals(name)){
                    Song temp = new Song( artist , name , year);
                    favoriteList.add(temp);
                    addedSuccessfuly = true;
                    System.out.println("Successfuly added !!");
                    break;
                }
            }
            if(!addedSuccessfuly){
                System.out.println("Could not add . check your input .");
            }
        }else {
            System.out.println("Already favorite !!");
        }
    }

    /**
     * removes a song from fav list
     * if the given song name doesn't exist in the list it prints an error
     * @param inputName name of the song that we want to remove from fav list
     */
    public void removeFromFav(String inputName){
        if(isInFav(inputName)){
           Iterator <Song> it = favoriteList.iterator();
           while (it.hasNext()){
               String temp = it.next().getFileName();
               if(temp.equals(inputName))
                   it.remove();
           }
        }else {
            System.out.println("Your input is not amongst your favorites !!");
        }
    }

    /**
     * prints the favorite list's songs with full details
     */
    public void printFavList(){
        for(int i = 0 ; i<getNumberOfFavorites() ; i++){
            favoriteList.get(i).printSong();
        }
    }

    /**
     * searches for songs with song name and/or artist name that contains the input
     * and prints if a record matches the input
     * @param inputName key word to be searched
     */
    public void searcher(String inputName){
        boolean foundSth = false;
        System.out.println("search result for keyword " + inputName + " :");
        for(int i = 0 ; i<getNumberOfFiles() ; i++){
            String name = files.get(i).getFileName();
            String artist = files.get(i).getArtist();
            if(name.contains(inputName) || artist.contains(inputName)) {
                files.get(i).printSong();
                foundSth = true;
            }
        }
        if(!foundSth){
            System.out.println("No record matches your input !!");
        }
    }
}