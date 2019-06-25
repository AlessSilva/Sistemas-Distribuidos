package ServidorComTodosServicos;

public class EsqueletoCalc {

    Calc calc;

    EsqueletoCalc(){ calc = new Calc(); }

    public String add( String args){
        String op[] = args.split(";");
        double result =  this.calc.add( Double.parseDouble(op[0]), Double.parseDouble(op[1]));
        return String.valueOf( result );
    }

    public String sub( String args){
        String op[] = args.split(";");
        double result =  this.calc.sub( Double.parseDouble(op[0]), Double.parseDouble(op[1]));
        return String.valueOf( result );
    }

    public String mult( String args){
        String op[] = args.split(";");
        double result =  this.calc.mult( Double.parseDouble(op[0]), Double.parseDouble(op[1]));
        return String.valueOf( result );
    }

    public String div( String args){
        String op[] = args.split(";");
        double result =  this.calc.div( Double.parseDouble(op[0]), Double.parseDouble(op[1]));
        return String.valueOf( result );
    }

}
