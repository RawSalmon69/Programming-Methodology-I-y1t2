package logic;

import gui.ControlPane;
import gui.TimerPane;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameLogic {

	private static GameLogic instance = null;

    public boolean isGameStart() {
		return gameStart;
	}

	public static void setGameStart(boolean gameStart) {
		GameLogic.gameStart = gameStart;
	}

	private static boolean gameStart=false;

    private static Timer[] playerTimer= new Timer[] {new Timer(1, 0, 0), new Timer(1, 0, 0)};

    private static TimerPane[] timerPane;

    private static boolean isGameEnd;
	private static boolean isOTurn;
	private static ControlPane controlPane;
	private final int[][] board = new int[3][3];
	private final int[] score =new int[3];
	private int count=0;

	private GameLogic() {
		playerTimer = new Timer[] {new Timer(5, 0, 0), new Timer(5, 0, 0)};
        timerPane = new TimerPane[2];
		this.newGame();
	}



	public void beginTurns(int pl) throws InterruptedException {
		startCountDownTimer(pl);
	}
	public  void startCountDownTimer(int pl){
		Thread t = new Thread(() -> {
			try {
				runCountDownTimer(pl);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		t.start();
	}
	public void runCountDownTimer(int pl) throws InterruptedException {
		Timer plTimer = playerTimer[pl];
		plTimer.setStop(false);
		if(pl==0) {
			while (gameStart&&isOTurn && !plTimer.isTimerEmpty()) {
				Thread.sleep(20);
					/*
			 * FIX CODE: There is JavaFX commands inside the code below
				Add something to the code below to make JavaFX commands can
				function in the thread
			 */
				Platform.runLater(() -> timerPane[pl].setTimer(plTimer));

				plTimer.decrementTimer(2);
			}
		}
		else {
			while (gameStart&&!isOTurn&&!plTimer.isTimerEmpty()) {
				Thread.sleep(20);
				/*
				 *	/*
			 * FIX CODE: There is JavaFX commands inside the code below
				Add something to the code below to make JavaFX commands can
				function in the thread
				 */
				Platform.runLater(() -> timerPane[pl].setTimer(plTimer));

				plTimer.decrementTimer(2);
			}
		}
		plTimer.setStop(true);

		if(plTimer.isTimerEmpty()) {
			if(isOTurn)controlPane.updateGameText("X wins!");
			else controlPane.updateGameText("O wins!");
			return;
		}
	}
	private void runWinningPattern()  {
		Thread t = new Thread(() -> {
			try {
				winningPattern(score);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		t.start();
	}


	private void winningPattern(int[] score) throws InterruptedException {
		for (int x : score) {
			Platform.runLater(() -> {
				if (isOTurn) {
					controlPane.getTicTacToePane().getAllCells().get(x).draw(new Image(ClassLoader.getSystemResource("o.png").toString()),Color.GREEN);
				}
				else{
					controlPane.getTicTacToePane().getAllCells().get(x).draw(new Image(ClassLoader.getSystemResource("x.png").toString()),Color.GREEN);
				}
			});

			Thread.sleep(200);
		}
	}


	public void drawNumber(int x, int y) {
		count++;
		int num = -1;
		if(isOTurn)num = 1;
		else num = 2;
		board[x][y] = num;
		checkGameEnd();
	}

	public void newGame() {
		setGameEnd(false);
		this.setOturn(true);
		gameStart=false;
		count=0;
		playerTimer = new Timer[] {new Timer(1, 0, 0), new Timer(1, 0, 0)};
		timerPane = new TimerPane[2];
		timerPane[0]=new TimerPane(0);
		timerPane[1]=new TimerPane(1);
		timerPane[0].setTimer(playerTimer[0]);
		timerPane[1].setTimer(playerTimer[1]);
		startCountDownTimer(0);
		startCountDownTimer(1);
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				board[i][j] = 0;
			}

		}
	}

	public boolean isGameEnd() {
		return isGameEnd;
	}
	public static void setGameEnd(boolean gameEnd) {
		isGameEnd = gameEnd;
	}
	public boolean isOturn() {
		return isOTurn;
	}
	public void setOturn(boolean oTurn) {
		isOTurn = oTurn;
	}

	public static GameLogic getInstance() {
		if(instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	public void setControlPane(ControlPane controlPane) {
		GameLogic.controlPane = controlPane;
	}



	private void checkGameEnd()  {
		int num = -1;
		if (isOTurn) num = 1;
		else num = 2;
		boolean endgame = false;
		if (board[0][0] == num && board[0][1] == num && board[0][2] == num) {
			score[0] = 0;
			score[1] = 1;
			score[2] = 2;
			endgame = true;
		} else if (board[1][0] == num && board[1][1] == num && board[1][2] == num) {
			score[0] = 3;
			score[1] = 4;
			score[2] = 5;
			endgame = true;
		} else if (board[2][0] == num && board[2][1] == num && board[2][2] == num) {
			score[0] = 6;
			score[1] = 7;
			score[2] = 8;
			endgame = true;
		} else if (board[0][0] == num && board[1][0] == num && board[2][0] == num) {
			score[0] = 0;
			score[1] = 3;
			score[2] = 6;
			endgame = true;
		} else if (board[0][1] == num && board[1][1] == num && board[2][1] == num) {
			score[0] = 1;
			score[1] = 4;
			score[2] = 7;
			endgame = true;
		} else if (board[0][2] == num && board[1][2] == num && board[2][2] == num) {
			score[0] = 2;
			score[1] = 5;
			score[2] = 8;
			endgame = true;
		} else if (board[0][0] == num && board[1][1] == num && board[2][2] == num) {
			score[0] = 0;
			score[1] = 4;
			score[2] = 8;
			endgame = true;
		} else if (board[2][0] == num && board[1][1] == num && board[0][2] == num) {
			score[0] = 2;
			score[1] = 4;
			score[2] = 6;
			endgame = true;
		}
		if(count==9){
			setGameEnd(true);
			gameStart = false;
		}

		if (endgame) {

			if(isOTurn)controlPane.updateGameText("O wins!");
			else controlPane.updateGameText("X wins!");


			runWinningPattern();

			setGameEnd(true);
			gameStart = false;
		}
		else if(isGameEnd) {
			if(isOTurn&&count!=9)controlPane.updateGameText("O wins!");
			else controlPane.updateGameText("X wins!");
		}
		else {
			setOturn(!isOTurn);
			if (isOTurn) controlPane.updateGameText("O Turn");
			else controlPane.updateGameText("X Turn");
		}
	}


	public static Timer getPlayerTimer(int pl) {
		return playerTimer[pl];
	}

	public static void setTimerPane(int pl, TimerPane timerPane) {
		GameLogic.timerPane[pl] = timerPane;
	}


}

