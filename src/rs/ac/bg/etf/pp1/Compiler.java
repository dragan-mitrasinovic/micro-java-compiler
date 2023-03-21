package rs.ac.bg.etf.pp1;

import java.io.*;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.symboltable.Tab;

public class Compiler {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}

	public static void main(String[] args) throws Exception {

		Logger log = Logger.getLogger(Compiler.class);

		Reader br = null;
		try {
			String fileName = args[0];

			File sourceCode = new File(fileName);
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());

			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);

			MJParser parser = new MJParser(lexer);
			Symbol symbol = parser.parse();

			Program program = (Program) (symbol.value);
			Tab.init();

			log.info(program.toString(""));
			log.info("===================================");

			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			program.traverseBottomUp(semanticAnalyzer);

			log.info("===================================");
			Tab.dump();

			if (!parser.errorDetected && semanticAnalyzer.passed()) {
				log.info("Parsing completed successfully!");
			} else {
				log.error("Parsing failed!");
			}

		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e1) {
					log.error(e1.getMessage(), e1);
				}
		}

	}

}
