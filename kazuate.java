import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数あてゲームクラス
 */
public class kazuate {
    final int GAMECOUNT = 5;
    int answer;
    boolean flag;
    int user_answer;

    /**
	 * コンストラクタ、変数を初期化
	 */
    public kazuate() {
        flag = false;
        user_answer = -1;
        answer = 77;
    }
    /**
	 * 数あてゲームを開始する
	 */
    public void start() { 
        System.out.println("数あてゲームを始めます．");
        for (int i = 0; i < GAMECOUNT; i++){
            System.out.println("2桁の数を入力してください．");
            user_answer = inputNumber();
            if(user_answer<0||user_answer>99){
                System.out.println("0から99の間で入力してください．");
                i--;
                continue;
            }
            judge(user_answer,i);
            if(flag){
                break;
            }
        }
    }
    /**
	 * ユーザの入力した数と答えを比較し，結果を表示する
	 */
    public void judge(int user_answer,int i) {
        if(user_answer == answer){
            System.out.println("正解です．");
            flag = true;
            return;
        }
        else{
            if(Math.abs(user_answer-answer) >= 20){
                System.out.println("20以上差があります．");
            }
            if(user_answer>answer){
                System.out.println("もっと小さいです．");
            }
            else{
                System.out.println("もっと大きいです．");
            }
            System.out.println("あと"+(4-i)+"回です．");
            if(4-i==0){
                System.out.println("ゲームオーバーです．");
                return;
            }
                
            }
        }

	/* メソッド：ユーザに整数を入力してもらい，返り値として返す */
	public int inputNumber() {
		int number;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			number = this.inputNumber(); // 再起呼び出し．this.は省略可能．
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = this.inputNumber(); // 再起呼び出し．this.は省略可能．
		}
		return number;
	}



	/**
	 * メイン関数
	 */
	public static void main(String[] args) {
        kazuate game = new kazuate();
        game.start();
	}
}
