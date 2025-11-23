// A. El fucho
// time limit per test1 second
// memory limit per test256 megabytes
// Juan and his friends are going to split themselves into 𝑛
//  teams and play a modified double-elimination football tournament, consisting of a winners' group and a losers' group. Initially, all teams belong to the winners' group.

// In each round of the tournament, the following happens as long as one of the groups has at least two teams:

// All teams in the winners' group pair up.
// If there is an odd number of teams in the winners' group, there would be a team that didn't get paired up (and wouldn't play a match). That team stays in the winners' group.
// For teams in the winners' that got paired up, each pair plays a football match in which there are no ties.
// If a team wins, it stays in the winners' group.
// If a team loses, it drops down to the losers' group in the next round.
// All teams in the losers' group pair up.
// If there is an odd number of teams in the losers' group, there would be a team that didn't get paired up (and wouldn't play a match). That team stays in the losers' group.
// For teams in the losers' that got paired up, each pair plays a football match in which there are no ties.
// If a team wins, it stays in the losers' group.
// If a team loses, it gets eliminated from the tournament.
// Note that in the above process, when a team loses a match in the winners' group, it drops down to the losers' group in the next round. That means, it is not considered for the pairing process in the current round's losers' group.

// After multiple iterations of the aforementioned process, both groups end up with a single team each. When this happens, both teams face off against each other in a match and a victor emerges.

// Determine how many matches were played in total. It can be proved that no matter how the teams are paired up and which ones win and lose, the answer remains the same.

// Input
// Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//  (1≤𝑡≤100
// ). The description of the test cases follows.

// The only line of each test case contains one positive integer 𝑛
//  (2≤𝑛≤500
// ) — the number of teams.

// Output
// For each test case, print the total number of matches played during the tournament.


package codeforces.contest;




//code is accepted, remove all above this line to make it accept on codeforces
import java.util.Scanner;

public class ElFucho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();

        for(int i = 0; i < numberOfTestCases; i++){
            int numberOfTeams = sc.nextInt();

            System.out.println(totalTournamentsPlayed(numberOfTeams));

            // can also be solved using this simple trick
            System.out.println(2 * numberOfTeams - 2);
        }

        sc.close();
    }

    public static int totalTournamentsPlayed(int teams){
        int winteams = teams;
        int losteams = 0;
        int result = 0; // total Matches Played

        while((winteams + losteams) >= 2){
            if (winteams == 1 && losteams == 1) {
                result += 1;
                break;
            }

            int matcesPlayedByWinteams = 0;

            if(winteams > 1){
                matcesPlayedByWinteams = winteams / 2;
                result += matcesPlayedByWinteams;
                winteams -= matcesPlayedByWinteams; // the losers from the winteams leave this team
            }
            

            if(losteams > 1){
                int matcesPlayedByLosteams = losteams / 2;
                result += matcesPlayedByLosteams;
                losteams -= matcesPlayedByLosteams;
            }
            
            losteams += matcesPlayedByWinteams; // the losers from the win teams will be added in this team
        }

        return result;
    }
}
