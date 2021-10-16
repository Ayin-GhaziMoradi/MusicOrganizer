public class Main {
    /**
     * main function
     * @param args not used
     */
    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();


        pop.addFile("pop artist one" , "pop song one" , "2001");
        pop.addFile("pop artist two" , "pop song two" , "2002");
        pop.addFile("pop artist three" , "pop song three" , "2003");
        pop.addFile("pop artist four" , "pop song four" , "2004");

        jazz.addFile("jazz artist one" , "jazz song one" , "2001");
        jazz.addFile("jazz artist two" , "jazz song two" , "2002");
        jazz.addFile("jazz artist three" , "jazz song three" , "2003");

        rock.addFile("rock artist one" , "rock song one" , "2001");

        country.addFile("country artist one" , "country song one" , "2001");

        pop.listAllFiles();
        pop.removeFile(3);
        pop.listAllFiles();
        pop.addToFavorites("pop song seven");
        pop.addToFavorites("pop song one");
        pop.addToFavorites("pop song two");
        pop.printFavList();
        pop.addToFavorites("pop song two");
        pop.addToFavorites("pop song three");
        pop.removeFromFav("pop song two");
        jazz.addToFavorites("jazz song two");
        rock.addToFavorites("rock song one");
        rock.printFavList();
        pop.searcher("one");
        pop.searcher("pop artist");
        pop.searcher("jazz");
    }
}
