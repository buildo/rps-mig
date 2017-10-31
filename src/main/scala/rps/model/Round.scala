package rps.model
import rps.model.Result._
import rps.model.Move._

case class Round(userMove: Move, computerMove: Move, result: Result)