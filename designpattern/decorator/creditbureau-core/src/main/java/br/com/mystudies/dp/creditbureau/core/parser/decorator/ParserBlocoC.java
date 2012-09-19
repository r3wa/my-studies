package br.com.mystudies.dp.creditbureau.core.parser.decorator;

import br.com.mystudies.dp.creditbureau.core.b49c.Protocolo;
import br.com.mystudies.dp.creditbureau.core.model.Relatorio;
import br.com.mystudies.dp.creditbureau.core.parser.ParserRelatorio;

public class ParserBlocoC extends ParserBloco {

	
	ParserRelatorio parserRelatorio;
	
	

	public ParserBlocoC(ParserRelatorio parserRelatorio) {
		this.parserRelatorio = parserRelatorio;
	}

	
	@Override
	public Relatorio parse(Protocolo protocolo, Object... objects) {
		Relatorio relatorio = parserRelatorio.parse(protocolo, objects);
		relatorio.relatorio = relatorio.relatorio + " " + protocolo.blocoC;
		return relatorio;	
	}

}
