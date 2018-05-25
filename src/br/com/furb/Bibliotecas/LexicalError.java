package br.com.furb.Bibliotecas;

public class LexicalError extends AnalysisError
{
    public LexicalError(String msg, int position, String token)
	 {
        super(msg, position, token);
    }

    public LexicalError(String msg)
    {
        super(msg);
    }

}
