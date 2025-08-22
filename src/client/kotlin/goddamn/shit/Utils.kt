package goddamn.shit

object Utils {
	fun <T : Number>inTicks(sec: T): Int {
		return sec.toInt() * 20
	}
}
