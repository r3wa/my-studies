package br.com.mystudies.scala

class Time( val hours:Int, val minutes:Int, val seconds: Int) {

	def before(other: Time) = {
		hours >= other.hours && minutes >= other.minutes && seconds > other.seconds
	}

}