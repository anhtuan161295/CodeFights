public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.areEquallyStrong(10, 15, 5, 20));
	}

	boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
		boolean result = false;

		boolean isYourTwoArmEqual = yourLeft == yourRight;
		boolean isFriendTwoArmEqual = friendsLeft == friendsRight;

		int yourStrongestArm = yourLeft > yourRight ? yourLeft : yourRight;
		int friendStrongestArm = friendsLeft > friendsRight ? friendsLeft : friendsRight;

		int yourWeakestArm = yourLeft < yourRight ? yourLeft : yourRight;
		int friendWeakestArm = friendsLeft < friendsRight ? friendsLeft : friendsRight;

		int yourTotalWeight = yourLeft + yourRight;
		int friendTotalWeight = friendsLeft + friendsRight;

		boolean isSameTotalWeight = yourTotalWeight == friendTotalWeight;
		boolean isSameStrongestAndWeakestArms = yourStrongestArm == friendStrongestArm && yourWeakestArm == friendWeakestArm;

		if (isSameTotalWeight && isSameStrongestAndWeakestArms) {
			result = true;
		}

		return result;
	}
}
