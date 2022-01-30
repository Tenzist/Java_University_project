package com.oleh.pakhomov.ex1;
    interface IMathFunction {
        public Double calculate(Double x);
    }


public class FunctionF implements IMathFunction {
   public Double calculate(Double x) {
      return x;

   }
}
