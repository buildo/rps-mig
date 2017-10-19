package rps;

object Move {
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

  def toMove(ref: String) : Option[Move] = {
    ref match {
      case "0" => Some(Rock)
      case "1" => Some(Paper)
      case "2" => Some(Scissors)
      case _ => None
    }
  }
}