package br.com.mystudies.scala

package shapes{
  
  
  class Point(val x: Double,  val y: Double){}
  
  class LabelPoint(val label: String, x: Double,  y: Double) extends Point(x, y){}
  
  
  abstract class Shape{ def centerPoint: Double }
  
  
  class Circle(radius: Double) extends Shape{ def centerPoint = 0.0 /* the center point of a circle is coordinate x= 0, y =0*/} 
  
  class Rectangle(width: Double, height: Double) extends Shape{
    def centerPoint = ( width + height ) / 2 // I don't know the calculate, ok ! I saw in Internet but It's very complicate...
  }
  
}