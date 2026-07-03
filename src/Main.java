import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean frg = true;

		Member member = new Member("葉加瀬太郎");
		DVD dvd = new DVD("君の名は", 300);

		Regi regi = new Regi();

		Rental rental = new Rental(member, dvd);

		while (frg) { 		// 開店状態
			System.out.println("---メニュー画面---");

			System.out.println("１：貸出");
			System.out.println("２：返却");
			System.out.println("３：売上確認");
			System.out.println("４：ＤＶＤ一覧");
			System.out.println("０：終了"); // システムの終了

			System.out.println("番号を入力してください：");

			int menu = sc.nextInt();

			switch (menu) {

			case 1: // 貸出処理
				rental = regi.checkout(member, dvd);

				if (rental != null) {
					System.out.println("会員：" + rental.getMember().getName());
					System.out.println("DVD：" + rental.getDVD().getTitle());
					System.out.println("料金：" + rental.charge() + "円");
					System.out.println("ポイント：" + rental.getMember().getPoint());
					System.out.println("貸出日：" + rental.getRentalDate());
					System.out.println("返却予定日：" + rental.getDueDate());

					System.out.println();
				}
				break;

			case 2: // 返却処理

				if (rental == null) {
					System.out.println("貸し出されていません");

					break;
				} else {
					int lateFee = regi.returnRental(rental);
					System.out.println("返却しました");
					System.out.println("延滞料金：" + lateFee + "円");
					rental = null;

					System.out.println();
					break;
				}

			case 3: // 売上確認
				System.out.println("現在の売上の合計：" + regi.getSaletotal() + "円");
				System.out.println();
				break;

			case 0: // システム終了
				System.out.println("終了しました。");
				frg = false;
				break;

			default:
				System.out.println("番号が違います。もう一度入力してください");
				System.out.println();
			}
		}
		sc.close();
	}
}
