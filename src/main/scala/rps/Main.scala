package rps
import scala.io.StdIn.readLine

object Main extends App {
  val line = readLine("Wanna play? (y/n): ")
  if (line == "y") {
    while(true) {
      Game.play()
    }
  } 
}
