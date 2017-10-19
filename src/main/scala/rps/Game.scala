package rps
import scala.io.StdIn.readLine

object Game {
  val randomGen = scala.util.Random

  def moveRepr(move: Int): String = {
    move match {
      case 0 => "Rock"
      case 1 => "Paper"
      case 2 => "Scissors"
      case _ => "Invalid move!"
    }
  }

  def detectGameEndResult(playerMove: Int, computerMove: Int) : String = {
    (playerMove, computerMove) match {
      case (x, y) if x == y => "Draw!"
      case (0, 1) | (1, 2) | (2, 0) => "I Won!"
      case (0, 2) | (1, 0) | (2, 1) => "You Won!"
      case (_, _) => "Invalid Round!!"
    }
  }

  def play() : Unit = {
    val myPlay = randomGen.nextInt(3)
    val userPlay = readLine("Choose your move between Rock(0), Paper(1) or Scissors(2): ").toInt

    println(s"You Played: ${moveRepr(userPlay)}")
    println(s"I played: ${moveRepr(myPlay)}")
    println(s"Result: ${detectGameEndResult(userPlay, myPlay)}")
  }
}