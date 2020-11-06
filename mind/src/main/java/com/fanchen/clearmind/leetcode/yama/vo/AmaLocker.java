package com.fanchen.clearmind.leetcode.yama.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Amazon Locker
 */
public class AmaLocker {

	public class Packagee {
		Size size;
		int lockerLocationId;
		int lockerId;

		public Size getSize() {
			return size;
		}

		public int getLockerLocationId() {
			return lockerLocationId;
		}

		public Packagee(Size size, int lockerLocationId) {
			this.size = size;
			this.lockerLocationId = lockerLocationId;
		}

	}

	public class LockerSpot {
		Size size;
		int lockerId;
		int lockerLocationId;
		LockerStatus status;
		boolean isReturn;
		Packagee pack;

		public LockerSpot(Size size) {
			this.size = size;
			status = LockerStatus.FREE;
		}

		public Size getSize() {
			return size;
		}

		public Packagee getPackagee() {
			return pack;
		}

		public boolean isReturn() {
			return isReturn;
		}

		public int getLockerId() {
			return lockerId;
		}

		public void setLockerId(int lockerId) {
			this.lockerId = lockerId;
		}
	}

	// I used your naming convention and a locker is a cllection of lockerspots.
	public class LockerStation {

		int lockerLocationId;

		Queue<LockerSpot> lockerQueue;
		List<LockerSpot> lockerSpots;

		public LockerStation(int numOfLockers, Size size) {
			lockerSpots = new ArrayList<>();
			for (int i = 0; i < numOfLockers; i++) {
				lockerSpots.add(new LockerSpot(size));
			}
			// possible use a priortyqueue and sort on something interseting
			lockerQueue = new LinkedList<>(lockerSpots);
		}

		public boolean isSpotAvailable() {
			return lockerQueue.size() > 0;
		}

		public LockerSpot getSpot() {
			return lockerQueue.poll();
		}

		public void addSpotToQueue(LockerSpot spot) {
			lockerQueue.add(spot);
		}
	}

	public class LockerManager {
		static final int MAX_SMALL = 3;
		static final int MAX_MED = 3;
		static final int MAX_LARGE = 3;
		LockerStation[] lockers;
		HashMap<Packagee, LockerSpot> boxLocationMap;

		public LockerManager() {
			lockers = new LockerStation[2];
			lockers[0] = new LockerStation(MAX_SMALL, Size.SMALL);
			lockers[1] = new LockerStation(MAX_MED, Size.MEDIUM);
			lockers[2] = new LockerStation(MAX_LARGE, Size.LARGE);

			boxLocationMap = new HashMap<>();
		}

		/**
		 * Find the next available lockerspot. Only lockerspots greater or equal to box
		 * can fit. Ex small box can fit in all three lockerspot sizes.
		 * 
		 * @param pack
		 */
		public void addBox(Packagee pack) {
			boolean isSpotFound = false;
			// this can be improved, im using small = 0, med = 1, large = 2 but with enumss
			// lol
			for (int i = pack.size.ordinal(); i <= Size.LARGE.ordinal(); i++) {
				if (lockers[i].isSpotAvailable()) {
					LockerSpot newSpot = lockers[i].getSpot();
					newSpot.pack = pack;
					newSpot.status = LockerStatus.OCCUPIED;
					pack.lockerLocationId = i;
					boxLocationMap.put(pack, newSpot);
					isSpotFound = true;
					break;
				}
			}
			if (!isSpotFound) {
				// add to some queue?
			}
		}

		public void removeBox(Packagee pack) {
			if (boxLocationMap.containsKey(pack)) {
				LockerSpot lockerSpot = boxLocationMap.get(pack);
				lockerSpot.status = LockerStatus.FREE;
				boxLocationMap.remove(pack);
				lockers[pack.lockerLocationId].addSpotToQueue(lockerSpot);
			}
		}
	}

	public enum Size {
		SMALL(5, 5, 5), MEDIUM(10, 10, 10), LARGE(20, 20, 20); // we can add more size locker here

		int length;
		int width;
		int height;

		private Size(int l, int w, int h) {
			this.length = l;
			this.width = w;
			this.height = h;
		}
	}

	public enum LockerStatus {
		FREE, OCCUPIED
	}

	public interface FitCheck {
		boolean isFit(Packagee p, LockerSpot l);
	}

	public class SizeFilter implements FitCheck {

		@Override
		public boolean isFit(Packagee p, LockerSpot l) {

			Size packageSize = p.getSize();
			Size lockerSize = l.getSize();
			if (packageSize.length > lockerSize.length || packageSize.width > lockerSize.width
					|| packageSize.height > lockerSize.height) {
				return false;
			}
			return true;
		}

	}
	// Problem : Desgin Amzon Locker, implement placePackage() and retrievePackage()
	// functions.

	// https://leetcode.com/discuss/interview-question/233869/Design-Amazon-Locker-system
}
