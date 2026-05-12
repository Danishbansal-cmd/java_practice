package system_design.music_streaming_4;

import java.util.*;

// ==========================================================
// MUSIC STREAMING SERVICE (SOLID + DESIGN PATTERNS)
// ==========================================================

// =======================
// MODEL CLASSES
// =======================

class User {
    private String userId;
    private String name;
    private String email;
    private List<Artist> followedArtists = new ArrayList<>();

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public void followArtist(Artist artist) {
        followedArtists.add(artist);
        artist.addFollower(this);
    }

    public String getName() {
        return name;
    }

    public List<Artist> getFollowedArtists() {
        return followedArtists;
    }
}

class Artist {
    private String artistId;
    private String name;
    private String genre;
    private List<User> followers = new ArrayList<>();

    public Artist(String artistId, String name, String genre) {
        this.artistId = artistId;
        this.name = name;
        this.genre = genre;
    }

    public void addFollower(User user) {
        if (!followers.contains(user)) {
            followers.add(user);
            notifyFollowers("New content from " + name);
        }
    }

    private void notifyFollowers(String message) {
        for (User user : followers) {
            System.out.println("Notification to " + user.getName() + ": " + message);
        }
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}

class Song {
    private String songId;
    private String title;
    private Artist artist;
    private String genre;
    private int duration;
    private int playCount;

    public Song(String songId, String title, Artist artist, String genre, int duration) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.playCount = 0;
    }

    public void incrementPlayCount() {
        playCount++;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }
}

class Playlist {
    private String playlistId;
    private String name;
    private User createdBy;
    private List<Song> songs = new ArrayList<>();

    public Playlist(String playlistId, String name, User createdBy) {
        this.playlistId = playlistId;
        this.name = name;
        this.createdBy = createdBy;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void printSongs() {
        System.out.println("Playlist: " + name);
        for (Song s : songs) {
            System.out.println(" - " + s.getTitle());
        }
    }
}

// =======================
// SINGLETON (MusicPlayer)
// =======================
class MusicPlayer {
    private static MusicPlayer instance;

    private Song currentSong;
    private boolean isPlaying;
    private Queue<Song> queue = new LinkedList<>();
    private List<PlayerObserver> observers = new ArrayList<>();

    private MusicPlayer() {}

    public static synchronized MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public void play(Song song) {
        currentSong = song;
        isPlaying = true;
        song.incrementPlayCount();
        notifyObservers("Now playing: " + song.getTitle());
    }

    public void addToQueue(Song song) {
        queue.add(song);
        notifyObservers("Added to queue: " + song.getTitle());
    }

    public void next() {
        if (!queue.isEmpty()) {
            play(queue.poll());
        }
    }

    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String msg) {
        for (PlayerObserver obs : observers) {
            obs.update(msg);
        }
    }
}

// =======================
// OBSERVER PATTERN
// =======================
interface PlayerObserver {
    void update(String message);
}

class UserNotificationObserver implements PlayerObserver {
    private User user;

    public UserNotificationObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + user.getName() + ": " + message);
    }
}

class LoggerObserver implements PlayerObserver {
    @Override
    public void update(String message) {
        System.out.println("[LOG] " + message);
    }
}

// =======================
// FACTORY PATTERN
// =======================
interface PlaylistFactory {
    Playlist createPlaylist(String name, User user);
}

class UserPlaylistFactory implements PlaylistFactory {
    @Override
    public Playlist createPlaylist(String name, User user) {
        return new Playlist("PL-" + UUID.randomUUID().toString().substring(0, 5), name, user);
    }
}

// =======================
// STRATEGY PATTERN
// =======================
interface RecommendationStrategy {
    List<Song> recommend(User user, List<Song> allSongs);
}

class GenreBasedStrategy implements RecommendationStrategy {
    @Override
    public List<Song> recommend(User user, List<Song> allSongs) {
        List<Song> result = new ArrayList<>();
        if (allSongs.isEmpty()) return result;

        String genre = allSongs.get(0).getGenre();

        for (Song s : allSongs) {
            if (s.getGenre().equals(genre)) {
                result.add(s);
            }
        }
        return result;
    }
}

class ArtistBasedStrategy implements RecommendationStrategy {
    @Override
    public List<Song> recommend(User user, List<Song> allSongs) {
        List<Song> result = new ArrayList<>();

        for (Artist a : user.getFollowedArtists()) {
            for (Song s : allSongs) {
                if (s.getArtist() == a) {
                    result.add(s);
                }
            }
        }
        return result;
    }
}

// =======================
// RECOMMENDATION SERVICE
// =======================
class RecommendationService {
    private RecommendationStrategy strategy;

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Song> getRecommendations(User user, List<Song> songs) {
        return strategy.recommend(user, songs);
    }
}

// =======================
// MAIN CLASS
// =======================
public class Main {
    public static void main(String[] args) {

        System.out.println("=== Music Streaming Service ===\n");

        // 1. Create user & artist
        User user = new User("U1", "Alice", "alice@mail.com");
        Artist artist = new Artist("A1", "Taylor Swift", "Pop");

        // 2. Follow artist
        user.followArtist(artist);

        // 3. Create songs
        Song s1 = new Song("S1", "Love Story", artist, "Pop", 200);
        Song s2 = new Song("S2", "Shake It Off", artist, "Pop", 210);

        List<Song> allSongs = Arrays.asList(s1, s2);

        // 4. Singleton Player
        MusicPlayer player = MusicPlayer.getInstance();

        // 5. Observer
        player.addObserver(new UserNotificationObserver(user));
        player.addObserver(new LoggerObserver());

        // 6. Play song
        player.play(s1);

        // 7. Factory: Create playlist
        PlaylistFactory factory = new UserPlaylistFactory();
        Playlist playlist = factory.createPlaylist("My Playlist", user);

        playlist.addSong(s1);
        playlist.addSong(s2);
        playlist.printSongs();

        // 8. Strategy: Recommendation
        RecommendationService rec = new RecommendationService();
        rec.setStrategy(new ArtistBasedStrategy());

        List<Song> recommended = rec.getRecommendations(user, allSongs);

        System.out.println("\nRecommendations:");
        for (Song s : recommended) {
            System.out.println(" - " + s.getTitle());
        }

        // 9. Queue performance test
        System.out.println("\nPerformance Test:");
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            player.addToQueue(s1);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
    }
}