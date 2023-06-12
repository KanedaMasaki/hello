import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 数あてゲームクラス
 */
public class kazuate {
    int answer = 77;
    boolean flag = false;

    /**
	 * コンストラクタ、変数を初期化
	 */
    public kazuate() {

    }

    public void start() {
        System.out.println("数あてゲームを始めます．");
        for (int i = 0; i < 5; i++){
            System.out.println("2桁の数を入力してください．");
            int user_answer = inputNumber();
            judge(user_answer,i);
            if(flag){
                break;
            }
        }
    }

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
            return;
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
