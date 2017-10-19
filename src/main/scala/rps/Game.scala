package rps
import scala.io.StdIn.readLine

sealed trait Move {
  def toString : String
}
case object Rock extends Move {
  override def toString = "Rock"
}
case object Paper extends Move {
  override def toString = "Paper"
}
case object Scissors extends Move {
  override def toString = "Scissors"
}

object Game {
  val randomGen = scala.util.Random

  def convertToMove(move: String): Option[Move] = {
    move match {
      case "0" => Some(Rock)
      case "1" => Some(Paper)
      case "2" => Some(Scissors)
      case _ => None
    }
  }

  def getRandomMove() : Move = {
    Array(Rock, Paper, Scissors).apply(randomGen.nextInt(3))
  }

  def detectGameEndResult(playerMove: Move, computerMove: Move) : String = {
    (playerMove, computerMove) match {
      case (x, y) if x == y => "Draw!"
      case (Rock, Paper) | (Paper, Scissors) | (Scissors, Rock) => "I Won!"
      case (Rock, Scissors) | (Paper, Rock) | (Scissors, Paper) => "You Won!"
      case _ => "Invalid Round!!"
    }
  }

  def play() : Unit = {
    val userPlay : Option[Move] = convertToMove(readLine("Choose your move between Rock(0), Paper(1) or Scissors(2): "))

    userPlay match {
      case None => println("Invalid Move! Please, try again...")
      case Some(_) => {
        val myPlay : Move = getRandomMove()

        println(s"You Played: ${userPlay.get}")
        println(s"I played: ${myPlay}")
        println(s"Result: ${detectGameEndResult(userPlay.get, myPlay)}")
      }
    }
  }
}