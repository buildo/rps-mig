package rps.dto
import rps.model._

case class Response(userMove: Move, computerMove: Move, result: Result)

object Response {
  def apply(round: Round): Response = new Response(round.userMove, round.computerMove, round.result)
}