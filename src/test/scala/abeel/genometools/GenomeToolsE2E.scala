package abeel.genometools;

import org.scalatest.funsuite.*
import scala.collection.mutable.BitSet
import io.Source
import java.io.File

class GenomeToolsE2E extends AnyFunSuite {
  val DIR = "src/test/resources/"
  val BAM = DIR+"uwgs-rw_L2_FC6218_3.CHROMOSOME_IV.sorted.bam"
  val FASTA = DIR+"IV.fasta"
  val CG = "histo"
  val STATS = "stats"
  val FSTATS = "fstats"
  val WIG = DIR+"IV.wig"
  val TDF = "IV.tdf"

  test("bam2cg") {
    GenomeToolsConsole.main(Array("bam2gc","-i", BAM,"-o",CG))
    val lines = Source.fromFile(CG).mkString
    assert(lines.size > 10)
    assert(lines.contains("97\t2")) // whatever that means
    // CHECK the output contains "Discarded reads = 350458"
  }

  test("bamstats") {
    GenomeToolsConsole.main(Array("bamstats","-i", BAM,"-o",STATS))
    val lines = Source.fromFile(STATS+".txt").mkString
    assert(lines.size > 10)
    assert(lines.contains("read.count=323698")) // whatever that means
    val image=new File(STATS+".png")
    assert(image.exists)
    assert(image.length > 20000)
  }

// disabled. bug in atk FastAFile
//  test("faq2gc") {
//    GenomeToolsConsole.main(Array("faq2gc","-i", FASTA,"-o",FSTATS))
//    //val lines = Source.fromFile(FSTATS).mkString
//    //assert(lines.size > 10)
//    //assert(lines.contains("read.count=323698")) // whatever that means
//  }

  test("wig2tdf") {
    GenomeToolsConsole.main(Array("wig2tdf","-i", WIG,"-o",TDF))
    assert(new File(TDF).exists)
    assert(new File(TDF).length > 7000)  // 7775 bytes with manual run
    // it's a binary file, no clue what to do with it from here.
  }


}