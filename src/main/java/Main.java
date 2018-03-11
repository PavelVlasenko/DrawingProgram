import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
    	Scanner scanner = new Scanner(System.in);
        System.out.println("=== START PROGRAM ===");
        
        Board board = null;
        
        while(true) {
        	System.out.print("enter command:");
        	String command = scanner.next();
        	if(command.equals("Q")) {
        		System.out.println("Quit program");
        		break;
        	}else if(command.equals("C")) {
        		int width = scanner.nextInt();
        		int height = scanner.nextInt();
        		System.out.println("Create new board width = " + width  + ", height = " + height);
        		board = new Board(width, height);
        	}else if(command.equals("L")) {
        		int x1 = scanner.nextInt();
        		int y1 = scanner.nextInt();
        		int x2 = scanner.nextInt();
        		int y2 = scanner.nextInt();
        		
        		System.out.println("Draw line (" + x1 + ", " + y1 + ")-" + "(" + x2 + ", " + y2 + ")");
        		board.line(x1, y1, x2, y2);
        	}else if(command.equals("R")) {
        		int x1 = scanner.nextInt();
        		int y1 = scanner.nextInt();
        		int x2 = scanner.nextInt();
        		int y2 = scanner.nextInt();
        		System.out.println("Draw Rectangle (" + x1 + ", " + y1 + ")-" + "(" + x2 + ", " + y2 + ")");
        		
        		board.rectangle(x1, y1, x2, y2);
        	} else if(command.equals("B")) {
        		int x = scanner.nextInt();
        		int y = scanner.nextInt();
        		char c = scanner.next().charAt(0);
        		System.out.println("Bucket fill (" + x + ", " + y + ") with color " + c);
        		board.fill(x, y, c);
        	}
        	System.out.println(board);
        }
        
        scanner.close();
        System.out.println("=== FINISH PROGRAM ===");
    }
}
