package solutionForCodingChallenge;

import java.util.Scanner;

public class AeroplaneSeatReservation2 {

	int[][] seats = new int[50][10];

	public void seatCreation() {

		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {

				seats[i][j] = 1;

			}
		}

	}

	public void printSeat() {
		
		for (int i = 0; i < seats.length; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < seats[i].length; j++) {

				System.out.print(seats[i][j] + " ");

			}
			System.out.println();

		}
	}
/**********checking the values for initial before the reserved string checker *************//*
	public void familyCheckerInitial() {
		int sum = 0;
		int count = 0;
		*//********* first 3 cols *********//*
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length - 7; j++) {

				sum = sum + seats[i][j];

			}
			System.out.println("sum of first 3 colmuns is : " + sum);
			sum = 0;
		}

		*//************ next 4 cols **********//*
		for (int i = 0; i < seats.length; i++) {
			for (int j = seats[i].length - 7; j < seats[i].length - 3; j++) {

				sum = sum + seats[i][j];

			}
			System.out.println("sum of next 4 columns is : " + sum);
			sum = 0;
		}

		*//************ last 3 columns ************//*

		for (int i = 0; i < seats.length; i++) {
			for (int j = seats[i].length - 3; j < seats[i].length; j++) {

				sum = sum + seats[i][j];
				count++;

			}
			System.out.println("sum of last 3 columns is : " + sum);

			sum = 0;
		}
		System.out.println("count is : " + count);

	}*/

	/************* Analyze the reserved string updates **********/
	
	public void ReserveSeats(String rSeats) {
		int temp;
		int temp1;

		String[] rSeatsArray = rSeats.split("\\s+");
		for (int k = 0; k < rSeatsArray.length; k++) {
			

			temp = (int) rSeatsArray[k].charAt(0) - 48 - 1;

			temp1 = findColumnSeat(rSeatsArray[k].charAt(1));
			seats[temp][temp1] = 0;
			

		}

		for (int i = 0; i < seats.length; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < seats[i].length; j++) {

				System.out.print(seats[i][j] + " ");

			}
			System.out.println();
		}
	}
	
/*************converting the string value that is column value A,B,C,D to 1,2,3 ********/
	
	public static int findColumnSeat(char temperoray1) {

		if (temperoray1 == 'A' || temperoray1 == 'a')
			return 0;
		if (temperoray1 == 'B' || temperoray1 == 'b')
			return 1;
		if (temperoray1 == 'C' || temperoray1 == 'c')
			return 2;
		if (temperoray1 == 'D' || temperoray1 == 'd')
			return 3;
		if (temperoray1 == 'E' || temperoray1 == 'e')
			return 4;
		if (temperoray1 == 'F' || temperoray1 == 'f')
			return 5;
		if (temperoray1 == 'G' || temperoray1 == 'g')
			return 6;
		if (temperoray1 == 'H' || temperoray1 == 'h')
			return 7;
		if (temperoray1 == 'I' || temperoray1 == 'i')
			return 8;
		if (temperoray1 == 'J' || temperoray1 == 'j')
			return 9;
		else
			return -1;

	}

/*************getting the count and of the maximum 3 family that can book tickets***********/
	
	public void familyCheckerFinal() {
		int sum = 0;
		int count1 = 0;

		/********* first 3 cols *********/
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length - 7; j++) {

				sum = sum + seats[i][j];
				if (sum >= 3) {
					count1++;
				}

			}
			System.out.println("sum of first 3 colmuns is : " + sum);
			sum = 0;
		}
		System.out.println("maximum families that can be accomodated in first 3 rows :" + count1);

		/************ next 4 cols **********/
		for (int i = 0; i < seats.length; i++) 
		{
			for (int j = seats[i].length - 7; j < seats[i].length - 3; j++) 
			{
	
				if (seats[i][4] == 0 || seats[i][5] == 0)
					break;
				else {
					sum = sum + seats[i][j];
					if (sum >= 3) {
						count1++;
					}
				}
				
			}
			System.out.println("sum of next 4 columns is : " + sum);
			sum = 0;
		}
		System.out.println("maximum families that can be accomodated in middle 4 rows : " + count1);

		/************ last 3 columns ************/

		for (int i = 0; i < seats.length; i++) {
			for (int j = seats[i].length - 3; j < seats[i].length; j++) {

				sum = sum + seats[i][j];
				if (sum >= 3) {
					count1++;
				}

			}
			System.out.println("sum of last 3 columns is : " + sum);

			sum = 0;
		}
		System.out.println("maximum families that can be accomodated in last 3 rows : " + count1);
	
		System.out.println("Maximum seats that can be booked for a 3 member family is:   " + count1);
	}

	public static void main(String[] args) {

		AeroplaneSeatReservation2 aero = new AeroplaneSeatReservation2();
		aero.seatCreation();
		aero.printSeat();
		//aero.familyCheckerInitial();
		System.out.println("enter the reserved seats string in 1A 2B 3D or 1a 2b 3c format : ");
		Scanner in = new Scanner(System.in);
		String S = in.nextLine();
		/*String S = ("1F 2E");*/
		aero.ReserveSeats(S);
		aero.familyCheckerFinal();

	}

}
