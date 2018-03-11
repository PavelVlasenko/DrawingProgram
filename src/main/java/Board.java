
public class Board {
	private int width;
	private int height;
	private char board[][] = null; 
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		board = new char[height + 2][width + 2];
		for(int x = 0; x < width + 2; x++)
			board[0][x] = board[height + 1][x] = '-';
		for(int y = 1; y <= height; y++)
			board[y][0] = board[y][width + 1] = '|';
	}
	
	public void line(int x1, int y1, int x2, int y2) {
		
		if(x1 == x2) {
			if(y1 > y2) {
				int tmp = y1;
				y1 = y2;
				y2 = tmp;
			}
			for(int y = y1; y <= y2; y++) {
				setBoard(x1, y, 'x');
			}
		} else if(y1 == y2) {
			if(x1 > x2) {
				int tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			for(int x = x1; x <= x2; x++) {
				setBoard(x, y1, 'x');
			}
		}
	}
	
	public void rectangle(int x1, int y1, int x2, int y2) {
		line(x1, y1, x1, y2);
		line(x1, y2, x2, y2);
		line(x2, y2, x2, y1);
		line(x2, y1, x1, y1);
	}
	
	public void fill(int x, int y, char c) {
		if(valid(x, y) == false || board[y][x] == c)
			return;
		char current = board[y][x];
		setBoard(x, y, c);
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(valid(nextX, nextY) == true && board[nextY][nextX] == current)
				fill(nextX, nextY, c);
		}
	}
	
	
	private void setBoard(int x, int y, char c) {
		if(valid(x, y))
			board[y][x] = c;
	}
	
	private boolean valid(int x, int y) {
		return x >= 1 && x <= width && y >= 1 && y <= height;
	}
	
    @Override
    public String toString() {
    	String ret = "";
    	for(int x = 0; x < height + 2; x++) {
    		for(int y = 0; y < width + 2; y++)
				if (board[x][y] == '\u0000') {
					ret += " ";
				} else {
					ret += board[x][y];
				}
    		ret += "\n";
    	}
    	return ret;
    }
}
