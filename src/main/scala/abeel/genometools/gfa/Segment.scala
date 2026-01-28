package abeel.genometools.gfa

//import scala.collection.mutable.MutableList
import java.util.ArrayList

case class Segment(val idx: Int, val sequenceLen: Int, 
    val genomeIdx: List[Int], val incoming: ArrayList[Int], val outgoing: ArrayList[Int]) {
  override def toString() = {
    idx + "," + sequenceLen + "," + genomeIdx + "," + incoming + "," + outgoing
  }
}