package rps.dto
import rps.model._

case class Response(userMove: Move, computerMove: Move, result: Result) {
  def this(round: Round) {
    this(round.userMove, round.computerMove, round.result)
  }
}
