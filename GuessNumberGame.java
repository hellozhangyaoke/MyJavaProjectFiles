import java.util.Random;
import java.util.Scanner;

//�������һ��7���ڵ�����
class ComBo{

	
	int GetFangwei() {
		Random weizhi = new Random();
		int number = weizhi.nextInt(7);
		
		return number;
	}
}

//�û������࣬�����û���������
//����������ȷ���ǲ����ֻ��������ж�
class GuessF{
	private int gfangwei;
	
	int GetFangwei(int howtodo) {
		Scanner a = new Scanner(System.in);
		if (howtodo == 1) {
			System.out.print("��������Ҫ������Ŀ��>>>");
		}else {
			System.out.print("Ҫ����һ����(0->�����ˣ�1->����)");
		}
		
		gfangwei = a.nextInt();
		return gfangwei;
	}
	
}

//��Ϸ��ʼ�࣬��Ҫ���ж��û������Ƿ�Ϊ��Ӧ����
class Gameon{
	private boolean bingo = false;
	ComBo k = new ComBo();
	int boal = k.GetFangwei();
	
	boolean gameStart(int gboal){

		if (gboal == boal) {
			
			System.out.println("����������");

		
			return bingo = true;
//				break;
		}else {
			System.out.println("��û���У�������>>>");
			return bingo = false;

			
		}
	}
	
	
}


//���࣬������
public class GuessNumberGame{
	public static void main(String []args) {
		GuessF l = new GuessF();
		int gboal = l.GetFangwei(1);
		Gameon startg = new Gameon();
		boolean isbingo;
		isbingo = startg.gameStart(gboal);
		while (true) {
			
			
			//�ж��Ƿ��������
			if (isbingo) {
				
				gboal = l.GetFangwei(0);
				
				//�����Ƿ�������������Ĳ���1�����˳�
				if (gboal == 0) {
					System.out.println("�ټ���");
					break;
				}else if(gboal == 1) {
					
					//���³�ʼ���������
					startg = null;
					startg = new Gameon();
					gboal = l.GetFangwei(1);
					isbingo = startg.gameStart(gboal);
					
				}else {
					System.out.println("���������ټ�!>>>>>");
					break;
				}
			}else {
				
				gboal = l.GetFangwei(1);
				isbingo = startg.gameStart(gboal);
			}
			
		}
		
	}
}