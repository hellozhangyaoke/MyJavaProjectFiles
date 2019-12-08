import java.util.Random;
import java.util.Scanner;

//随机生成一个7以内的数字
class ComBo{

	
	int GetFangwei() {
		Random weizhi = new Random();
		int number = weizhi.nextInt(7);
		
		return number;
	}
}

//用户输入类，接收用户输入数字
//方法传参易确定是猜数字还是重玩判定
class GuessF{
	private int gfangwei;
	
	int GetFangwei(int howtodo) {
		Scanner a = new Scanner(System.in);
		if (howtodo == 1) {
			System.out.print("请输入你要攻击的目标>>>");
		}else {
			System.out.print("要再来一局吗？(0->不玩了；1->继续)");
		}
		
		gfangwei = a.nextInt();
		return gfangwei;
	}
	
}

//游戏开始类，主要是判定用户输入是否为对应数字
class Gameon{
	private boolean bingo = false;
	ComBo k = new ComBo();
	int boal = k.GetFangwei();
	
	boolean gameStart(int gboal){

		if (gboal == boal) {
			
			System.out.println("击中啦！！");

		
			return bingo = true;
//				break;
		}else {
			System.out.println("你没击中，请重试>>>");
			return bingo = false;

			
		}
	}
	
	
}


//主类，主方法
public class GuessNumberGame{
	public static void main(String []args) {
		GuessF l = new GuessF();
		int gboal = l.GetFangwei(1);
		Gameon startg = new Gameon();
		boolean isbingo;
		isbingo = startg.gameStart(gboal);
		while (true) {
			
			
			//判断是否猜中数字
			if (isbingo) {
				
				gboal = l.GetFangwei(0);
				
				//弹出是否继续，如果输入的不是1，则退出
				if (gboal == 0) {
					System.out.println("再见！");
					break;
				}else if(gboal == 1) {
					
					//重新初始化随机数字
					startg = null;
					startg = new Gameon();
					gboal = l.GetFangwei(1);
					isbingo = startg.gameStart(gboal);
					
				}else {
					System.out.println("输入有误，再见!>>>>>");
					break;
				}
			}else {
				
				gboal = l.GetFangwei(1);
				isbingo = startg.gameStart(gboal);
			}
			
		}
		
	}
}