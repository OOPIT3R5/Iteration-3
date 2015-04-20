package Model.SaveSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Model.Entity.Avatar;

public class GameLoader {
	File loadFile;
	Scanner scanner;
	Avatar avatar;
	public GameLoader(File loadFile, Avatar avatar) 
	{
		this.loadFile = loadFile;
		this.avatar = avatar;
		try {
			scanner = new Scanner(loadFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.useDelimiter(",");
		parse();
	}
	
	private void getAllItems()
	{
		System.out.println("WE ARE HERE");
		String cur;
		
	}
	
	private void parse()
	{
		while(scanner.hasNext())
		{
			/*
			String curToken = scanner.next();
			
			switch(curToken)
			{
			case "ITEMS":
				getAllItems();
			
			}*/
			String cur = scanner.next();
		
			if(cur.equalsIgnoreCase("ITEMS"))
				getAllItems();
			
		}
	}
}












