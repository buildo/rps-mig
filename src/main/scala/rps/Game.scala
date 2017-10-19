package rps
import scala.io.StdIn.readLine

sealed abstract class Move {
  def toString : String
}
case object ROCK extends Move {
  override def toString = "Rock"
}
case object PAPER extends Move {
  override def toString = "Paper"
}
case object SCISSORS extends Move {
  override def toString = "Scissors"
}
case object INVALID extends Move {
  override def toString = "Invalid Move!"
}

object Game {
  val randomGen = scala.util.Random

  implicit def intToMove(move: Option[Int]): Move = {
   move match {
    case Some(0) => ROCK
    case Some(1) => PAPER
    case Some(2) => SCISSORS
    case _ => INVALID
  }
}

  def detectGameEndResult(playerMove: Move, computerMove: Move) : String = {
    (playerMove, computerMove) match {
      case (x, y) if x == y => "Draw!"
      case (ROCK, PAPER) | (PAPER, SCISSORS) | (PAPER, ROCK) => "I Won!"
      case (ROCK, SCISSORS) | (PAPER, ROCK) | (SCISSORS, PAPER) => "You Won!"
      case (_, _) => "Invalid Round!!"
    }
  }

  def play() : Unit = {
    val myPlay : Move = Some(randomGen.nextInt(3))

    val userPlay : Move = try {
      Some(readLine("Choose your move between Rock(0), Paper(1) or Scissors(2): ").toInt)
    }
    catch {
      case ex: NumberFormatException => None
    }

    println(s"You Played: ${userPlay}")
    println(s"I played: ${myPlay}")
    println(s"Result: ${detectGameEndResult(userPlay, myPlay)}")
  }
}