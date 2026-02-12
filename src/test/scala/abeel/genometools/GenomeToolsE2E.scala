package abeel.genometools;

import org.scalatest.funsuite.*
import scala.collection.mutable.BitSet


class TestBitSetTools extends AnyFunSuite {
  val DIR = "src/test/resources/"
  val BAM = DIR+"uwgs-rw_L2_FC6218_3.CHROMOSOME_IV.sorted.bam"
  

  test("stats") {
    GenomeToolsConsole.main(Array("bam2gc", BAM))
  }

}