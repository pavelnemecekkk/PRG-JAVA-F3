package Reference;

class CountDown {
    int x;

    public static void main(String[] args) {
        CountDown mc1 = new CountDown();
		CountDown mc2 = new CountDown();
		CountDown mc3 = new CountDown();
		mc1.x = 1;
		mc2.x = 2;
		CountDown t = mc1;
		mc1.x += 3;
		mc2.x += 4;
		mc3.x += t.x;
		mc1.x += mc3.x;
 		mc2 = mc1;
		mc1.x += 6;
		mc3 = mc1;
		mc2.x += 7;
		mc3.x += 8;
		System.out.println(mc1.x);
		System.out.println(mc2.x);
		System.out.println(mc3.x);
    }
}