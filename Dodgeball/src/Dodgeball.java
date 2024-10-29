// Version: 20200917
// Handin done by:
//   <AU775201> <Noah André Ellegaard Østfeldt>
//   <AU780831> <William Weilby Guss>
//   <AU763658> <Torben Bach Svendsen>
// Contributions:
//   <AU775201> <Noah André Ellegaard Østfeldt> - Writer ❤️
//   <AU780831> <William Weilby Guss> - Emotional support ❤️
//   <AU763658> <Torben Bach Svendsen> Emotional support ❤️

import java.io.*;
import java.util.*;
public class Dodgeball {
     private ArrayList<Integer> players;
    // Add any private fields you might need here
    public Dodgeball() {
        players = new ArrayList<>();
    }
    public void addPlayer(int x) {
        if(players.contains(x)) {
            System.out.println("You can't add a player to " + x + " - Please add to another line that isn't " + players);
        }else{
            players.add(x);
            Collections.sort(players);
            System.out.println("Player added: " + players);}
    }

    public int throwBall(int x) {
        if(players.contains(x)) {
            players.remove((Integer) x); // Remove player at position x
            System.out.println("A player was standing on " + x + " - They died. New list: " + players);
            return 0;
        }else{
            int closestIndex = findClosest(x);
                if(closestIndex != -1) {
                    int closestDistance = players.get(closestIndex);
                    players.remove(closestIndex);
                    players.add(x);
                    System.out.println("No Player at " + x + " Closest player at " + closestDistance + " moved to " + x);
                    System.out.println("Current players: " + players);
                    return Math.abs(closestDistance - x);
                }
            System.out.println("No players on line");
            System.out.println(players);
            return -1;
        }
    }

    public int findClosest(int x){
        int closestIndex = -1;
        int closeestDistance = Integer.MAX_VALUE;

        for(int i= 0 ; i< players.size(); i++){
            int distance = Math.abs(x - players.get(i));
            if(distance < closeestDistance){
                closestIndex = i;
                closeestDistance = distance;
            }
        }
        return closestIndex;
    }
}