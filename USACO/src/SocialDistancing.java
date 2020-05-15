import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocialDistancing 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int[][] cows = new int[keyboard.nextInt()][2];
		
		for (int i = 0; i < cows.length; i++)
		{
			cows[i][0] = keyboard.nextInt();
			cows[i][1] = keyboard.nextInt();
		}
		
		List<Integer> healthy = new ArrayList<Integer>();
		List<Integer> sick = new ArrayList<Integer>();
		
		for (int i = 0; i < cows.length; i++)
		{
			if (cows[i][1] == 0)
				healthy.add(cows[i][0]);
			else
				sick.add(cows[i][0]);
		}
		Collections.sort(sick);

		int r = cows[cows.length-1][0];
		for (int h = 0; h < healthy.size(); h++)
			for (int s = 0; s < sick.size(); s++)
				if (Math.abs(healthy.get(h) - sick.get(s)) < r)
					r = Math.abs(healthy.get(h) - sick.get(s));
		r--;
		
		int min = 1;
		for (int i = 0; i < sick.size()-1; i++)
			if (sick.get(i+1) - sick.get(i) > r)
				min++;
		
		System.out.println(min + "");
	}
}
