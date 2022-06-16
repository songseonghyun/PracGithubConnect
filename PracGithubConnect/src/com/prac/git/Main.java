package com.prac.git;

import java.util.Stack;

//Programmers
public class Main {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
	}
	
	//Å©·¹ÀÎ ÀÎÇü »Ì±â
	private static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> basket = new Stack<Integer>();
		
		for (int item : moves) {
			for (int i=0; i<board.length; i++) {
				if (board[i][item-1] != 0) {
					if (basket.isEmpty()) {
						basket.push(board[i][item-1]);
						board[i][item-1] = 0;
						System.out.println(basket.peek());
						break;
					}
					
					if (basket.peek() == board[i][item-1]) {
						basket.pop();
						answer += 2;
						board[i][item-1] = 0;
					} else {
						basket.push(board[i][item-1]);
						board[i][item-1] = 0;
					}
					break;
				}
			}
		}
		
		
		return answer;
	}
}
//To test breakdown
