package rps
import scala.io.StdIn.readLine
import Move._

object Game {
  val randomGen = scala.util.Random

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
    val userPlay : Option[Move] = Move.toMove(readLine("Choose your move between Rock(0), Paper(1) or Scissors(2): "))

    userPlay match {
      case None => println("Invalid Move! Please, try again...")
      case Some(userMove) => {
        val myPlay : Move = getRandomMove()

        println(s"You Played: ${userMove}")
        println(s"I played: ${myPlay}")
        println(s"Result: ${detectGameEndResult(userMove, myPlay)}")
      }
    }
  }
}