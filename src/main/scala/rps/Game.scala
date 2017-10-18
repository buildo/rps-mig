package rps
import java.util.Scanner
import java.util.InputMismatchException

object Game {
  def moveRepr(move: Int) : String = {
    move match {
      case 0 => return "Rock"
      case 1 => return "Paper"
      case 2 => return "Scissors"
      case _ => return "Invalid move!"
    }
  }

  def detectGameEndResult(playerMove: Int, computerMove: Int) : String = {
    (playerMove, computerMove) match {
      case (x, y) if x == y => return "Draw!"
      case (0, 1) => return "I Won!"
      case (0, 2) => return "You Won!"
      case (1, 0) => return "You won!"
      case (1, 2) => return "I won!"
      case (2, 0) => return "I won!"
      case (2, 1) => return "You won!"
      case (_, _) => return "Invalid Round!!"
    }
  }

  def play() : Unit = {
    var scanner = new Scanner(System.in)
    val r = scala.util.Random
    print("Choose your move between Rock(0), Paper(1) or Scissors(2): ")

    val myPlay = r.nextInt(3)
    val userPlay = try {
      scanner.nextInt()
    } catch {
      case ex: InputMismatchException => -1
    }
    println(s"You Played: ${moveRepr(userPlay)}")
    println(s"I played: ${moveRepr(myPlay)}")
    println(s"Result: ${detectGameEndResult(userPlay, myPlay)}")
  }
}