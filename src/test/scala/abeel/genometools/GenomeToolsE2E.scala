package abeel.genometools;

import org.scalatest.funsuite.*
import scala.collection.mutable.BitSet
import io.Source

class GenomeToolsE2E extends AnyFunSuite {
  val DIR = "src/test/resources/"
  val BAM = DIR+"uwgs-rw_L2_FC6218_3.CHROMOSOME_IV.sorted.bam"
  val STATS="stats"

  test("stats") {
    GenomeToolsConsole.main(Array("bam2gc","-i", BAM,"-o",STATS))
    val lines = Source.fromFile(STATS).mkString
    assert(lines.size > 10)
    assert(lines.contains("97\t2")) // whatever that means
    // CHECK the output contains "Discarded reads = 350458"
  }

}