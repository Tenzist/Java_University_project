package dynjava;
    interface IMathFunction {
        public Double calculate(Double x);
    }


public class FunctionG implements IMathFunction {
   public Double calculate(Double x) {
      return x;
   }
}
