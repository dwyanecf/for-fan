package com.fanchen.groupsolve;

public class Sqrt {
	public static double sqrt(double t, Double precise) {
		double lo = 0;
		double hi = t;
		double squre, prec = precise != null ? precise : 1e-7;
		if (t < 0) {
			throw new RuntimeException("Negetive number cannot have a sqrt root.");
		}

		while (hi - lo > prec) {
			double middle = lo + (hi - lo) / 2;
			squre = middle * middle;

			if (squre > t) {
				hi = middle;
			} else {
				lo = middle;
			}
		}
		return (lo + hi) / 2;
	}
}
