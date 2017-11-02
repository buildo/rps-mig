package rps.model

import rps.model.Move._
import rps.model.Result._
import rps.model.Round._

object Game {
  val randomGen = scala.util.Random

  def getRandomMove() : Move = {
    Array(Rock, Paper, Scissors).apply(randomGen.nextInt(3))
  }

  def detectGameEndResult(playerMove: Move, computerMove: Move) : Result = {
    (playerMove, computerMove) match {
      case (x, y) if x == y => Draw
      case (Rock, Paper) | (Paper, Scissors) | (Scissors, Rock) => Lose
      case _ => Win
    }
  }

  def play(userPlay: Move) : Round = {
    val myPlay : Move = getRandomMove()

    Round(userPlay, myPlay, detectGameEndResult(userPlay, myPlay))
  }
}