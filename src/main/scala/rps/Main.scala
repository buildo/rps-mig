package rps
import scala.io.StdIn

object Main extends App {
  println("Wanna play? (y/n) ")
  val line = StdIn.readLine()
  if (line == "y") {
    while(true) {
      Game.play()
    }
  } 
}
