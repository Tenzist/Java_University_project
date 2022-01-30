package dynjava;
    interface IMathFunction {
        public Double calculate(Double x);
    }


public class FunctionF implements IMathFunction {
   public Double calculate(Double x) {
      return x;
   }
}
