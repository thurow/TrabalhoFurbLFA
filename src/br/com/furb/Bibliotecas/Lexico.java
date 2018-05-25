package br.com.furb.Bibliotecas;

public class Lexico implements Constants
{
    private int position;
    private String input;
    
    public Lexico()
    {
        this("");
    }

    public Lexico(String input)
    {
        setInput(input);
    }
    
        /**
     * @return the token
     */
    public String getToken() {
        return input.substring(position, input.substring(position).indexOf(" ") );
    }


    public void setInput(String input)
    {
        this.input = input;
        setPosition(0);
    }
    
    public String getInput()
    {
        return this.input;
    }

    public void setPosition(int pos)
    {
        position = pos;
    }

    public Token nextToken() throws LexicalError
    {
        if ( ! hasInput() )
            return null;

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;
        char c;
        String tokenStr = "";
        while (hasInput())
        {
            lastState = state;
            c = nextChar();
            tokenStr = tokenStr + c;
            state = nextState(c, state);

            if (state < 0)
                break;

            else
            {
                if (tokenForState(state) >= 0)
                {
                    endState = state;
                    end = position;
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)){
            int pos = input.indexOf(' ', start);
            
            //Caso não ache um espaço, considera a última pos da linha
            if (pos == -1) 
                pos = input.length() - 1; 
            
            tokenStr = input.substring(start, pos + 1);
            if (tokenStr.startsWith("R$")) {
                // pega uma posição a mais do espaço pois o valor correto é R$" "3,00
                int spaceIndex = input.indexOf(' ', pos + 1);
                
                //Caso não ache um espaço, considera a última pos da linha
                if (spaceIndex == -1) 
                    spaceIndex = input.length() - 1;
                
                tokenStr = tokenStr + input.substring(pos + 1, spaceIndex);
            }
            throw new  LexicalError(SCANNER_ERROR[lastState], start, tokenStr);
        }
            
        position = end;

        int token = tokenForState(endState);

        if (token == 0)
            return nextToken();
        else
        {
            String lexeme = input.substring(start, end);
            token = lookupToken(token, lexeme);
            return new Token(token, lexeme, start);
        }
    }

    private int nextState(char c, int state)
    {
        switch (state)
        {
            case 0:
                switch (c)
                {
                    case 9: return 1;
                    case 10: return 1;
                    case 32: return 1;
                    case 48: return 2;
                    case 49: return 3;
                    case 50: return 4;
                    case 51: return 5;
                    case 52: return 5;
                    case 53: return 5;
                    case 54: return 5;
                    case 55: return 5;
                    case 56: return 5;
                    case 57: return 6;
                    case 65: return 7;
                    case 66: return 7;
                    case 67: return 7;
                    case 68: return 7;
                    case 69: return 7;
                    case 70: return 7;
                    case 71: return 7;
                    case 72: return 7;
                    case 73: return 7;
                    case 74: return 7;
                    case 75: return 7;
                    case 76: return 7;
                    case 77: return 7;
                    case 78: return 7;
                    case 79: return 7;
                    case 80: return 7;
                    case 81: return 7;
                    case 82: return 8;
                    case 83: return 7;
                    case 84: return 7;
                    case 85: return 7;
                    case 86: return 7;
                    case 87: return 7;
                    case 88: return 7;
                    case 89: return 7;
                    case 90: return 7;
                    case 193: return 9;
                    default: return -1;
                }
            case 2:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 3:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 14;
                    case 48: return 15;
                    case 49: return 15;
                    case 50: return 15;
                    case 51: return 15;
                    case 52: return 15;
                    case 53: return 15;
                    case 54: return 15;
                    case 55: return 15;
                    case 56: return 15;
                    case 57: return 16;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 4:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 14;
                    case 48: return 17;
                    case 49: return 18;
                    case 50: return 18;
                    case 51: return 18;
                    case 52: return 18;
                    case 53: return 18;
                    case 54: return 18;
                    case 55: return 18;
                    case 56: return 18;
                    case 57: return 18;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 5:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 14;
                    case 48: return 19;
                    case 49: return 19;
                    case 50: return 19;
                    case 51: return 19;
                    case 52: return 19;
                    case 53: return 19;
                    case 54: return 19;
                    case 55: return 19;
                    case 56: return 19;
                    case 57: return 19;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 6:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 14;
                    case 48: return 19;
                    case 49: return 19;
                    case 50: return 19;
                    case 51: return 20;
                    case 52: return 20;
                    case 53: return 20;
                    case 54: return 20;
                    case 55: return 20;
                    case 56: return 20;
                    case 57: return 20;
                    case 65: return 21;
                    case 66: return 21;
                    case 67: return 21;
                    case 68: return 21;
                    case 69: return 21;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 7:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 22;
                    case 66: return 22;
                    case 67: return 22;
                    case 68: return 22;
                    case 69: return 22;
                    case 70: return 22;
                    case 71: return 22;
                    case 72: return 22;
                    case 73: return 22;
                    case 74: return 22;
                    case 75: return 22;
                    case 76: return 22;
                    case 77: return 22;
                    case 78: return 22;
                    case 79: return 22;
                    case 80: return 22;
                    case 81: return 22;
                    case 82: return 22;
                    case 83: return 22;
                    case 84: return 22;
                    case 85: return 22;
                    case 86: return 22;
                    case 87: return 22;
                    case 88: return 22;
                    case 89: return 22;
                    case 90: return 22;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 8:
                switch (c)
                {
                    case 36: return 23;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 22;
                    case 66: return 22;
                    case 67: return 22;
                    case 68: return 22;
                    case 69: return 22;
                    case 70: return 22;
                    case 71: return 22;
                    case 72: return 22;
                    case 73: return 22;
                    case 74: return 22;
                    case 75: return 22;
                    case 76: return 22;
                    case 77: return 22;
                    case 78: return 22;
                    case 79: return 22;
                    case 80: return 22;
                    case 81: return 22;
                    case 82: return 22;
                    case 83: return 22;
                    case 84: return 22;
                    case 85: return 22;
                    case 86: return 22;
                    case 87: return 22;
                    case 88: return 22;
                    case 89: return 22;
                    case 90: return 22;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 9:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 10:
                switch (c)
                {
                    case 107: return 24;
                    default: return -1;
                }
            case 11:
                switch (c)
                {
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 12:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 13:
                switch (c)
                {
                    case 107: return 25;
                    default: return -1;
                }
            case 14:
                switch (c)
                {
                    case 48: return 26;
                    case 49: return 26;
                    case 50: return 26;
                    case 51: return 26;
                    case 52: return 26;
                    case 53: return 26;
                    case 54: return 26;
                    case 55: return 26;
                    case 56: return 26;
                    case 57: return 26;
                    default: return -1;
                }
            case 15:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 27;
                    case 48: return 28;
                    case 49: return 28;
                    case 50: return 28;
                    case 51: return 28;
                    case 52: return 28;
                    case 53: return 28;
                    case 54: return 28;
                    case 55: return 28;
                    case 56: return 28;
                    case 57: return 28;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 16:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 27;
                    case 48: return 29;
                    case 49: return 29;
                    case 50: return 29;
                    case 51: return 29;
                    case 52: return 29;
                    case 53: return 29;
                    case 54: return 29;
                    case 55: return 29;
                    case 56: return 29;
                    case 57: return 29;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 17:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 27;
                    case 48: return 30;
                    case 49: return 31;
                    case 50: return 31;
                    case 51: return 31;
                    case 52: return 31;
                    case 53: return 31;
                    case 54: return 31;
                    case 55: return 31;
                    case 56: return 31;
                    case 57: return 31;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 18:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 27;
                    case 48: return 31;
                    case 49: return 31;
                    case 50: return 31;
                    case 51: return 31;
                    case 52: return 31;
                    case 53: return 31;
                    case 54: return 31;
                    case 55: return 31;
                    case 56: return 31;
                    case 57: return 31;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 19:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 27;
                    case 48: return 32;
                    case 49: return 32;
                    case 50: return 32;
                    case 51: return 32;
                    case 52: return 32;
                    case 53: return 32;
                    case 54: return 32;
                    case 55: return 32;
                    case 56: return 32;
                    case 57: return 32;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 20:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 27;
                    case 48: return 32;
                    case 49: return 32;
                    case 50: return 32;
                    case 51: return 32;
                    case 52: return 32;
                    case 53: return 32;
                    case 54: return 32;
                    case 55: return 32;
                    case 56: return 32;
                    case 57: return 32;
                    case 65: return 33;
                    case 66: return 33;
                    case 67: return 33;
                    case 68: return 33;
                    case 69: return 33;
                    case 70: return 33;
                    case 71: return 33;
                    case 72: return 33;
                    case 73: return 33;
                    case 74: return 33;
                    case 75: return 33;
                    case 76: return 33;
                    case 77: return 33;
                    case 78: return 33;
                    case 79: return 33;
                    case 80: return 33;
                    case 81: return 33;
                    case 82: return 33;
                    case 83: return 33;
                    case 84: return 33;
                    case 85: return 33;
                    case 86: return 33;
                    case 87: return 33;
                    case 88: return 33;
                    case 89: return 33;
                    case 90: return 33;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 21:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 33;
                    case 66: return 33;
                    case 67: return 33;
                    case 68: return 33;
                    case 69: return 33;
                    case 70: return 33;
                    case 71: return 33;
                    case 72: return 33;
                    case 73: return 33;
                    case 74: return 33;
                    case 75: return 33;
                    case 76: return 33;
                    case 77: return 33;
                    case 78: return 33;
                    case 79: return 33;
                    case 80: return 33;
                    case 81: return 33;
                    case 82: return 33;
                    case 83: return 33;
                    case 84: return 33;
                    case 85: return 33;
                    case 86: return 33;
                    case 87: return 33;
                    case 88: return 33;
                    case 89: return 33;
                    case 90: return 33;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 22:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 34;
                    case 66: return 34;
                    case 67: return 34;
                    case 68: return 34;
                    case 69: return 34;
                    case 70: return 34;
                    case 71: return 34;
                    case 72: return 34;
                    case 73: return 34;
                    case 74: return 34;
                    case 75: return 34;
                    case 76: return 34;
                    case 77: return 34;
                    case 78: return 34;
                    case 79: return 34;
                    case 80: return 34;
                    case 81: return 34;
                    case 82: return 34;
                    case 83: return 34;
                    case 84: return 34;
                    case 85: return 34;
                    case 86: return 34;
                    case 87: return 34;
                    case 88: return 34;
                    case 89: return 34;
                    case 90: return 34;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 23:
                switch (c)
                {
                    case 32: return 35;
                    default: return -1;
                }
            case 24:
                switch (c)
                {
                    case 109: return 36;
                    default: return -1;
                }
            case 25:
                switch (c)
                {
                    case 109: return 36;
                    default: return -1;
                }
            case 26:
                switch (c)
                {
                    case 48: return 37;
                    case 49: return 37;
                    case 50: return 37;
                    case 51: return 37;
                    case 52: return 37;
                    case 53: return 37;
                    case 54: return 37;
                    case 55: return 37;
                    case 56: return 37;
                    case 57: return 37;
                    default: return -1;
                }
            case 27:
                switch (c)
                {
                    case 48: return 38;
                    case 49: return 38;
                    case 50: return 38;
                    case 51: return 38;
                    case 52: return 38;
                    case 53: return 38;
                    case 54: return 38;
                    case 55: return 38;
                    case 56: return 38;
                    case 57: return 38;
                    default: return -1;
                }
            case 28:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 39;
                    case 48: return 40;
                    case 49: return 40;
                    case 50: return 40;
                    case 51: return 40;
                    case 52: return 40;
                    case 53: return 40;
                    case 54: return 40;
                    case 55: return 40;
                    case 56: return 40;
                    case 57: return 40;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 29:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 39;
                    case 48: return 41;
                    case 49: return 41;
                    case 50: return 41;
                    case 51: return 41;
                    case 52: return 41;
                    case 53: return 41;
                    case 54: return 41;
                    case 55: return 41;
                    case 56: return 41;
                    case 57: return 41;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 30:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 46: return 42;
                    case 48: return 41;
                    case 49: return 41;
                    case 50: return 41;
                    case 51: return 41;
                    case 52: return 41;
                    case 53: return 41;
                    case 54: return 41;
                    case 55: return 41;
                    case 56: return 41;
                    case 57: return 41;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 31:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 48: return 41;
                    case 49: return 41;
                    case 50: return 41;
                    case 51: return 41;
                    case 52: return 41;
                    case 53: return 41;
                    case 54: return 41;
                    case 55: return 41;
                    case 56: return 41;
                    case 57: return 41;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 32:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 48: return 40;
                    case 49: return 40;
                    case 50: return 40;
                    case 51: return 40;
                    case 52: return 40;
                    case 53: return 40;
                    case 54: return 40;
                    case 55: return 40;
                    case 56: return 40;
                    case 57: return 40;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 33:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 43;
                    case 49: return 43;
                    case 50: return 43;
                    case 51: return 43;
                    case 52: return 43;
                    case 53: return 43;
                    case 54: return 43;
                    case 55: return 43;
                    case 56: return 43;
                    case 57: return 43;
                    case 65: return 43;
                    case 66: return 43;
                    case 67: return 43;
                    case 68: return 43;
                    case 69: return 43;
                    case 70: return 43;
                    case 71: return 43;
                    case 72: return 43;
                    case 73: return 43;
                    case 74: return 43;
                    case 75: return 43;
                    case 76: return 43;
                    case 77: return 43;
                    case 78: return 43;
                    case 79: return 43;
                    case 80: return 43;
                    case 81: return 43;
                    case 82: return 43;
                    case 83: return 43;
                    case 84: return 43;
                    case 85: return 43;
                    case 86: return 43;
                    case 87: return 43;
                    case 88: return 43;
                    case 89: return 43;
                    case 90: return 43;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 34:
                switch (c)
                {
                    case 45: return 44;
                    case 46: return 45;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 35:
                switch (c)
                {
                    case 48: return 46;
                    case 49: return 47;
                    case 50: return 47;
                    case 51: return 47;
                    case 52: return 47;
                    case 53: return 47;
                    case 54: return 47;
                    case 55: return 47;
                    case 56: return 47;
                    case 57: return 47;
                    default: return -1;
                }
            case 37:
                switch (c)
                {
                    case 48: return 48;
                    case 49: return 48;
                    case 50: return 48;
                    case 51: return 48;
                    case 52: return 48;
                    case 53: return 48;
                    case 54: return 48;
                    case 55: return 48;
                    case 56: return 48;
                    case 57: return 48;
                    default: return -1;
                }
            case 38:
                switch (c)
                {
                    case 48: return 37;
                    case 49: return 37;
                    case 50: return 37;
                    case 51: return 37;
                    case 52: return 37;
                    case 53: return 37;
                    case 54: return 37;
                    case 55: return 37;
                    case 56: return 37;
                    case 57: return 37;
                    default: return -1;
                }
            case 39:
                switch (c)
                {
                    case 48: return 49;
                    case 49: return 49;
                    case 50: return 49;
                    case 51: return 49;
                    case 52: return 49;
                    case 53: return 49;
                    case 54: return 49;
                    case 55: return 49;
                    case 56: return 49;
                    case 57: return 49;
                    default: return -1;
                }
            case 40:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 41:
                switch (c)
                {
                    case 32: return 13;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 42:
                switch (c)
                {
                    case 48: return 50;
                    default: return -1;
                }
            case 43:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 51;
                    case 49: return 51;
                    case 50: return 51;
                    case 51: return 51;
                    case 52: return 51;
                    case 53: return 51;
                    case 54: return 51;
                    case 55: return 51;
                    case 56: return 51;
                    case 57: return 51;
                    case 65: return 51;
                    case 66: return 51;
                    case 67: return 51;
                    case 68: return 51;
                    case 69: return 51;
                    case 70: return 51;
                    case 71: return 51;
                    case 72: return 51;
                    case 73: return 51;
                    case 74: return 51;
                    case 75: return 51;
                    case 76: return 51;
                    case 77: return 51;
                    case 78: return 51;
                    case 79: return 51;
                    case 80: return 51;
                    case 81: return 51;
                    case 82: return 51;
                    case 83: return 51;
                    case 84: return 51;
                    case 85: return 51;
                    case 86: return 51;
                    case 87: return 51;
                    case 88: return 51;
                    case 89: return 51;
                    case 90: return 51;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 44:
                switch (c)
                {
                    case 48: return 52;
                    case 49: return 53;
                    case 50: return 53;
                    case 51: return 53;
                    case 52: return 53;
                    case 53: return 53;
                    case 54: return 53;
                    case 55: return 53;
                    case 56: return 53;
                    case 57: return 53;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 45:
                switch (c)
                {
                    case 48: return 54;
                    case 49: return 55;
                    case 50: return 55;
                    case 51: return 55;
                    case 52: return 55;
                    case 53: return 55;
                    case 54: return 55;
                    case 55: return 55;
                    case 56: return 55;
                    case 57: return 55;
                    default: return -1;
                }
            case 46:
                switch (c)
                {
                    case 44: return 56;
                    default: return -1;
                }
            case 47:
                switch (c)
                {
                    case 44: return 57;
                    case 46: return 58;
                    case 48: return 59;
                    case 49: return 59;
                    case 50: return 59;
                    case 51: return 59;
                    case 52: return 59;
                    case 53: return 59;
                    case 54: return 59;
                    case 55: return 59;
                    case 56: return 59;
                    case 57: return 59;
                    default: return -1;
                }
            case 48:
                switch (c)
                {
                    case 32: return 60;
                    default: return -1;
                }
            case 49:
                switch (c)
                {
                    case 48: return 61;
                    case 49: return 61;
                    case 50: return 61;
                    case 51: return 61;
                    case 52: return 61;
                    case 53: return 61;
                    case 54: return 61;
                    case 55: return 61;
                    case 56: return 61;
                    case 57: return 61;
                    default: return -1;
                }
            case 50:
                switch (c)
                {
                    case 48: return 62;
                    default: return -1;
                }
            case 51:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 63;
                    case 49: return 63;
                    case 50: return 63;
                    case 51: return 63;
                    case 52: return 63;
                    case 53: return 63;
                    case 54: return 63;
                    case 55: return 63;
                    case 56: return 63;
                    case 57: return 63;
                    case 65: return 63;
                    case 66: return 63;
                    case 67: return 63;
                    case 68: return 63;
                    case 69: return 63;
                    case 70: return 63;
                    case 71: return 63;
                    case 72: return 63;
                    case 73: return 63;
                    case 74: return 63;
                    case 75: return 63;
                    case 76: return 63;
                    case 77: return 63;
                    case 78: return 63;
                    case 79: return 63;
                    case 80: return 63;
                    case 81: return 63;
                    case 82: return 63;
                    case 83: return 63;
                    case 84: return 63;
                    case 85: return 63;
                    case 86: return 63;
                    case 87: return 63;
                    case 88: return 63;
                    case 89: return 63;
                    case 90: return 63;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 52:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 64;
                    case 49: return 65;
                    case 50: return 65;
                    case 51: return 65;
                    case 52: return 65;
                    case 53: return 65;
                    case 54: return 65;
                    case 55: return 65;
                    case 56: return 65;
                    case 57: return 65;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 53:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 66;
                    case 49: return 67;
                    case 50: return 67;
                    case 51: return 67;
                    case 52: return 67;
                    case 53: return 67;
                    case 54: return 67;
                    case 55: return 67;
                    case 56: return 67;
                    case 57: return 67;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 54:
                switch (c)
                {
                    case 48: return 68;
                    case 49: return 69;
                    case 50: return 69;
                    case 51: return 69;
                    case 52: return 69;
                    case 53: return 69;
                    case 54: return 69;
                    case 55: return 69;
                    case 56: return 69;
                    case 57: return 69;
                    default: return -1;
                }
            case 55:
                switch (c)
                {
                    case 48: return 70;
                    case 49: return 71;
                    case 50: return 71;
                    case 51: return 71;
                    case 52: return 71;
                    case 53: return 71;
                    case 54: return 71;
                    case 55: return 71;
                    case 56: return 71;
                    case 57: return 71;
                    default: return -1;
                }
            case 56:
                switch (c)
                {
                    case 48: return 72;
                    case 49: return 72;
                    case 50: return 72;
                    case 51: return 72;
                    case 52: return 72;
                    case 53: return 72;
                    case 54: return 72;
                    case 55: return 72;
                    case 56: return 72;
                    case 57: return 72;
                    default: return -1;
                }
            case 57:
                switch (c)
                {
                    case 48: return 73;
                    case 49: return 73;
                    case 50: return 73;
                    case 51: return 73;
                    case 52: return 73;
                    case 53: return 73;
                    case 54: return 73;
                    case 55: return 73;
                    case 56: return 73;
                    case 57: return 73;
                    default: return -1;
                }
            case 58:
                switch (c)
                {
                    case 48: return 74;
                    case 49: return 74;
                    case 50: return 74;
                    case 51: return 74;
                    case 52: return 74;
                    case 53: return 74;
                    case 54: return 74;
                    case 55: return 74;
                    case 56: return 74;
                    case 57: return 74;
                    default: return -1;
                }
            case 59:
                switch (c)
                {
                    case 44: return 57;
                    case 46: return 58;
                    case 48: return 75;
                    case 49: return 75;
                    case 50: return 75;
                    case 51: return 75;
                    case 52: return 75;
                    case 53: return 75;
                    case 54: return 75;
                    case 55: return 75;
                    case 56: return 75;
                    case 57: return 75;
                    default: return -1;
                }
            case 60:
                switch (c)
                {
                    case 107: return 76;
                    default: return -1;
                }
            case 61:
                switch (c)
                {
                    case 48: return 77;
                    case 49: return 77;
                    case 50: return 77;
                    case 51: return 77;
                    case 52: return 77;
                    case 53: return 77;
                    case 54: return 77;
                    case 55: return 77;
                    case 56: return 77;
                    case 57: return 77;
                    default: return -1;
                }
            case 62:
                switch (c)
                {
                    case 48: return 78;
                    default: return -1;
                }
            case 63:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 79;
                    case 49: return 79;
                    case 50: return 79;
                    case 51: return 79;
                    case 52: return 79;
                    case 53: return 79;
                    case 54: return 79;
                    case 55: return 79;
                    case 56: return 79;
                    case 57: return 79;
                    case 65: return 79;
                    case 66: return 79;
                    case 67: return 79;
                    case 68: return 79;
                    case 69: return 79;
                    case 70: return 79;
                    case 71: return 79;
                    case 72: return 79;
                    case 73: return 79;
                    case 74: return 79;
                    case 75: return 79;
                    case 76: return 79;
                    case 77: return 79;
                    case 78: return 79;
                    case 79: return 79;
                    case 80: return 79;
                    case 81: return 79;
                    case 82: return 79;
                    case 83: return 79;
                    case 84: return 79;
                    case 85: return 79;
                    case 86: return 79;
                    case 87: return 79;
                    case 88: return 79;
                    case 89: return 79;
                    case 90: return 79;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 64:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 80;
                    case 49: return 81;
                    case 50: return 81;
                    case 51: return 81;
                    case 52: return 81;
                    case 53: return 81;
                    case 54: return 81;
                    case 55: return 81;
                    case 56: return 81;
                    case 57: return 81;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 65:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 82;
                    case 49: return 83;
                    case 50: return 83;
                    case 51: return 83;
                    case 52: return 83;
                    case 53: return 83;
                    case 54: return 83;
                    case 55: return 83;
                    case 56: return 83;
                    case 57: return 83;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 66:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 84;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 67:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 68:
                switch (c)
                {
                    case 48: return 88;
                    case 49: return 89;
                    case 50: return 89;
                    case 51: return 89;
                    case 52: return 89;
                    case 53: return 89;
                    case 54: return 89;
                    case 55: return 89;
                    case 56: return 89;
                    case 57: return 89;
                    default: return -1;
                }
            case 69:
                switch (c)
                {
                    case 48: return 90;
                    case 49: return 91;
                    case 50: return 91;
                    case 51: return 91;
                    case 52: return 91;
                    case 53: return 91;
                    case 54: return 91;
                    case 55: return 91;
                    case 56: return 91;
                    case 57: return 91;
                    default: return -1;
                }
            case 70:
                switch (c)
                {
                    case 48: return 92;
                    case 49: return 93;
                    case 50: return 93;
                    case 51: return 93;
                    case 52: return 93;
                    case 53: return 93;
                    case 54: return 93;
                    case 55: return 93;
                    case 56: return 93;
                    case 57: return 93;
                    default: return -1;
                }
            case 71:
                switch (c)
                {
                    case 48: return 94;
                    case 49: return 95;
                    case 50: return 95;
                    case 51: return 95;
                    case 52: return 95;
                    case 53: return 95;
                    case 54: return 95;
                    case 55: return 95;
                    case 56: return 95;
                    case 57: return 95;
                    default: return -1;
                }
            case 72:
                switch (c)
                {
                    case 48: return 96;
                    case 49: return 96;
                    case 50: return 96;
                    case 51: return 96;
                    case 52: return 96;
                    case 53: return 96;
                    case 54: return 96;
                    case 55: return 96;
                    case 56: return 96;
                    case 57: return 96;
                    default: return -1;
                }
            case 73:
                switch (c)
                {
                    case 48: return 96;
                    case 49: return 96;
                    case 50: return 96;
                    case 51: return 96;
                    case 52: return 96;
                    case 53: return 96;
                    case 54: return 96;
                    case 55: return 96;
                    case 56: return 96;
                    case 57: return 96;
                    default: return -1;
                }
            case 74:
                switch (c)
                {
                    case 48: return 97;
                    case 49: return 97;
                    case 50: return 97;
                    case 51: return 97;
                    case 52: return 97;
                    case 53: return 97;
                    case 54: return 97;
                    case 55: return 97;
                    case 56: return 97;
                    case 57: return 97;
                    default: return -1;
                }
            case 75:
                switch (c)
                {
                    case 44: return 57;
                    case 46: return 58;
                    default: return -1;
                }
            case 76:
                switch (c)
                {
                    case 109: return 36;
                    default: return -1;
                }
            case 77:
                switch (c)
                {
                    case 32: return 98;
                    default: return -1;
                }
            case 78:
                switch (c)
                {
                    case 32: return 99;
                    default: return -1;
                }
            case 79:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 100;
                    case 49: return 100;
                    case 50: return 100;
                    case 51: return 100;
                    case 52: return 100;
                    case 53: return 100;
                    case 54: return 100;
                    case 55: return 100;
                    case 56: return 100;
                    case 57: return 100;
                    case 65: return 100;
                    case 66: return 100;
                    case 67: return 100;
                    case 68: return 100;
                    case 69: return 100;
                    case 70: return 100;
                    case 71: return 100;
                    case 72: return 100;
                    case 73: return 100;
                    case 74: return 100;
                    case 75: return 100;
                    case 76: return 100;
                    case 77: return 100;
                    case 78: return 100;
                    case 79: return 100;
                    case 80: return 100;
                    case 81: return 100;
                    case 82: return 100;
                    case 83: return 100;
                    case 84: return 100;
                    case 85: return 100;
                    case 86: return 100;
                    case 87: return 100;
                    case 88: return 100;
                    case 89: return 100;
                    case 90: return 100;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 80:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 81:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 101;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 82:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 101;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 83:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 101;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 84:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 101;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 85:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 101;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 86:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 101;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 87:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 101;
                    case 49: return 101;
                    case 50: return 101;
                    case 51: return 101;
                    case 52: return 101;
                    case 53: return 101;
                    case 54: return 101;
                    case 55: return 101;
                    case 56: return 101;
                    case 57: return 101;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 88:
                switch (c)
                {
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 89:
                switch (c)
                {
                    case 48: return 102;
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 90:
                switch (c)
                {
                    case 48: return 102;
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 91:
                switch (c)
                {
                    case 48: return 102;
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 92:
                switch (c)
                {
                    case 48: return 102;
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 93:
                switch (c)
                {
                    case 48: return 102;
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 94:
                switch (c)
                {
                    case 48: return 102;
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 95:
                switch (c)
                {
                    case 48: return 102;
                    case 49: return 102;
                    case 50: return 102;
                    case 51: return 102;
                    case 52: return 102;
                    case 53: return 102;
                    case 54: return 102;
                    case 55: return 102;
                    case 56: return 102;
                    case 57: return 102;
                    default: return -1;
                }
            case 97:
                switch (c)
                {
                    case 48: return 103;
                    case 49: return 103;
                    case 50: return 103;
                    case 51: return 103;
                    case 52: return 103;
                    case 53: return 103;
                    case 54: return 103;
                    case 55: return 103;
                    case 56: return 103;
                    case 57: return 103;
                    default: return -1;
                }
            case 98:
                switch (c)
                {
                    case 107: return 104;
                    default: return -1;
                }
            case 99:
                switch (c)
                {
                    case 107: return 105;
                    default: return -1;
                }
            case 100:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 106;
                    case 50: return 106;
                    case 51: return 106;
                    case 52: return 106;
                    case 53: return 106;
                    case 54: return 106;
                    case 55: return 106;
                    case 56: return 106;
                    case 57: return 106;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 101:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 103:
                switch (c)
                {
                    case 44: return 107;
                    default: return -1;
                }
            case 104:
                switch (c)
                {
                    case 109: return 36;
                    default: return -1;
                }
            case 105:
                switch (c)
                {
                    case 109: return 36;
                    default: return -1;
                }
            case 106:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 108;
                    case 66: return 108;
                    case 67: return 108;
                    case 68: return 108;
                    case 69: return 108;
                    case 70: return 108;
                    case 71: return 108;
                    case 72: return 108;
                    case 73: return 108;
                    case 74: return 108;
                    case 75: return 108;
                    case 76: return 108;
                    case 77: return 108;
                    case 78: return 108;
                    case 79: return 108;
                    case 80: return 108;
                    case 81: return 108;
                    case 82: return 108;
                    case 83: return 108;
                    case 84: return 108;
                    case 85: return 108;
                    case 86: return 108;
                    case 87: return 108;
                    case 88: return 108;
                    case 89: return 108;
                    case 90: return 108;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 107:
                switch (c)
                {
                    case 48: return 109;
                    case 49: return 109;
                    case 50: return 109;
                    case 51: return 109;
                    case 52: return 109;
                    case 53: return 109;
                    case 54: return 109;
                    case 55: return 109;
                    case 56: return 109;
                    case 57: return 109;
                    default: return -1;
                }
            case 108:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 110;
                    case 66: return 110;
                    case 67: return 110;
                    case 68: return 110;
                    case 69: return 110;
                    case 70: return 110;
                    case 71: return 110;
                    case 72: return 110;
                    case 73: return 110;
                    case 74: return 110;
                    case 75: return 110;
                    case 76: return 110;
                    case 77: return 110;
                    case 78: return 110;
                    case 79: return 110;
                    case 80: return 110;
                    case 81: return 110;
                    case 82: return 110;
                    case 83: return 110;
                    case 84: return 110;
                    case 85: return 110;
                    case 86: return 110;
                    case 87: return 110;
                    case 88: return 110;
                    case 89: return 110;
                    case 90: return 110;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 109:
                switch (c)
                {
                    case 48: return 96;
                    case 49: return 96;
                    case 50: return 96;
                    case 51: return 96;
                    case 52: return 96;
                    case 53: return 96;
                    case 54: return 96;
                    case 55: return 96;
                    case 56: return 96;
                    case 57: return 96;
                    default: return -1;
                }
            case 110:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 111;
                    case 49: return 111;
                    case 50: return 111;
                    case 51: return 111;
                    case 52: return 111;
                    case 53: return 111;
                    case 54: return 111;
                    case 55: return 111;
                    case 56: return 111;
                    case 57: return 111;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 111:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 112;
                    case 49: return 112;
                    case 50: return 112;
                    case 51: return 112;
                    case 52: return 112;
                    case 53: return 112;
                    case 54: return 112;
                    case 55: return 112;
                    case 56: return 112;
                    case 57: return 112;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 112:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 113;
                    case 49: return 113;
                    case 50: return 113;
                    case 51: return 113;
                    case 52: return 113;
                    case 53: return 113;
                    case 54: return 113;
                    case 55: return 113;
                    case 56: return 113;
                    case 57: return 113;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 113:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 114;
                    case 49: return 114;
                    case 50: return 114;
                    case 51: return 114;
                    case 52: return 114;
                    case 53: return 114;
                    case 54: return 114;
                    case 55: return 114;
                    case 56: return 114;
                    case 57: return 114;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 114:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 115;
                    case 49: return 115;
                    case 50: return 115;
                    case 51: return 115;
                    case 52: return 115;
                    case 53: return 115;
                    case 54: return 115;
                    case 55: return 115;
                    case 56: return 115;
                    case 57: return 115;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 115:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 116;
                    case 49: return 116;
                    case 50: return 116;
                    case 51: return 116;
                    case 52: return 116;
                    case 53: return 116;
                    case 54: return 116;
                    case 55: return 116;
                    case 56: return 116;
                    case 57: return 116;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 116:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            default: return -1;
        }
    }

    private int tokenForState(int state)
    {
        if (state < 0 || state >= TOKEN_STATE.length)
            return -1;

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key)
    {
        int start = SPECIAL_CASES_INDEXES[base];
        int end   = SPECIAL_CASES_INDEXES[base+1]-1;

        while (start <= end)
        {
            int half = (start+end)/2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0)
                return SPECIAL_CASES_VALUES[half];
            else if (comp < 0)
                start = half+1;
            else  //(comp > 0)
                end = half-1;
        }

        return base;
    }

    private boolean hasInput()
    {
        return position < input.length();
    }

    private char nextChar()
    {
        if (hasInput())
            return input.charAt(position++);
        else
            return (char) -1;
    }
   


}
