import java.util.Scanner;

public class Main {

    public static class Song {
        private String title;
        private String artist;

        public Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String toString() {
            return title + " by " + artist;
        }
    }

    public static void main(String[] args) {
        CircularQueueSong playlist = new CircularQueueSong(5);
        Scanner sc = new Scanner(System.in);

        String quit = "QUIT";
        String skip = "SKIP";
        String shuffle = "SHUFFLE";
        String remove = "REMOVE";
        String back = "BACK";
        String clear = "CLEAR";

        System.out.println("Create your song playlist!");
        System.out.println("What is the name of the song? ('QUIT' to stop adding songs): ");

        for (int i = 0; i < 5; i++) {

            String name = sc.nextLine();
            if (name.equals(quit))
                break;

            System.out.println("Who is the artist?: ");
            String artist = sc.nextLine();

            playlist.enqueue(new Song(name, artist));

            System.out.println("What is the name of the next song? ('QUIT' to stop adding songs): ");
        }

        playlist.display();

        System.out.println("\nPlaylist Controls: 'SKIP', 'BACK', 'SHUFFLE', 'REMOVE', 'CLEAR'");
        System.out.println("\nNow Playing: ");
        System.out.println(playlist.peek());

        while (true) {
            String input = sc.nextLine();

            if (input.equals(quit)) break;

            if (input.equals(skip)) {
                playlist.next();
                System.out.println("\nSkipping to next song...");
                System.out.println("Now Playing:");
                System.out.println(playlist.peek());
            }

            else if (input.equals(back)) {
                playlist.back();
                System.out.println("\nGoing back to previous song...");
                System.out.println("Now Playing:");
                System.out.println(playlist.peek());
            }

            else if (input.equals(remove)) {
                System.out.println("\nRemoving current song...");
                playlist.dequeue();
                System.out.println("Now Playing:");
                System.out.println(playlist.peek());
            }

            else if (input.equals(shuffle)) {
                playlist.shuffle();
                System.out.println("\nShuffled playlist:");
                playlist.display();
                System.out.println("\nNow Playing:");
                System.out.println(playlist.peek());
            }

            else if (input.equals(clear)) {
                playlist.clear();
                System.out.println("\nPlaylist cleared.");
                playlist.display();
            }

            else {
                System.out.println("Invalid command.");
            }
        }

        sc.close(); // Reconstruido: el final de main no aparece en las diapositivas
    }
}
