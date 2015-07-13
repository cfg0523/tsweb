package com.techsen.tsweb.core.util.sql;

public enum Operator {
	eq {
		public String toString() {
			return "=";
		}
	},
	like {
		public String toString() {
			return "like";
		}
	},
	gt {
		public String toString() {
			return ">";
		}
	},
	ge {
		public String toString() {
			return ">=";
		}
	},
	lt {
		public String toString() {
			return "<";
		}
	},
	le {
		public String toString() {
			return "<=";
		}
	},
	ne {
		public String toString() {
			return "!=";
		}
	},
	notlike {
		public String toString(){
			return "not like";
		}
	}
}
