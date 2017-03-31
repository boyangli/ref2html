package main
import java.io._

/**
 * @author albert
 */
object Main {
  def main(args: Array[String]) {
    val reader = new BufferedReader(new FileReader(new File("bibliography.bib")))
    val bibtexParser = new org.jbibtex.BibTeXParser()
    val database = bibtexParser.parse(reader)
    val map = database.getEntries
    
    val it = map.keySet().iterator()
    while (it.hasNext())
    {
      val key = it.next()
      val value = map.get(key)
      println(value.toString())
    }
  }
}