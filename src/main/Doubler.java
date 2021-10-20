package main;

public class Doubler
{   
    public Doubler()
    {
        
    }
    
    public static String extend(String path)
    {
        String file = Utils.loadFileAsString(path);
        String copyTotal = "";
        String copyLine = "";
        String[] tokens = file.split("\\s+");
        //Read stuff and apply vars as needed.
        int width = Utils.parseInt(tokens[0]);
        int height = Utils.parseInt(tokens[1]);
        int r = Utils.parseInt(tokens[2]);
        int b = Utils.parseInt(tokens[3]);
        int g = Utils.parseInt(tokens[4]);
        int[][] tiles = new int[width][height];
        int t = Utils.parseInt(tokens[width * height + 5]);
        String[] mons = new String[t];
        
        copyTotal += String.format("%d %d \n %d %d %d \n", width * 2, 
            height * 2, r, g, b);
        
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = 
                    Utils.parseInt(tokens[(x + y * width) + 6]);
            }
        }
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                copyLine += String.format("%02d ", tiles[x][y]);
                copyLine += String.format("%02d ", tiles[x][y]);
            }
            copyLine += '\n';
            for(int x = 0; x < width; x++)
            {
                copyLine += String.format("%02d ", tiles[x][y]);
                copyLine += String.format("%02d ", tiles[x][y]);
            }
            copyLine += '\n';
        }
        copyTotal += copyLine;
               
        int numA = (width * height) + 6;
        int to = Utils.parseInt(tokens[numA]) + 1;
        copyTotal += "" + (to - 1) + "\n";
        for(int e = 1; e < to; e++)
        {
            copyTotal += "" + Utils.parseInt(tokens[numA + e]) + " ";
        }
        return copyTotal;
    }
}