package abeel.genometools.wig

import abeel.genometools.Main
import java.io.File
import htsjdk.samtools.SamReader
import htsjdk.samtools.SamReaderFactory
import htsjdk.samtools.ValidationStringency
import atk.compbio.DNAHash
import scala.jdk.CollectionConverters._
import atk.io.NixWriter
import net.sf.jannot.ConvertWig2TDF;
import net.sf.jannot.source.Locator;


object Wig2Tdf extends Main {

  case class Config(val inputFile: File = null, val outputFile: File = null)

  override val description = "Tool to convert WIG to TDF"

  override val version = """
    2026/02/29       Initial version included in genometools
   """

  override def main(args: Array[String]):Unit = {

    val parser = new scopt.OptionParser[Config]("java -jar genometools.jar wig2tdf") {
      opt[File]('i', "input").required().action { (x, c) => c.copy(inputFile = x) }.text ("Input WIG file. ")
      opt[File]('o', "output").action{ (x, c) => c.copy(outputFile = x) }.text("File where you want the output to be written")
    }
    parser.parse(args, Config()) map { config =>

      assume(config.inputFile != null)
      processFile(config)

    }
  }


  private def processFile(config: Config):Unit =  {
    ConvertWig2TDF.convertWig2TDF(new Locator(config.inputFile), config.outputFile);
  }
}