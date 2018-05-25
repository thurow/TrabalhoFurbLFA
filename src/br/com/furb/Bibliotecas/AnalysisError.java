package br.com.furb.Bibliotecas;

public class AnalysisError extends Exception
{
    private int position;
    private String token;

    public AnalysisError(String msg, int position, String token)
    {
        super(msg);
        this.position = position;
        this.token = token;
    }

    public AnalysisError(String msg)
    {
        super(msg);
        this.position = -1;
    }

    public int getPosition()
    {
        return position;
    }
    
    public String getToken()
    {
        return token;
    }    

    public String toString()
    {
        return super.toString() + ", @ "+position;
    }
}
