package Assignments.Hackathon;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Oct-2018
 *
 */

public class Cheese {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		char[][] maze = new char[n][m];

		for (int i = 0; i < n; i++) {

			String str = scn.next();
			for (int j = 0; j < m; j++) {
				maze[i][j] = str.charAt(j);
			}
		}

		boolean[][] visit = new boolean[n][m];

		blockedMaze(maze, 0, 0, "", visit);

		if (visit[visit.length - 1][visit[0].length - 1] == false) {
			System.out.println("NO PATH FOUND");
		}

	}

	public static void blockedMaze(char[][] maze, int cr, int cc, String ans, boolean[][] visited) {

		if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			// System.out.println(ans);
			visited[cr][cc] = true;
			printAns(visited);
			return;
		}

		if (cr == maze.length || cc == maze[0].length || cr < 0 || cc < 0 || maze[cr][cc] == 'X' || visited[cr][cc]) {
			return;
		}

		visited[cr][cc] = true;

		// dtlr
		blockedMaze(maze, cr + 1, cc, ans + "D", visited);
		blockedMaze(maze, cr - 1, cc, ans + "T", visited);
		blockedMaze(maze, cr, cc - 1, ans + "L", visited);
		blockedMaze(maze, cr, cc + 1, ans + "R", visited);

		visited[cr][cc] = false;

	}

	private static void printAns(boolean[][] visited) {

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {

				if (visited[i][j]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}

			System.out.println();
		}
	}

}
