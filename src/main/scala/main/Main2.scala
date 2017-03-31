package main

import java.io.FileInputStream;
import de.undercouch.citeproc.bibtex.BibTeXConverter;
import org.jbibtex.BibTeXDatabase;
import de.undercouch.citeproc.CSL;
import de.undercouch.citeproc.bibtex.BibTeXItemDataProvider;
import scala.collection.JavaConversions._
/**
 * @author albert
 */
object Main2 {
  def main(args: Array[String]) {

    val db = new BibTeXConverter().loadDatabase(new FileInputStream("bibliography.bib"));
    val provider = new BibTeXItemDataProvider();
    provider.addDatabase(db);
    
    val entries = db.getEntries.values()
    for (e <- entries)
    {
      val t = e.getType
      println(t)
      val map = e.getFields
      println(map.map(x => x._1 + " : " + x._2.toUserString()).mkString("\n"))
    }
     

    val citeproc = new CSL(provider, "acm-sigchi-proceedings");
    citeproc.setOutputFormat("html");
    citeproc.registerCitationItems("BAA:03","DiS:94","SVSMS:02");
    val bibl = citeproc.makeBibliography();
    for (entry <- bibl.getEntries()) {      
      System.out.println(entry);
    }
  }
}