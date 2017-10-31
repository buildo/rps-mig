package rps.model

import rps.model.Move._
import rps.model.Result._
import rps.model.Round._
import scala.io.StdIn.readLine
import io.buildo.enumero.{CaseEnumSerialization}

object Game {
  val randomGen = scala.util.Random

  def getRandomMove() : Move = {
    Array(Rock, Paper, Scissors).apply(randomGen.nextInt(3))
  }

  def detectGameEndResult(playerMove: Move, computerMove: Move) : Result = {
    (playerMove, computerMove) match {
      case (x, y) if x == y => Draw
      case (Rock, Paper) | (Paper, Scissors) | (Scissors, Rock) => Lose
      case (Rock, Scissors) | (Paper, Rock) | (Scissors, Paper) => Win
    }
  }

  def play(userPlay: Move) : Round = {
    val myPlay : Move = getRandomMove()

    new Round(userPlay, myPlay, detectGameEndResult(userPlay, myPlay))
  }
}